package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.CV.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

@Service
public class WorkExperienceManager implements WorkExperienceService {

	private WorkExperienceDao workExperienceDao;
	private CurriculumVitaeDao curriculumVitaeDao;
	private JobPositionDao jobPositionDao;

	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao, CurriculumVitaeDao curriculumVitaeDao,
			JobPositionDao jobPositionDao) {
		super();
		this.workExperienceDao = workExperienceDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.jobPositionDao = jobPositionDao;

	}

	@Override
	public Result add(WorkExperienceDto workExperienceDto) {
		WorkExperience workExperience = new WorkExperience();
		workExperience.setWorkExperienceId(0);
		workExperience.setCurriculumVitae(
				this.curriculumVitaeDao.getByCurriculumVitaeId(workExperienceDto.getCurriculumVitaeId()));
		workExperience.setWorkplaceName(workExperienceDto.getWorkplaceName());
		workExperience.setJobPosition(this.jobPositionDao.getByJobPositionId(workExperienceDto.getJobPositionId()));
		workExperience.setStartDateOfWork(workExperienceDto.getStartDateOfWork());
		workExperience.setEndDateOfWork(workExperienceDto.getEndDateOfWork());
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("İş tecrübesi eklendi");
	}

	@Override
	public Result update(WorkExperienceDto workExperienceDto) {
		WorkExperience workExperienceToUpdate = this.workExperienceDao
				.getByWorkExperienceId(workExperienceDto.getWorkExperienceId());
		workExperienceToUpdate.setWorkplaceName(workExperienceDto.getWorkplaceName());
		workExperienceToUpdate
				.setJobPosition(this.jobPositionDao.getByJobPositionId(workExperienceDto.getJobPositionId()));
		workExperienceToUpdate.setStartDateOfWork(workExperienceDto.getStartDateOfWork());
		workExperienceToUpdate.setEndDateOfWork(workExperienceDto.getEndDateOfWork());
		this.workExperienceDao.save(workExperienceToUpdate);
		return new SuccessResult("İş deneyimi güncellendi");
	}

	@Override
	public Result delete(int workExperienceId) {
		this.workExperienceDao.deleteById(workExperienceId);
		return new SuccessResult("İş Deneyimi Silindi");
	}

	@Override
	public DataResult<List<WorkExperience>> sortByEndYearOfWork() {
		Sort sort = Sort.by(Sort.Direction.DESC, "endYearOfWork");
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(sort));
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(),
				"İş tecrübeleri listelendi");
	}
}
