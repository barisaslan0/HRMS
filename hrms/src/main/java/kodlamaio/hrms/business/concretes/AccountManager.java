package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AccountService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AccountDao;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CV.Account;
import kodlamaio.hrms.entities.dtos.AccountDto;

@Service
public class AccountManager implements AccountService {

	private AccountDao accountDao;
	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public AccountManager(AccountDao accountDao, CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.accountDao = accountDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(AccountDto accountDto) {
		Account account = new Account();

		account.setCurriculumVitae(this.curriculumVitaeDao.getByCurriculumVitaeId(accountDto.getCurriculumVitaeId()));
		account.setLinkedinAccount(accountDto.getLinkedinAccount());
		account.setGithubAccount(accountDto.getGithubAccount());

		this.accountDao.save(account);
		return new SuccessResult("Hesaplar Eklendi");
	}

	@Override
	public Result update(AccountDto accountDto) {
		Account accountToUpdate = this.accountDao.getByAccountId(accountDto.getAccountId());

		accountToUpdate.setLinkedinAccount(accountDto.getLinkedinAccount());
		accountToUpdate.setGithubAccount(accountDto.getGithubAccount());

		this.accountDao.save(accountToUpdate);
		return new SuccessResult("Hesaplar Güncellendi");
	}

	@Override
	public Result delete(int accountId) {
		this.accountDao.deleteById(accountId);
		return new SuccessResult("Hesaplar Silindi");
	}

}
