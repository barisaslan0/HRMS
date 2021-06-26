package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.CoverLetter;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;

@RestController
@RequestMapping("/api/coverletters")
@CrossOrigin
public class CoverLettersController {
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterDto coverLetterDto) {
		return this.coverLetterService.add(coverLetterDto);
	}

	@PostMapping("/update")
	public Result update(@RequestBody CoverLetterDto coverLetterDto) {
		return this.coverLetterService.update(coverLetterDto);
	}

}
