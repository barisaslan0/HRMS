package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;

public interface CoverLetterService {
	Result add(CoverLetterDto coverLetterDto);

	Result update(CoverLetterDto coverLetterDto);
}
