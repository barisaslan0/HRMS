package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonnalService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonnalDao;
import kodlamaio.hrms.entities.concretes.SystemPersonnal;
import kodlamaio.hrms.entities.dtos.SystemPersonnalDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class SystemPersonnalManager implements SystemPersonnalService {

	private SystemPersonnalDao systemPersonnalDao;

	@Autowired
	public SystemPersonnalManager(SystemPersonnalDao systemPersonnalDao) {
		super();
		this.systemPersonnalDao = systemPersonnalDao;
	}

	@Override
	public Result add(SystemPersonnalDto systemPersonnalDto) {
		SystemPersonnal systemPersonnal = new SystemPersonnal();

		systemPersonnal.setFirstName(systemPersonnalDto.getFirstName());
		systemPersonnal.setLastName(systemPersonnalDto.getLastName());
		systemPersonnal.setEmail(systemPersonnalDto.getEmail());
		systemPersonnal.setPassword(systemPersonnalDto.getPasssword());

		this.systemPersonnalDao.save(systemPersonnal);
		return new SuccessResult("Sistem Personeli Kayıt Olundu");
	}

	@Override
	public Result update(SystemPersonnalDto systemPersonnalDto) {
		SystemPersonnal systemPersonnalToUpdate = this.systemPersonnalDao.getByUserId(systemPersonnalDto.getUserId());

		systemPersonnalToUpdate.setFirstName(systemPersonnalDto.getFirstName());
		systemPersonnalToUpdate.setLastName(systemPersonnalDto.getLastName());
		systemPersonnalToUpdate.setEmail(systemPersonnalDto.getEmail());

		this.systemPersonnalDao.save(systemPersonnalToUpdate);
		return new SuccessResult("Sistem Personel Bilgileri Güncellendi");
	}

	@Override
	public DataResult<SystemPersonnal> getByUserId(int userId) {
		return new SuccessDataResult<SystemPersonnal>(this.systemPersonnalDao.getByUserId(userId));
	}

}
