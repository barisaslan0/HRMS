package kodlamaio.hrms.entities.concretes.CV;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "foreign_languages")
public class ForeignLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foreign_language_id")
	private int foreignLanguageId;

	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "curriculum_vitae_id")
	@ManyToOne()
	private CurriculumVitae curriculumVitae;

	@Column(name = "language")
	private String language;

	@Column(name = "level")
	private char level;
}
