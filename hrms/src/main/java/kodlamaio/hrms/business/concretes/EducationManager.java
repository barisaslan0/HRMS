package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.CV.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;
import net.bytebuddy.asm.Advice.This;

import org.springframework.data.domain.Sort;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public EducationManager(EducationDao educationDao, CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.educationDao = educationDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(EducationDto educationDto) {
		Education education = new Education();
		education.setEducationId(0);
		education.setCurriculumVitae(
				this.curriculumVitaeDao.getByCurriculumVitaeId(educationDto.getCurriculumVitaeId()));
		education.setSchoolName(educationDto.getSchoolName());
		education.setDepartment(educationDto.getDepartment());
		education.setStartDateOfSchool(educationDto.getStartDateOfSchool());
		education.setEndDateOfSchool(educationDto.getEndDateOfSchool());

		this.educationDao.save(education);
		return new SuccessResult("Eğitim durumu eklendi");
	}

	@Override
	public DataResult<List<Education>> sortByEndYearOfSchool() {
		Sort sort = Sort.by(Sort.Direction.DESC, "endYearOfSchool");
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(sort));
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "Eğitim durumları listelendi");
	}

}
