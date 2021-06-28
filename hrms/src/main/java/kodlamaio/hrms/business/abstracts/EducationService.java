package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.w3c.dom.ls.LSInput;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.CV.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;

public interface EducationService {
	Result add(EducationDto educationDto);

	Result update(EducationDto educationDto);

	Result delete(int educationId);

	DataResult<List<Education>> getAll();

	DataResult<List<Education>> sortByEndYearOfSchool();
}
