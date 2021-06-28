package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AddressService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.AddressDto;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin
public class AddressesController {
	private AddressService addressService;

	@Autowired
	public AddressesController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody AddressDto addressDto) {
		return this.addressService.add(addressDto);
	}

	@PutMapping("/update")
	public Result update(@RequestBody AddressDto addressDto) {
		return this.addressService.update(addressDto);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int addressId) {
		return this.addressService.delete(addressId);
	}
}
