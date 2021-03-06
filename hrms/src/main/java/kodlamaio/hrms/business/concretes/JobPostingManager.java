package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDto;
import kodlamaio.hrms.entities.dtos.JobPostingFilter;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	private EmployerDao employerDao;
	private JobPositionDao jobPositionDao;
	private CityDao cityDao;
	private WorkTypeDao workTypeDao;
	private WorkTimeDao workTimeDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, EmployerDao employerDao, JobPositionDao jobPositionDao,
			CityDao cityDao, WorkTypeDao workTypeDao, WorkTimeDao workTimeDao) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.employerDao = employerDao;
		this.jobPositionDao = jobPositionDao;
		this.cityDao = cityDao;
		this.workTypeDao = workTypeDao;
		this.workTimeDao = workTimeDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(), "???? ilanlar?? listelendi");
	}

	@Override
	public Result add(JobPostingDto jobPostingDto) {
		JobPosting jobPosting = new JobPosting();
		jobPosting.setJobPostingId(0);
		jobPosting.setJobDescription(jobPostingDto.getJobDescription());
		jobPosting.setMinSalary(jobPostingDto.getMinSalary());
		jobPosting.setMaxSalary(jobPostingDto.getMaxSalary());
		jobPosting.setNumberOfOpenPosition(jobPostingDto.getNumberOfOpenPosition());
		jobPosting.setReleaseDate(LocalDate.now());
		jobPosting.setDeadline(jobPostingDto.getDeadline());
		jobPosting.setActive(true);
		jobPosting.setConfirm(false);
		jobPosting.setEmployer(this.employerDao.getByUserId(jobPostingDto.getEmployerId()));
		jobPosting.setJobPosition(this.jobPositionDao.getByJobPositionId(jobPostingDto.getJobPositionId()));
		jobPosting.setCity(this.cityDao.getByCityId(jobPostingDto.getCityId()));
		jobPosting.setWorkType(this.workTypeDao.getByWorkTypeId(jobPostingDto.getWorkTypeId()));
		jobPosting.setWorkTime(this.workTimeDao.getByWorkTimeId(jobPostingDto.getWorkTimeId()));
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("???? ilan?? eklendi");
	}

	@Override
	public DataResult<List<JobPosting>> sortByReleaseDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "releaseDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort),
				"Yay??n tarihine g??re artan olarak listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByEmployer_CompanyName(companyName),
				"??irket ad??na g??re i?? ilanlar?? listelendi");
	}

	@Override
	public Result updateIsActive(boolean isActive, int userId, int jobPostingId) {
		this.jobPostingDao.updateIsActive(isActive, userId, jobPostingId);
		return new SuccessResult("???? ilan?? aktiflik durumu g??ncellendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, int pageNo,
			int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPosting>>(
				this.jobPostingDao.getByIsConfirmAndIsActive(isConfirm, isActive, pageable).getContent(),
				this.jobPostingDao.getByIsConfirmAndIsActive(isConfirm, isActive, pageable).getTotalPages() + "");
	}

	@Override
	public Result updateIsConfirm(boolean isConfirm, int jobPostingId) {
		this.jobPostingDao.updateIsConfirm(isConfirm, jobPostingId);
		return new SuccessResult("???? ilan?? onayland??");
	}

	@Override
	public DataResult<JobPosting> getByJobPostingId(int jobPostingId) {
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getByJobPostingId(jobPostingId));
	}

	@Override
	public DataResult<JobPosting> getByIsConfirmAndJobPostingId(boolean isConfirm, int jobPostingId) {
		return new SuccessDataResult<JobPosting>(
				this.jobPostingDao.getByIsConfirmAndJobPostingId(isConfirm, jobPostingId));
	}

	@Override
	public DataResult<List<JobPosting>> getByFilter(JobPostingFilter jobPostingFilter, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPosting>>(
				this.jobPostingDao.getByFilter(jobPostingFilter, pageable).getContent(),
				this.jobPostingDao.getByFilter(jobPostingFilter, pageable).getTotalPages() + "");
	}

}
