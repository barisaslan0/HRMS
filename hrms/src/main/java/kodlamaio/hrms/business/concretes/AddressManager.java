package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AddressService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AddressDao;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CV.Address;
import kodlamaio.hrms.entities.dtos.AddressDto;

@Service
public class AddressManager implements AddressService {

	private AddressDao addressDao;
	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public AddressManager(AddressDao addressDao, CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.addressDao = addressDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(AddressDto addressDto) {
		Address address = new Address();

		address.setCurriculumVitae(this.curriculumVitaeDao.getByCurriculumVitaeId(addressDto.getCurriculumVitaeId()));
		address.setLinkedinAddress(addressDto.getLinkedinAddress());
		address.setGithubAddress(addressDto.getGithubAddress());

		this.addressDao.save(address);
		return new SuccessResult("Address aklendi");
	}

	@Override
	public Result update(AddressDto addressDto) {
		Address addressToUpdate = this.addressDao.getByAddressId(addressDto.getAddressId());

		addressToUpdate.setLinkedinAddress(addressDto.getLinkedinAddress());
		addressToUpdate.setGithubAddress(addressDto.getGithubAddress());

		this.addressDao.save(addressToUpdate);
		return new SuccessResult("Adresler Güncellendi");
	}

	@Override
	public Result delete(int addressId) {
		this.addressDao.deleteById(addressId);
		return new SuccessResult("Adresler Silindi");
	}

}
