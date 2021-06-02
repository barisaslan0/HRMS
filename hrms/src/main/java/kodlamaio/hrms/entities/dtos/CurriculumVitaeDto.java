package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {
	private int id;
	private String schoolName;
	private String department;
	private LocalDate startYearOfSchool;
	private LocalDate endYearOfSchool;
	private String workplaceName;
	// private String positionName;
	private LocalDate startYearOfWork;
	private LocalDate endYearOfWork;
	private String language;
	private char level;
	private String githubAddress;
	private String linkedinAddress;
	private String technologyName;
	private String coverLetter;
}
