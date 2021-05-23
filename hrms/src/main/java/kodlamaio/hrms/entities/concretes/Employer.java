package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_site")
	private String webSite;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "is_accepted")
	private boolean isAccepted;

}
