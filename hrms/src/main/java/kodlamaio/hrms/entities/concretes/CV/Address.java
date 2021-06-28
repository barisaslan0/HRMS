package kodlamaio.hrms.entities.concretes.CV;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "curriculumVitae" })
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	public int addressId;

	@OneToOne()
	@JoinColumn(name = "curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;

	@Column(name = "linkedin_address")
	private String linkedinAddress;

	@Column(name = "github_address")
	private String githubAddress;
}
