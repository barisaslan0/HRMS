package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.CV.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.CV.Education;
import kodlamaio.hrms.entities.dtos.CurriculumVitaeDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private JobseekerDao jobseekerDao;
	private EducationDao educationDao;

	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, JobseekerDao jobseekerDao,
			EducationDao educationDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.jobseekerDao = jobseekerDao;
		this.educationDao = educationDao;
	}

	@Override
	public Result add(CurriculumVitaeDto curriculumVitaeDto) {
		CurriculumVitae curriculumVitae = new CurriculumVitae();

		curriculumVitae.setCurriculumVitaeId(0);
		curriculumVitae.setJobseeker(this.jobseekerDao.getByUserId(curriculumVitaeDto.getJobseekerId()));
		curriculumVitae.setLinkedinAddress(curriculumVitaeDto.getLinkedinAddress());
		curriculumVitae.setGithubAddress(curriculumVitaeDto.getGithubAddress());
		curriculumVitae.setCoverLetter(curriculumVitaeDto.getCoverLetter());
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("CV eklendi");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getByJobseekerId(int jobseekerId) {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.getByJobseeker_UserId(jobseekerId),
				"İş arayana ait CV listelendi");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "CV'ler listelendi");
	}

	@Override
	public DataResult<CurriculumVitae> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<CurriculumVitae>(
				this.curriculumVitaeDao.getByCurriculumVitaeId(curriculumVitaeId));
	}

}
