package kodlamaio.hrms.entities.concretes.CV;

import java.time.LocalDate;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_experiences")
public class WorkExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_experience_id")
	private int workExperienceId;

	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "curriculum_vitae_id")
	@ManyToOne()
	private CurriculumVitae curriculumVitae;

	@Column(name = "workplace_name")
	private String workplaceName;

	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "job_position_id")
	@ManyToOne()
	private JobPosition jobPosition;

	@Column(name = "start_year_of_work")
	private LocalDate startYearOfWork;

	@Column(name = "end_year_of_work")
	private LocalDate endYearOfWork;
}
