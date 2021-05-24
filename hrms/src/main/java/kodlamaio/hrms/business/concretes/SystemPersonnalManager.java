package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonnalService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonnalDao;
import kodlamaio.hrms.entities.concretes.SystemPersonnal;

@Service
public class SystemPersonnalManager implements SystemPersonnalService {

	private SystemPersonnalDao systemPersonnalDao;

	@Autowired
	public SystemPersonnalManager(SystemPersonnalDao systemPersonnalDao) {
		super();
		this.systemPersonnalDao = systemPersonnalDao;
	}

	@Override
	public DataResult<List<SystemPersonnal>> getAll() {
		return new SuccessDataResult<List<SystemPersonnal>>(this.systemPersonnalDao.findAll());
	}

}
