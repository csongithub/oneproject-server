/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.Supplier;
import com.oneproject.repository.SupplierRepository;

/**
 * @author a698219
 *
 */
@Component
public class SupplierPersistence extends AbstractPersistence {
	
	private static final String GET_CLIENT_SUPPLIERS = "select s from Supplier s where s.clientId = ?1";

	@Autowired
	private SupplierRepository repository;
	
	
	
	public List<Supplier> getAllSuppliers(){
		return repository.findAll();
	}
	
	
	
	public Supplier getSupplierById(Long supplierId) {
		return repository.findOne(supplierId);
	}



	public void addSupplier(Supplier supplier) {
		repository.save(supplier);	
	}



	public List<Supplier> getClientSuppliers(Long clientId) {
		try {
			TypedQuery<Supplier> query = em.createQuery(GET_CLIENT_SUPPLIERS, Supplier.class);
			query.setParameter(1, clientId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
}
