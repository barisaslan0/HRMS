package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class MernisServiceAdapter implements CheckUserService {

	@Override
	public boolean checkIfRealPerson(Jobseeker jobseeker) {
		// simulation
		if (jobseeker.getIdentityNumber() == jobseeker.getIdentityNumber()
				&& jobseeker.getFirstName() == jobseeker.getFirstName()
				&& jobseeker.getLastName() == jobseeker.getLastName()
				&& jobseeker.getBirthDate() == jobseeker.getBirthDate()) {
			return true;
		}
		return false;
	}

}
