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

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

@RestController
@RequestMapping("/api/workexperiences")
@CrossOrigin
public class WorkExperiencesController {

	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody WorkExperienceDto workExperienceDto) {
		return this.workExperienceService.add(workExperienceDto);
	}

	@PutMapping("/update")
	public Result update(@RequestBody WorkExperienceDto workExperienceDto) {
		return this.workExperienceService.update(workExperienceDto);
	}

	@DeleteMapping("/delete")
	public Result update(@RequestParam int workExperienceId) {
		return this.workExperienceService.delete(workExperienceId);
	}

	@GetMapping("/getall")
	public DataResult<List<WorkExperience>> getAll() {
		return this.workExperienceService.getAll();
	}

}
