package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.CV.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyDao technologyDao;
	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public TechnologyManager(TechnologyDao technologyDao, CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.technologyDao = technologyDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
		Technology technology = new Technology();
		technology.setTechnologyId(0);
		technology.setCurriculumVitae(
				this.curriculumVitaeDao.getByCurriculumVitaeId(technologyDto.getCurriculumVitaeId()));
		technology.setTechnologyName(technologyDto.getTechnologyName());
		this.technologyDao.save(technology);
		return new SuccessResult("Teknoloji eklendi");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), "Teknolojiler listelendi");
	}

}
