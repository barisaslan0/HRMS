package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {
	List<CurriculumVitae> getByJobseeker_UserId(int jobseekerId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CurriculumVitaeDto"
			+"(c.curriculumVitaeId,e.schoolName,e.department,e.startYearOfSchool,"
			+"e.endYearOfSchool,w.workplaceName,w.startYearOfWork,"
			+"w.endYearOfWork,f.language,f.level,c.githubAddress,c.linkedinAddress,"
			+"t.technologyName,c.coverLetter)"
			+" From CurriculumVitae c"
			+" Inner Join c.educations e"
			+" Inner Join c.workExperiences w"
			+" Inner Join c.foreignLanguages f"
			+" Inner Join c.technologies t"
			)
	List<CurriculumVitaeDao> getCurriculumVitaeDetails();
}
