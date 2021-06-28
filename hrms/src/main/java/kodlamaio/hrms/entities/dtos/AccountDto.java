package kodlamaio.hrms.entities.dtos;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	private int accountId;
	private int curriculumVitaeId;

	private String linkedinAccount;
	private String githubAccount;
}
