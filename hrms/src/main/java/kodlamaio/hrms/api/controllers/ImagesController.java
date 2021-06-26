package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.helpers.file.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {

	private ImageService imageService;
	private CloudinaryService cloudinaryService;

	@Autowired
	public ImagesController(ImageService imageService, CloudinaryService cloudinaryService) {
		super();
		this.imageService = imageService;
		this.cloudinaryService = cloudinaryService;
	}

	@PostMapping("/add")
	public Result addUserImage(@RequestParam MultipartFile multipartFile, @RequestParam int userId) throws IOException {
		Map result = this.cloudinaryService.upload(multipartFile);
		Image image = new Image((String) result.get("original_filename"), (String) result.get("url"),
				(String) result.get("public_id"), new User(userId));
		return this.imageService.add(image);
	}

	@DeleteMapping("/delete/{imageId}")
	public Result delete(@PathVariable("imageId") int imageId) throws IOException {
		Image image = this.imageService.getByImageId(imageId).getData();
		Map result = this.cloudinaryService.delete(image.getPublicId());
		return this.imageService.delete(imageId);
	}

	@GetMapping("/getall")
	public DataResult<List<Image>> getAll() {
		return this.imageService.getAll();
	}

}
