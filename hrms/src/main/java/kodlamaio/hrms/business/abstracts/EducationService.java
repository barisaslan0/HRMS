package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.w3c.dom.ls.LSInput;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.CV.Education;

public interface EducationService {
	Result add(Education education);
	
	DataResult<List<Education>> getAll();
	
	DataResult<List<Education>> sortByEndYearOfSchool();
}
