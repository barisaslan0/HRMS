package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.CV.ForeignLanguage;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;

public interface ForeignLanguageService {
	Result add(ForeignLanguageDto foreignLanguageDto);

	Result update(ForeignLanguageDto foreignLanguageDto);

	Result delete(int foreignLanguageId);

	DataResult<List<ForeignLanguage>> getAll();
}
