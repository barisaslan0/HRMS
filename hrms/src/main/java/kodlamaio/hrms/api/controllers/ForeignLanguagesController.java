package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.CV.ForeignLanguage;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;

@RestController
@RequestMapping("/api/foreignlanguages")
@CrossOrigin
public class ForeignLanguagesController {

	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody ForeignLanguageDto foreignLanguageDto) {
		return this.foreignLanguageService.add(foreignLanguageDto);
	}

	@PutMapping("/update")
	public Result update(@RequestBody ForeignLanguageDto foreignLanguageDto) {
		return this.foreignLanguageService.update(foreignLanguageDto);
	}

	@DeleteMapping("/delete")
	public Result update(@RequestParam int foreignLanguageId) {
		return this.foreignLanguageService.delete(foreignLanguageId);
	}

	@GetMapping("/getall")
	public DataResult<List<ForeignLanguage>> getAll() {
		return this.foreignLanguageService.getAll();
	}

}
