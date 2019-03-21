/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

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
}
