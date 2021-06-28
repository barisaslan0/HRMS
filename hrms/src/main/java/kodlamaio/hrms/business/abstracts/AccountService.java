package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.Account;
import kodlamaio.hrms.entities.dtos.AccountDto;

public interface AccountService {
	Result add(AccountDto accountDto);

	Result update(AccountDto accountDto);

	Result delete(int accountId);
}
