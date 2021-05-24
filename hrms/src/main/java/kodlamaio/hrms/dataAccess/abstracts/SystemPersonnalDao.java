package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.SystemPersonnal;

public interface SystemPersonnalDao extends JpaRepository<SystemPersonnal, Integer> {
	
}
