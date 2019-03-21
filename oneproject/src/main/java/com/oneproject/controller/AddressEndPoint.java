/**
 * 
 */
package com.oneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneproject.model.Address;
import com.oneproject.service.AddressService;

/**
 * @author chandan
 *
 */
@RestController
@RequestMapping(value = "AddressEndPoint")
public class AddressEndPoint {
	
	@Autowired
	private AddressService service;
	
	
	
	@GetMapping(value = "getAllAddresses")
	public List<Address> getAllAddresses(){
		return service.getAllAddresses();
	}
	
	
	
	@GetMapping(value = "getAddressById/{addressId}")
	public Address getAddressById(@PathVariable("addressId")Long addressId) {
		return service.getAddressById(addressId);
	}
	
	
	
	@PutMapping(value = "addOrUpdateAddress")
	public List<Address> addOrUpdateAddress(@RequestBody Address address){
		return service.addOrUpdateAddress(address);
	}

}
