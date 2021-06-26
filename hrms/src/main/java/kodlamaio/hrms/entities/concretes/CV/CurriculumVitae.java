package kodlamaio.hrms.entities.concretes.CV;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curriculum_vitae_id")
	private int curriculumVitaeId;

	@JoinColumn(name = "jobseeker_id", referencedColumnName = "user_id")
	@ManyToOne()
	private Jobseeker jobseeker;

	@Column(name = "linkedin_address")
	private String linkedinAddress;

	@Column(name = "github_address")
	private String githubAddress;

	@OneToOne(mappedBy = "curriculumVitae")
	private CoverLetter coverLetter;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<Education> educations;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<WorkExperience> workExperiences;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<ForeignLanguage> foreignLanguages;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<Technology> technologies;

	public CurriculumVitae(int curriculumVitaeId) {
		super();
		this.curriculumVitaeId = curriculumVitaeId;

	}
}
