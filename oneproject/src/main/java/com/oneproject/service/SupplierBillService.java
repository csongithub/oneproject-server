/**
 * 
 */
package com.oneproject.service;

import java.text.DecimalFormat;
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
		DecimalFormat format = new DecimalFormat("##.00");
		SupplierBillingSummary summary = new SupplierBillingSummary();
		List<SupplierBill> bills = persistence.getSupplierBillsForProject(projectId, supplierId);
		if(bills != null && bills.size() > 0) {
			Double totalBillingAmount = 0.0d;
			Double totalPaymentAmount = 0.0d;
			Double diff = 0.0d;
			for(SupplierBill bill : bills) {
				totalBillingAmount = totalBillingAmount + bill.getBillAmount();
				totalPaymentAmount = totalPaymentAmount + bill.getPaidAmount();
			}
			diff = totalBillingAmount - totalPaymentAmount;
			summary.setTotalBillingAmount(totalBillingAmount);
			summary.setTotalPaymentAmount(totalPaymentAmount);
			if(diff >= 0) {
				summary.setTotalDueAmount(diff);
			}else {
				summary.setTotalAdvanceAmount(-diff);
			}
			if(totalBillingAmount > 0) {
				summary.setPaymentPercentage(Float.parseFloat(format.format((float)((totalPaymentAmount/totalBillingAmount) * 100))));
				summary.setDuePercentage(Float.parseFloat(format.format((float)((summary.getTotalDueAmount()/totalBillingAmount)*100))));
			}else{
				summary.setBillingPercentage(Float.parseFloat(format.format(0.0f)));
			}
			if(summary.getPaymentPercentage() > summary.getBillingPercentage()) {
				summary.setAdvPercentage(Float.parseFloat(format.format((float)(summary.getPaymentPercentage() - summary.getBillingPercentage()))));
				//summary.setAdvPercentage(summary.getPaymentPercentage() - summary.getBillingPercentage());
			}
		} else {
			summary.setBillingPercentage(Float.parseFloat(format.format(0.0f)));
		}
		return summary;
	}

}
