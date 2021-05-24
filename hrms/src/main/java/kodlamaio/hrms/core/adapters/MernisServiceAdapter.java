package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class MernisServiceAdapter implements CheckUserService {

	@Override
	public boolean checkIfRealPerson(Jobseeker jobseeker) {
		// simulation
		if (jobseeker.getIdentityNumber() == jobseeker.getIdentityNumber()
				&& jobseeker.getFirstname() == jobseeker.getFirstname()
				&& jobseeker.getLastName() == jobseeker.getLastName()
				&& jobseeker.getBirthYear() == jobseeker.getBirthYear()) {
			return true;
		}
		return false;
	}

}
