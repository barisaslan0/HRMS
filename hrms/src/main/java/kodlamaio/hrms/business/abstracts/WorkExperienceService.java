package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.Education;
import kodlamaio.hrms.entities.concretes.CV.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

public interface WorkExperienceService {
	Result add(WorkExperienceDto workExperienceDto);
	
	Result update(WorkExperienceDto workExperienceDto);

	DataResult<List<WorkExperience>> getAll();

	DataResult<List<WorkExperience>> sortByEndYearOfWork();
}
