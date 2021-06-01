package kodlamaio.hrms.entities.concretes;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.entities.concretes.CV.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_postings")
public class JobPosting {

	@Id
	@GeneratedValue
	@Column(name = "job_posting_id")
	private int jobPostingId;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@Column(name = "number_of_open_position")
	private int numberOfOpenPosition;

	@Column(name = "release_date")
	private Date releaseDate = new Date(System.currentTimeMillis());

	@Column(name = "deadline")
	private Date deadline;

	@Column(name = "is_active")
	private boolean isActive;

	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "employer_id",referencedColumnName = "user_id")
	@ManyToOne()
	private Employer employer;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

}
