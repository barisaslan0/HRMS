package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CV.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {
	Address getByAddressId(int addressId);
}
