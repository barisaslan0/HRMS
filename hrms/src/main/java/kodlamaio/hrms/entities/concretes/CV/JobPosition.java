package kodlamaio.hrms.entities.concretes.CV;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.JobPosting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings","workExperiences"})
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_position_id")
	private int jobPositionId;

	@NotBlank(message = "Pozisyon adı boş olamaz")
	@Column(name = "position_name")
	private String positionName;

	@OneToMany(mappedBy = "jobPosition")
	private List<JobPosting> jobPostings;

	@OneToMany(mappedBy = "jobPosition")
	private List<WorkExperience> workExperiences;
}
