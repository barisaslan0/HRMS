package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CV.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	Education getByEducationId(int educationId);
}
