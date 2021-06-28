package kodlamaio.hrms.api.controllers;

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

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Favorite;
import kodlamaio.hrms.entities.dtos.FavoriteDto;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoritesController {

	private FavoriteService favoriteService;

	@Autowired
	public FavoritesController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody FavoriteDto favoriteDto) {
		return this.favoriteService.add(favoriteDto);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int favoriteId) {
		return this.favoriteService.delete(favoriteId);
	}

	@GetMapping("/getbyjobseekerid")
	public Result getByJobseekerId(@RequestParam int jobseekerId) {
		return this.favoriteService.getByJobseekerId(jobseekerId);
	}

}
