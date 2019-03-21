/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.Address;
import com.oneproject.repository.AddressRepository;

/**
 * @author chandan
 *
 */
@Component
public class AddressPersistence extends AbstractPersistence{
	
	@Autowired
	private AddressRepository repository;
	
	
	
	public List<Address> getAllAddresses(){
		return repository.findAll();
	}
	
	
	
	public Address getAddressById(Long addressId) {
		return repository.findOne(addressId);
	}
	
	
	
	public void addOrUpdateAddress(Address address) {
		repository.save(address);
	}

}
