package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CV.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {
	Account getByAccountId(int accountId);
}
