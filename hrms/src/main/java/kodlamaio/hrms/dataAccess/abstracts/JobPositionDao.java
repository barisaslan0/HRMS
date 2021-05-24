package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	JobPosition findByName(String name);
}
