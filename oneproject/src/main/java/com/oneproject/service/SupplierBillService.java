/**
 * 
 */
package com.oneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.SupplierBill;
import com.oneproject.persistence.SupplierBillPersistence;

/**
 * @author chandan
 *
 */
@Service
public class SupplierBillService {
	
	@Autowired
	private SupplierBillPersistence persistence;
	
	
	
	public void addBill(SupplierBill bill) {
		persistence.addBill(bill);
	}
	
	
	
	public List<SupplierBill> getBillsForSupplierAndProject(Long supplierId, Long projectid){
		return persistence.getBillsForSupplierAndProject(supplierId, projectid);
	}
	
	
	
	public List<SupplierBill> getSupplierBills(Long supplierId){
		return persistence.getSupplierBills(supplierId);
	}
	
	
	
	public List<SupplierBill> getProjectBills(Long projectid){
		return persistence.getProjectBills(projectid);
	}

}
