package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Favorite;
import kodlamaio.hrms.entities.dtos.FavoriteDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class FavoriteManager implements FavoriteService {
	private FavoriteDao favoriteDao;
	private JobseekerDao jobseekerDao;
	private JobPostingDao jobPostingDao;

	@Autowired
	public FavoriteManager(FavoriteDao favoriteDao, JobseekerDao jobseekerDao, JobPostingDao jobPostingDao) {
		super();
		this.favoriteDao = favoriteDao;
		this.jobseekerDao = jobseekerDao;
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(FavoriteDto favoriteDto) {
		Favorite favorite = new Favorite();

		favorite.setJobseeker(this.jobseekerDao.getByUserId(favoriteDto.getJobseekerId()));
		favorite.setJobPosting(this.jobPostingDao.getByJobPostingId(favoriteDto.getJobPostingId()));
		this.favoriteDao.save(favorite);
		return new SuccessResult("Favori Eklendi");
	}

	@Override
	public Result delete(int favoriteId) {
		this.favoriteDao.deleteById(favoriteId);
		return new SuccessResult("Favoriden çıkarıldı");
	}

	@Override
	public DataResult<List<Favorite>> getByJobseekerId(int jobseekerId) {
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.getByJobseeker_UserId(jobseekerId));
	}

}
