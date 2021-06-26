package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByEmployer_CompanyName(String companyName);

	List<JobPosting> getByIsConfirm(boolean isConfirm);

	List<JobPosting> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	JobPosting getByJobPostingId(int jobPostingId);
	
	JobPosting getByIsConfirmAndJobPostingId(boolean isConfirm ,int jobPostingId);

	@Modifying
	@Transactional
	@Query("update JobPosting u set u.isConfirm=:isConfirm where u.jobPostingId=:jobPostingId ")
	void updateIsConfirm(boolean isConfirm, int jobPostingId);

	@Modifying
	@Transactional
	@Query("update JobPosting u set u.isActive=:isActive where u.employer.userId=:userId and u.jobPostingId=:jobPostingId ")
	void updateIsActive(boolean isActive, int userId, int jobPostingId);
}
