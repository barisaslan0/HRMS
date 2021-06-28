package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

public interface TechnologyService {
	Result add(TechnologyDto technologyDto);

	Result update(TechnologyDto technologyDto);

	Result delete(int technologyId);

	DataResult<List<Technology>> getAll();
}
