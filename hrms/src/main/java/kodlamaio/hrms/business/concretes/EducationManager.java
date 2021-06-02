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
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.CV.Education;
import net.bytebuddy.asm.Advice.This;

import org.springframework.data.domain.Sort;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		if (education.getEndYearOfSchool() == null) {
			education.setEndYearOfSchool(LocalDate.parse("Devam ediyor"));
		}
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
