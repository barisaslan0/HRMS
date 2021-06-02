package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/jobpostings")
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

	@GetMapping("/sortbyreleasedate")
	public DataResult<List<JobPosting>> sortByReleaseDate() {
		return this.jobPostingService.sortByReleaseDate();
	}

	@GetMapping("/getbycompanyname")
	public DataResult<List<JobPosting>> getByCompanyName(@RequestParam String companyName) {
		return this.jobPostingService.getByCompanyName(companyName);
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}

	@PostMapping("/updateisactive")
	public Result updateIsActive(@RequestParam boolean isActive, @RequestParam int userId,@RequestParam int jobPostingId) {
		return this.jobPostingService.updateIsActive(isActive, userId,jobPostingId);
	}

}
