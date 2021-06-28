package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV.Address;
import kodlamaio.hrms.entities.dtos.AddressDto;

public interface AddressService {
	Result add(AddressDto addressDto);

	Result update(AddressDto addressDto);

	Result delete(int addressId);
}
