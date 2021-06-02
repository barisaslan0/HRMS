package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {

	@NotBlank(message = "Şirket adı boş olamaz")
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "Web site boş olamaz")
	@Column(name = "web_site")
	private String webSite;

	@NotBlank(message = "Telefon numarası boş olamaz")
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "is_accepted")
	private boolean isAccepted;
	
	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobPostings;

}
