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

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.CV.Technology;
import kodlamaio.hrms.entities.dtos.EducationDto;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TechnologiesController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody TechnologyDto technologyDto) {
		return this.technologyService.add(technologyDto);
	}

	@PutMapping("/update")
	public Result update(@RequestBody TechnologyDto technologyDto) {
		return this.technologyService.update(technologyDto);
	}

	@DeleteMapping("/delete")
	public Result update(@RequestParam int technologyId) {
		return this.technologyService.delete(technologyId);
	}

	@GetMapping("/getall")
	public DataResult<List<Technology>> getAll() {
		return this.technologyService.getAll();
	}
}
