package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.helpers.emailVerification.EmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserService userService;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {

		if (!isFilledAllInformation(employer.getCompanyName(), employer.getWebSite(), employer.getEmail(),
				employer.getPhoneNumber(), employer.getPassword(), employer.getPassword_again()).isSuccess()) {
			return new ErrorResult("Tüm alanlar doldurulmalıdır!");
		} else if (!existEmail(employer.getEmail()).isSuccess()) {
			return existEmail(employer.getEmail());
		} else if (!isVerifyPassword(employer.getPassword(), employer.getPassword_again()).isSuccess()) {
			return new ErrorResult("Şifre eşleşmedi!");
		} else if (!emailService.isVerified(employer.isVerifyEmail())) {
			return new ErrorResult("Email doğrulanamadı!");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Kayıt işlemi başarılı");
	}

	public Result isFilledAllInformation(String companyName, String webSite, String email, String phoneNumber,
			String password, String passwordAgain) {
		if (companyName.length() > 0 && webSite.length() > 0 && email.length() > 0 && phoneNumber.length() > 0
				&& password.length() > 0 && passwordAgain.length() > 0) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}

	public Result existEmail(String email) {
		if (this.userService.getByEmail(email).getData() == null) {
			return new SuccessResult();
		}
		return new ErrorResult("Email daha önce kullanılmış!");
	}

	public Result isVerifyPassword(String password, String passwordAgain) {
		if (password.equals(passwordAgain)) {
			return new SuccessResult();
		}
		return new ErrorResult("Şifre eşleşmedi!");
	}

}
