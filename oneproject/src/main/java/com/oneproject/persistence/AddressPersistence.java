/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.Address;
import com.oneproject.repository.AddressRepository;
import com.oneproject.wrapper.SummarizedIndividual;

/**
 * @author chandan
 *
 */
@Component
public class AddressPersistence extends AbstractPersistence{
	
	public static final String GET_ADDRESS_FOR_INDIVIDUAL_ID = "SELECT adr from Address adr WHERE adr.id = (select ind.address.id FROM Individual ind WHERE ind.individualId= ?1)";
	
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
	
	
	
	public Address getIndividualAddress(Long individulaId) {
		TypedQuery<Address> query = em.createQuery(GET_ADDRESS_FOR_INDIVIDUAL_ID, Address.class);
		query.setParameter(1, individulaId);
		Address address = new Address();
		try {
			address = query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		return address;
	}

}
