package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(), "İş ilanları listelendi");
	}

	@Override
	public Result add(JobPosting jobPosting) {
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

}
