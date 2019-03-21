/**
 * 
 */
package com.oneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.Supplier;
import com.oneproject.persistence.SupplierPersistence;

/**
 * @author chandan
 *
 */
@Service
public class SupplierService {

	@Autowired
	private SupplierPersistence persistence;
	
	
	
	public List<Supplier> getAppSuppliers(){
		return persistence.getAllSuppliers();
	}
	
	
	
	public Supplier getSupplierById(Long supplierId) {
		return persistence.getSupplierById(supplierId);
	}
	
	
	
	public List<Supplier> addOrUpdateSupplier(Supplier supplier){
		if(supplier != null) {
			persistence.addSupplier(supplier);
		}
		return getAppSuppliers();
	}
}
