package kodlamaio.hrms.entities.concretes.CV;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "technologies")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "curriculumVitae"})
public class Technology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "technology_id")
	private int technologyId;
	
	@JoinColumn(name = "curriculum_vitae_id")
	@ManyToOne()
	private CurriculumVitae curriculumVitae;
	
	@NotBlank(message = "Teknoloji adı boş olamaz")
	@Column(name = "technology_name")
	private String technologyName;
}
