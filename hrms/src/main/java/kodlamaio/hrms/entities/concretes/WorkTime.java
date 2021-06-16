package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_times")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobPostings" })
public class WorkTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_time_id")
	private int workTimeId;

	@Column(name = "work_time")
	private String workTime;

	@OneToMany(mappedBy = "workTime")
	private List<JobPosting> jobPostings;
}
