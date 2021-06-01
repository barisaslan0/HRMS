package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	
	DataResult<JobPosition> getByName(String name);
	
	Result add(JobPosition jobPosition);
}
