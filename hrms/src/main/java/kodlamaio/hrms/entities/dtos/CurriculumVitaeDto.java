package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hrms.entities.concretes.CV.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {
	private int curriculumVitaeId;
	private int jobseekerId;

	private String linkedinAddress;
	private String githubAddress;
}
