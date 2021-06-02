package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.CV.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	JobPosition findByPositionName(String name);
}
