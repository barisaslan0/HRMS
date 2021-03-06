package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CV.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
	Technology getByTechnologyId(int technologyId);
}
