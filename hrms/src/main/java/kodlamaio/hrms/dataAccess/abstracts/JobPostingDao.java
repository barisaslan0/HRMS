package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByEmployer_CompanyName(String companyName);

	@Modifying
	@Transactional
	@Query("update JobPosting u set u.isActive=:isActive where u.employer.userId=:userId and u.jobPostingId=:jobPostingId ")
	void updateIsActive(boolean isActive,int userId,int jobPostingId);
}
