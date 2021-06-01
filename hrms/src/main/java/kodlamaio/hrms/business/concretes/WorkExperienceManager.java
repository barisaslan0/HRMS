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
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.CV.Education;
import kodlamaio.hrms.entities.concretes.CV.WorkExperience;
import net.bytebuddy.asm.Advice.This;

@Service
public class WorkExperienceManager implements WorkExperienceService {

	private WorkExperienceDao workExperienceDao;

	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public Result add(WorkExperience workExperience) {
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("İş tecrübesi eklendi");
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
