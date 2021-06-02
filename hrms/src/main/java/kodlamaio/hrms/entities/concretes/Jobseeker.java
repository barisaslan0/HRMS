package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	@Size(min = 11,max = 11,message = "TC Kimlik No 11 haneli olmalı")
	@NotBlank(message = "TC boş olamaz")
	@Column(name = "identity_number")
	private String identityNumber;

	@NotBlank(message = "İsim boş olamaz")
	@Column(name = "first_name")
	private String firstname;

	@NotBlank(message = "Soyisim boş olamaz")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "Doğum yılı boş olamaz")
	@Column(name = "birth_year")
	private int birthYear;

	@OneToMany(mappedBy = "jobseeker")
	private List<CurriculumVitae> curriculumVitaes;

}
