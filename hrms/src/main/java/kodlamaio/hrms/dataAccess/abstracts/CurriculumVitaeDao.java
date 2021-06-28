package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {
	List<CurriculumVitae> getByJobseeker_UserId(int jobseekerId);

	CurriculumVitae getByCurriculumVitaeId(int curriculumVitaeId);
}
