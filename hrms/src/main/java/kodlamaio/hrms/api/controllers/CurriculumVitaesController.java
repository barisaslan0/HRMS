package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.CurriculumVitaeDto;

@RestController
@RequestMapping("/api/curriculumvitaes")
@CrossOrigin
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CurriculumVitaeDto curriculumVitaeDto) {
		return this.curriculumVitaeService.add(curriculumVitaeDto);
	}

	@GetMapping("/getbyjobseekerid")
	public DataResult<List<CurriculumVitae>> getByJobseekerId(@RequestParam int jobseekerId) {
		return this.curriculumVitaeService.getByJobseekerId(jobseekerId);
	}

	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll() {
		return this.curriculumVitaeService.getAll();
	}

	@GetMapping("/getbycurriculumvitaeid")
	public DataResult<CurriculumVitae> getBuCurriculumVitaeId(int curriculumVitaeId) {
		return this.curriculumVitaeService.getByCurriculumVitaeId(curriculumVitaeId);
	}

	@DeleteMapping("/delete")
	public Result delete(int curriculumVitaeId) {
		return this.curriculumVitaeService.delete(curriculumVitaeId);
	}

}
