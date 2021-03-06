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

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.CV.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody EducationDto educationDto) {
		return this.educationService.add(educationDto);
	}

	@PutMapping("/update")
	public Result update(@Valid @RequestBody EducationDto educationDto) {
		return this.educationService.update(educationDto);
	}

	@DeleteMapping("/delete")
	public Result update(@RequestParam int educationId) {
		return this.educationService.delete(educationId);
	}

	@GetMapping("/getall")
	public DataResult<List<Education>> getAll() {
		return this.educationService.getAll();
	}

}
