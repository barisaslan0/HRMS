package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.User;

public interface CheckUserService {
	
	boolean checkIfRealPerson(Jobseeker jobseeker);
}
