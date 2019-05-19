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
	@Autowired
	private MachineBillPersistence machineBillPersistence;
	@Autowired
	private ProjectMachineLinkagePersistence projectMachineLinkagePersistence;
	
	
	
	
	
	public ProjectPersistence getProjectPersistence() {
		return this.projectPersistence;
	}
	
	
	
	public SupplierBillPersistence getSupplierBillingPersistence() {
		return this.supplierBillPersistence;
	}
	
	
	
	public MachineBillPersistence getMachineBillingPersistence() {
		return this.machineBillPersistence;
	}
	
	
	
	public ProjectMachineLinkagePersistence getProjectMachineLinkagePersistence() {
		return this.projectMachineLinkagePersistence;
	}
}
