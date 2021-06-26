package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("/api/jobpostings")
@CrossOrigin
public class JobPostingsController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}

	@GetMapping("/getbyisconfirm")
	public DataResult<List<JobPosting>> getByIsActive(@RequestParam boolean isConfirm) {
		return this.jobPostingService.getByIsConfirm(isConfirm);
	}

	@GetMapping("/getbyisconfirmandisactive")
	public DataResult<List<JobPosting>> getByIsConfirmAndIsActive(@RequestParam boolean isConfirm,
			@RequestParam boolean isActive) {
		return this.jobPostingService.getByIsConfirmAndIsActive(isConfirm, isActive);
	}

	@GetMapping("/sortbyreleasedate")
	public DataResult<List<JobPosting>> sortByReleaseDate() {
		return this.jobPostingService.sortByReleaseDate();
	}

	@GetMapping("/getbycompanyname")
	public DataResult<List<JobPosting>> getByCompanyName(@RequestParam String companyName) {
		return this.jobPostingService.getByCompanyName(companyName);
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobPostingDto jobPostingDto) {
		return this.jobPostingService.add(jobPostingDto);
	}

	@PostMapping("/updateisactive")
	public Result updateIsActive(@RequestParam boolean isActive, @RequestParam int userId,
			@RequestParam int jobPostingId) {
		return this.jobPostingService.updateIsActive(isActive, userId, jobPostingId);
	}

	@PostMapping("/updateisconfirm")
	public Result updateIsConfirm(@RequestParam boolean isConfirm, @RequestParam int jobPostingId) {
		return this.jobPostingService.updateIsConfirm(isConfirm, jobPostingId);
	}

	@GetMapping("/getbyjobpostingid")
	public DataResult<JobPosting> getByJobPostingId(@RequestParam int jobPostingId) {
		return this.jobPostingService.getByJobPostingId(jobPostingId);
	}

	@GetMapping("/getbyisconfirmandjobpostingid")
	public DataResult<JobPosting> getByIsConfirmAndJobPostingId(@RequestParam boolean isConfirm,
			@RequestParam int jobPostingId) {
		return this.jobPostingService.getByIsConfirmAndJobPostingId(isConfirm, jobPostingId);
	}
}
