package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.helpers.file.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.CV.Education;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;

	@Autowired
	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}

	@Override
	public Result add(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("Resim yüklendi");
	}

	@Override
	public Result delete(int imageId) {
		this.imageDao.deleteById(imageId);
		return new SuccessResult("Resim silindi");
	}

	@Override
	public DataResult<Image> getByImageId(int imageId) {
		return new SuccessDataResult<Image>(this.imageDao.getByImageId(imageId));
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), "Resimler listelendi");
	}

}
