package kodlamaio.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingFilter {
	private List<Integer> jobPositionIds;

	private List<Integer> cityIds;

	private List<Integer> workTypeIds;

	private List<Integer> workTimeIds;
}
