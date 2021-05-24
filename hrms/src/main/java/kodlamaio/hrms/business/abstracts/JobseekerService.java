package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface JobseekerService {
	DataResult<List<Jobseeker>> getAll();
	
	DataResult<Jobseeker> getByIdentityNumber(String identityNumber);
	
	Result add(Jobseeker jobseeker);
}
