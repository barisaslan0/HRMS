package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.CheckUserService;
import kodlamaio.hrms.core.helpers.emailVerification.EmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class JobseekerManager implements JobseekerService {

	private JobseekerDao jobseekerDao;
	private UserService userService;
	private CheckUserService checkUserService;
	private EmailService emailService;

	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao, UserService userService, CheckUserService checkUserService,
			EmailService emailService) {
		super();
		this.jobseekerDao = jobseekerDao;
		this.userService = userService;
		this.checkUserService = checkUserService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll(), "İş arayanlar listelendi");
	}

	@Override
	public DataResult<Jobseeker> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.findByIdentityNumber(identityNumber));
	}

	@Override
	public Result add(Jobseeker jobseeker) {

//		if (!isFilledAllInformation(jobseeker.getFirstname(), jobseeker.getLastName(), jobseeker.getIdentityNumber(),
//				jobseeker.getBirthYear(), jobseeker.getEmail(), jobseeker.getPassword(), jobseeker.getPassword_again())
//						.isSuccess()) {
//			return new ErrorResult("Tüm alanlar doldurulmalıdır!");
		if (!existEmail(jobseeker.getEmail()).isSuccess()) {
			return existEmail(jobseeker.getEmail());
		} else if (!existIdentitynumber(jobseeker.getIdentityNumber()).isSuccess()) {
			return existIdentitynumber(jobseeker.getIdentityNumber());
		} else if (!isVerifyPassword(jobseeker.getPassword(), jobseeker.getPassword_again()).isSuccess()) {
			return new ErrorResult("Şifre eşleşmedi!");
		} else if (!checkUserService.checkIfRealPerson(jobseeker)) {
			return new ErrorResult("Mernis doğrulama hatalı!");
		} else if (!emailService.isVerified(jobseeker.isVerifyEmail())) {
			return new ErrorResult("Email doğrulanamadı!");
		}
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Kayıt işlemi başarılı");
	}

	public Result existEmail(String email) {
		if (this.userService.getByEmail(email).getData() == null) {
			return new SuccessResult();
		}
		return new ErrorResult("Email daha önce kullanılmış!");
	}

	public Result existIdentitynumber(String identityNumber) {
		if (this.getByIdentityNumber(identityNumber).getData() == null) {
			return new SuccessResult();
		}
		return new ErrorResult("Kimlik numarası daha önce kullanılmış!");
	}

	public Result isFilledAllInformation(String firstName, String lastName, String identityNumber, int birthYear,
			String email, String password, String passwordAgain) {
		if (firstName.length() > 0 && lastName.length() > 0 && identityNumber.length() > 0 && email.length() > 0
				&& birthYear > 0 && email.length() > 0 && password.length() > 0 && passwordAgain.length() > 0) {
			return new SuccessResult();
		}
		return new ErrorResult("Tüm alanlar doldurulmalıdır!");
	}

	public Result isVerifyPassword(String password, String passwordAgain) {
		if (password.equals(passwordAgain)) {
			return new SuccessResult();
		}
		return new ErrorResult("Şifre eşleşmedi!");
	}

}
