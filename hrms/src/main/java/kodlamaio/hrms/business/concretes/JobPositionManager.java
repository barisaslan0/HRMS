package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "iş pozisyonları listelendi");
	}

	@Override
	public DataResult<JobPosition> getByName(String name) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByName(name));
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (!isFilled(jobPosition.getName()).isSuccess()) {
			return new ErrorResult("Alan doldurulmalı!");
		} else if (!existName(jobPosition.getName()).isSuccess()) {
			return new ErrorResult("Bu iş pozisyonu daha önce eklenmiş!");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu başarıyla eklendi");
	}

	public Result existName(String name) {
		if (this.getByName(name).getData() == null) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}

	public Result isFilled(String name) {
		if (name.length() > 0) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}

}
