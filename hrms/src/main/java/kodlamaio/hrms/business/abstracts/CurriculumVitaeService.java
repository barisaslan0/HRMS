package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.CurriculumVitaeDto;

public interface CurriculumVitaeService {
	Result add(CurriculumVitaeDto curriculumVitaeDto);

	DataResult<List<CurriculumVitae>> getAll();

	DataResult<List<CurriculumVitae>> getByJobseekerId(int jobseekerId);

	DataResult<CurriculumVitae> getByCurriculumVitaeId(int curriculumVitaeId);
}
