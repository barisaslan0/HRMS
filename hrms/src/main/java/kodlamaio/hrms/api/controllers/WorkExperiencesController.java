package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.WorkExperience;

@RestController
@RequestMapping("/api/workexperiences")
public class WorkExperiencesController {

	private WorkExperienceService wokExperienceService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService wokExperienceService) {
		super();
		this.wokExperienceService = wokExperienceService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody WorkExperience workExperience) {
		return this.wokExperienceService.add(workExperience);
	}

	@GetMapping("/getall")
	public DataResult<List<WorkExperience>> getAll() {
		return this.wokExperienceService.getAll();
	}

}
