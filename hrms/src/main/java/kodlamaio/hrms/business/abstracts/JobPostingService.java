package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;

import ch.qos.logback.core.filter.Filter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDto;
import kodlamaio.hrms.entities.dtos.JobPostingFilter;

public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();

	DataResult<List<JobPosting>> getByIsConfirm(boolean isConfirm, int pageNo, int pageSize);

	DataResult<List<JobPosting>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, int pageNo,
			int pageSize);

	DataResult<List<JobPosting>> sortByReleaseDate();

	DataResult<List<JobPosting>> getByCompanyName(String companyName);

	DataResult<JobPosting> getByJobPostingId(int jobPostingId);

	DataResult<JobPosting> getByIsConfirmAndJobPostingId(boolean isConfirm, int jobPostingId);

	Result add(JobPostingDto jobPostingDto);

	Result updateIsConfirm(boolean isConfirm, int jobPostingId);

	Result updateIsActive(boolean isActive, int userId, int jobPostingId);

//	DataResult<List<JobPosting>> getByFilter(JobPostingFilter jobPostingFilter);
}
