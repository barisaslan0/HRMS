package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobseekers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Jobseeker extends User {

	@NotBlank(message = "Alan boş olamaz")
	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_year")
	private int birthYear;

	@OneToMany(mappedBy = "jobseeker")
	private List<CurriculumVitae> curriculumVitaes;

}
