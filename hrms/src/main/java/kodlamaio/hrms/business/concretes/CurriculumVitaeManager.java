package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.CurriculumVitaeDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("CV eklendi");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getByJobseekerId(int jobseekerId) {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.getByJobseeker_UserId(jobseekerId),
				"İş arayana ait CV listelendi");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "CV'ler listelendi");
	}

//	@Override
//	public DataResult<List<CurriculumVitaeDto>> getCurriculumVitaeDetails() {
//		return new SuccessDataResult<List<CurriculumVitaeDto>>(this.curriculumVitaeDao.getCurriculumVitaeDetails());
//	}

}
