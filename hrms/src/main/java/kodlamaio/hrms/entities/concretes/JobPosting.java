package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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

//	@Column(name = "user_id")
//	private int userId;

//	@Column(name = "job_position_id")
//	private int jobPositionId;

	@Column(name = "job_description")
	private String jobDescription;

//	@Column(name = "city_id")
//	private String cityId;

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

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

}
