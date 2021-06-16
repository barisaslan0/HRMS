package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
	private int employerId;
	private int jobPositionId;
	private int cityId;
	private int numberOfOpenPosition;
	private int minSalary;
	private int maxSalary;
	private int workTypeId;
	private int workTimeId;
	private LocalDate deadline;	
	private String jobDescription;
}
