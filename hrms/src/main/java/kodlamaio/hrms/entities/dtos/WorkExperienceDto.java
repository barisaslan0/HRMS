package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto {
	
	private int workExperienceId;
	private int curriculumVitaeId;
	
	private String workplaceName;
	private int jobPositionId;
	private LocalDate startDateOfWork;
	private LocalDate endDateOfWork;
}
