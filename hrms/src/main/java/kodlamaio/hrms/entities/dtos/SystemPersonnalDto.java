package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonnalDto {
	private int userId;

	private String firstName;
	private String lastName;
	
	private String email;
	private String passsword;
}
