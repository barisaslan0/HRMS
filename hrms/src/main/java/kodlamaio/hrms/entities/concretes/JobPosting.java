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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

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

	@NotBlank(message = "Açıklama boş olamaz")
	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@Column(name = "number_of_open_position")
	private int numberOfOpenPosition;

	@Column(name = "release_date")
	private LocalDate releaseDate;

	@Column(name = "deadline")
	private LocalDate deadline;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "is_confirm")
	private boolean isConfirm;

	@JoinColumn(name = "employer_id", referencedColumnName = "user_id")
	@ManyToOne()
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@ManyToOne()
	@JoinColumn(name = "work_type_id")
	private WorkType workType;

	@ManyToOne()
	@JoinColumn(name = "work_time_id")
	private WorkTime workTime;
}
