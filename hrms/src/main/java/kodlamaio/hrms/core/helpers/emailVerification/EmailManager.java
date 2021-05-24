package kodlamaio.hrms.core.helpers.emailVerification;

import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

	@Override
	public boolean isVerified(Boolean isVerifyEmail) {
		if (isVerifyEmail) {
			return true;
		}
		return false;
	}
}
