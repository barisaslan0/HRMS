package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDto;
import kodlamaio.hrms.entities.dtos.JobPostingFilter;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByEmployer_CompanyName(String companyName);

	Page<JobPosting> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, Pageable pageable);

	JobPosting getByJobPostingId(int jobPostingId);

	JobPosting getByIsConfirmAndJobPostingId(boolean isConfirm, int jobPostingId);

	@Modifying
	@Transactional
	@Query("update JobPosting u set u.isConfirm=:isConfirm where u.jobPostingId=:jobPostingId ")
	void updateIsConfirm(boolean isConfirm, int jobPostingId);

	@Modifying
	@Transactional
	@Query("update JobPosting u set u.isActive=:isActive where u.employer.userId=:userId and u.jobPostingId=:jobPostingId ")
	void updateIsActive(boolean isActive, int userId, int jobPostingId);

	@Query("Select j from kodlamaio.hrms.entities.concretes.JobPosting j where "
			+ "((:#{#filter.jobPositionIds}) IS NULL OR j.jobPosition.jobPositionId IN (:#{#filter.jobPositionIds})) "
			+ "and ((:#{#filter.cityIds}) IS NULL OR j.city.cityId IN (:#{#filter.cityIds})) "
			+ "and ((:#{#filter.workTypeIds}) IS NULL OR j.workType.workTypeId IN (:#{#filter.workTypeIds})) "
			+ "and ((:#{#filter.workTimeIds}) IS NULL OR j.workTime.workTimeId IN (:#{#filter.workTimeIds})) "
			+ "and j.isActive = true " + "and j.isConfirm = true")
	Page<JobPosting> getByFilter(@Param("filter") JobPostingFilter jobPostingFilter, Pageable pageable);
}
