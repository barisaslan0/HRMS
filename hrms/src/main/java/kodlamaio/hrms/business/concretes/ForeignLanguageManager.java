package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.CV.Education;
import kodlamaio.hrms.entities.concretes.CV.ForeignLanguage;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

	private ForeignLanguageDao foreignLanguageDao;
	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao, CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(ForeignLanguageDto foreignLanguagDto) {
		ForeignLanguage foreignLanguage = new ForeignLanguage();
		foreignLanguage.setForeignLanguageId(0);
		foreignLanguage.setCurriculumVitae(
				this.curriculumVitaeDao.getByCurriculumVitaeId(foreignLanguagDto.getCurriculumVitaeId()));
		foreignLanguage.setLanguage(foreignLanguagDto.getLanguage());
		foreignLanguage.setLevel(foreignLanguagDto.getLevel());

		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Yabancı dil eklendi");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll(),
				"Yabancı diller listelendi");
	}

}
