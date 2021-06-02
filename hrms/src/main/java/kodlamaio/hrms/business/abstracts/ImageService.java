package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.CV.Education;

public interface ImageService {
	Result add(Image image);

	Result delete(int imageId);

	DataResult<List<Image>> getAll();

	DataResult<Image> getByImageId(int imageId);
}
