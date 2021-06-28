package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Favorite;
import kodlamaio.hrms.entities.dtos.FavoriteDto;

public interface FavoriteService {
	Result add(FavoriteDto favoriteDto);
	
	Result delete(int favoriteId);

	DataResult<List<Favorite>> getByJobseekerId(int jobseekerId);
}
