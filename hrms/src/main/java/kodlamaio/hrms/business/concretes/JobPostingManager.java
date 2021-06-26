package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
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
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(), "İş ilanları listelendi");
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
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobPosting>> sortByReleaseDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "releaseDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort),
				"Yayın tarihine göre artan olarak listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByEmployer_CompanyName(companyName),
				"Şirket adına göre iş ilanları listelendi");
	}

	@Override
	public Result updateIsActive(boolean isActive, int userId, int jobPostingId) {
		this.jobPostingDao.updateIsActive(isActive, userId, jobPostingId);
		return new SuccessResult("İş ilanı aktiflik durumu güncellendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByIsConfirm(boolean isConfirm) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByIsConfirm(isConfirm));
	}

	@Override
	public DataResult<List<JobPosting>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive) {
		return new SuccessDataResult<List<JobPosting>>(
				this.jobPostingDao.getByIsConfirmAndIsActive(isConfirm, isActive));
	}

	@Override
	public Result updateIsConfirm(boolean isConfirm, int jobPostingId) {
		this.jobPostingDao.updateIsConfirm(isConfirm, jobPostingId);
		return new SuccessResult("İş ilanı onaylandı");
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

}
