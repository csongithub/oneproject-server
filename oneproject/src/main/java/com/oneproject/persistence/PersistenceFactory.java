/**
 * 
 */
package com.oneproject.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chandan
 *
 */
@Component
public class PersistenceFactory {
	
	@Autowired
	private ProjectPersistence projectPersistence;
	
	@Autowired
	private SupplierBillPersistence supplierBillPersistence;
	
	
	
	public ProjectPersistence getProjectPersistence() {
		return this.projectPersistence;
	}
	
	
	
	public SupplierBillPersistence getSupplierBillingPersistence() {
		return this.supplierBillPersistence;
	}

}
