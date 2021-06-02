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
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private int educationId;

	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "curriculum_vitae_id")
	@ManyToOne()
	private CurriculumVitae curriculumVitae;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "department")
	private String department;

	@Column(name = "start_year_of_school")
	private LocalDate startYearOfSchool;

	@Column(name = "end_year_of_school")
	private LocalDate endYearOfSchool;
}
