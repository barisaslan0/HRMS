package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.CV.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguagesController {

	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody ForeignLanguage foreignLanguage) {
		return this.foreignLanguageService.add(foreignLanguage);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ForeignLanguage>> getAll() {
		return this.foreignLanguageService.getAll();
	}

}
