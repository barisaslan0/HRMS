package kodlamaio.hrms.entities.concretes.CV;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "educations")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "curriculumVitae"})
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private int educationId;
	
	@ManyToOne()
	@JoinColumn(name = "curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;

	@NotBlank(message = "Okul adı boş olamaz")
	@Column(name = "school_name")
	private String schoolName;

	@NotBlank(message = "Bölüm adı boş olamaz")
	@Column(name = "department")
	private String department;

	@NotBlank(message = "Başlama tarihi boş olamaz")
	@Column(name = "start_date_of_school")
	private LocalDate startDateOfSchool;

	@NotBlank(message = "Bitiş tarihi boş olamaz")
	@Column(name = "end_date_of_school")
	private LocalDate endDateOfSchool;
}
