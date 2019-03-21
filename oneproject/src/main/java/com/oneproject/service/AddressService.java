/**
 * 
 */
package com.oneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.Address;
import com.oneproject.persistence.AddressPersistence;

/**
 * @author chandan
 *
 */
@Service
public class AddressService {
	
	@Autowired
	private AddressPersistence persistence;
	
	
	
	public List<Address> getAllAddresses(){
		return persistence.getAllAddresses();
	}
	
	
	
	public Address getAddressById(Long addressId) {
		return persistence.getAddressById(addressId);
	}
	
	
	
	public List<Address> addOrUpdateAddress(Address address){
		if(address != null) {
			persistence.addOrUpdateAddress(address);
		}
		return getAllAddresses();
	}

}
