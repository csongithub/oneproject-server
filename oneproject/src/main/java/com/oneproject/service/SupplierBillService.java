/**
 * 
 */
package com.oneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.SupplierBill;
import com.oneproject.persistence.SupplierBillPersistence;
import com.oneproject.wrapper.SupplierBillingSummary;

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
	
	
	
	public List<SupplierBill> getBillsForProjectAndSupplier(Long projectId, Long supplierId){
		return persistence.getSupplierBillsForProject(projectId, supplierId);
	}
	
	
	
	public List<SupplierBill> getSupplierBills(Long supplierId){
		return persistence.getSupplierBills(supplierId);
	}
	
	
	
	public List<SupplierBill> getProjectBills(Long projectid){
		return persistence.getProjectBills(projectid);
	}



	public SupplierBillingSummary getSupplierBillingSummaryForProject(Long projectId, Long supplierId) {
		SupplierBillingSummary summary = new SupplierBillingSummary();
		List<SupplierBill> bills = persistence.getSupplierBillsForProject(projectId, supplierId);
		if(bills != null && bills.size() > 0) {
			Double totalBillingAmount = 0.0d;
			Double totalPaymentAmount = 0.0d;
			Double totalDueAmount = 0.0d;
			for(SupplierBill bill : bills) {
				totalBillingAmount = totalBillingAmount + bill.getBillAmount();
				totalPaymentAmount = totalPaymentAmount + bill.getPaidAmount();
			}
			totalDueAmount = totalBillingAmount - totalPaymentAmount;
			summary.setTotalBillingAmount(totalBillingAmount);
			summary.setTotalPaymentAmount(totalPaymentAmount);
			summary.setTotalDueAmount(totalDueAmount);
		}
		return summary;
	}

}
