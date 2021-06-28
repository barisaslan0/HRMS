package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnal;
import kodlamaio.hrms.entities.dtos.SystemPersonnalDto;

public interface SystemPersonnalService {
	Result add(SystemPersonnalDto systemPersonnalDto);

	Result update(SystemPersonnalDto systemPersonnalDto);

	DataResult<SystemPersonnal> getByUserId(int userId);
}
