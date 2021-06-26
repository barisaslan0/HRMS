package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();

	DataResult<List<JobPosting>> getByIsConfirm(boolean isConfirm);

	DataResult<List<JobPosting>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);

	DataResult<List<JobPosting>> sortByReleaseDate();

	DataResult<List<JobPosting>> getByCompanyName(String companyName);

	DataResult<JobPosting> getByJobPostingId(int jobPostingId);

	DataResult<JobPosting> getByIsConfirmAndJobPostingId(boolean isConfirm, int jobPostingId);

	Result add(JobPostingDto jobPostingDto);

	Result updateIsConfirm(boolean isConfirm, int jobPostingId);

	Result updateIsActive(boolean isActive, int userId, int jobPostingId);
}
