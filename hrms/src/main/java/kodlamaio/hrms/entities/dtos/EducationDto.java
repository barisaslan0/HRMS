package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	private int educationId;
	private int curriculumVitaeId;

	private String schoolName;
	private String department;
	private LocalDate startDateOfSchool;
	private LocalDate endDateOfSchool;

}
