package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.source.util.TreePathScanner;

import kodlamaio.hrms.business.abstracts.SystemPersonnalService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnal;
import kodlamaio.hrms.entities.dtos.SystemPersonnalDto;

@RestController
@RequestMapping("/api/systempersonnals")
@CrossOrigin
public class SystemPersonnalsController {

	private SystemPersonnalService systemPersonnalService;

	@Autowired
	public SystemPersonnalsController(SystemPersonnalService systemPersonnalService) {
		super();
		this.systemPersonnalService = systemPersonnalService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody SystemPersonnalDto systemPersonnalDto) {
		return this.systemPersonnalService.add(systemPersonnalDto);
	}

	@PutMapping("/update")
	public Result update(@RequestBody SystemPersonnalDto systemPersonnalDto) {
		return this.systemPersonnalService.update(systemPersonnalDto);
	}

	@GetMapping("/getbyuserid")
	public Result getByUserId(@RequestParam int userId) {
		return this.systemPersonnalService.getByUserId(userId);
	}
}
