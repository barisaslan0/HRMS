package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CV.CoverLetter;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;

@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao coverLetterDao;
	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao, CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.coverLetterDao = coverLetterDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(CoverLetterDto coverLetterDto) {
		CoverLetter coverLetter = new CoverLetter();
		coverLetter.setCoverLetterId(0);
		coverLetter.setCurriculumVitae(
				this.curriculumVitaeDao.getByCurriculumVitaeId(coverLetterDto.getCurriculumVitaeId()));
		coverLetter.setCoverLetter(coverLetterDto.getCoverLetter());
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön yazı eklendi");
	}

	@Override
	public Result update(CoverLetterDto coverLetterDto) {
		CoverLetter coverLetterToUpdate = this.coverLetterDao.getByCoverLetterId(coverLetterDto.getCoverLetterId());
		coverLetterToUpdate.setCoverLetter(coverLetterDto.getCoverLetter());
		this.coverLetterDao.save(coverLetterToUpdate);
		return new SuccessResult("Ön yazı güncellendi");
	}

}
