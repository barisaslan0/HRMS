package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AccountService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.AccountDto;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin
public class AccountsController {
	private AccountService accountService;

	@Autowired
	public AccountsController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody AccountDto accountDto) {
		return this.accountService.add(accountDto);
	}

	@PutMapping("/update")
	public Result update(@RequestBody AccountDto accountDto) {
		return this.accountService.update(accountDto);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int accountId) {
		return this.accountService.delete(accountId);
	}
}
