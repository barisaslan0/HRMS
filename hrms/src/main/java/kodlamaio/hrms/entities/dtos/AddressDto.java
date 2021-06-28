package kodlamaio.hrms.entities.dtos;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
	private int addressId;
	private int curriculumVitaeId;

	private String linkedinAddress;
	private String githubAddress;
}
