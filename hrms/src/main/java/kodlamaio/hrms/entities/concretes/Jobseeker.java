package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_year")
	private int birthYear;

}
