package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkTime;

@RestController
@RequestMapping("/api/worktimes")
@CrossOrigin
public class WorkTimesController {

	private WorkTimeService workTimeService;

	@Autowired
	public WorkTimesController(WorkTimeService workTimeService) {
		super();
		this.workTimeService = workTimeService;
	}

	@GetMapping("/getall")
	public DataResult<List<WorkTime>> getAll() {
		return this.workTimeService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody WorkTime workTime) {
		return this.workTimeService.add(workTime);
	}
}
