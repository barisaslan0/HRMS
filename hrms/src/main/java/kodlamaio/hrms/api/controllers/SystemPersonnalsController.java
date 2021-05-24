package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemPersonnalService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.SystemPersonnal;

@RestController
@RequestMapping("/api/systempersonnals")
public class SystemPersonnalsController {

	private SystemPersonnalService systemPersonnalService;

	@Autowired
	public SystemPersonnalsController(SystemPersonnalService systemPersonnalService) {
		super();
		this.systemPersonnalService = systemPersonnalService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemPersonnal>> getAll() {
		return this.systemPersonnalService.getAll();
	}
}
