/**
 * 
 */
package com.oneproject.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oneproject.model.Project;
import com.oneproject.model.Supplier;
import com.oneproject.model.SupplierBill;
import com.oneproject.persistence.PersistenceFactory;
import com.oneproject.wrapper.SupplierBillingSummary;

/**
 * @author chandan
 *
 */
@Service
public class SupplierBillService {
	
	@Autowired
	private PersistenceFactory persistenceFactory;
	
	
	
	public void addBill(SupplierBill bill) {
		persistenceFactory.getSupplierBillingPersistence().addBill(bill);
	}
	
	
	
	public void deleteBill(Long billId) {
		persistenceFactory.getSupplierBillingPersistence().deleteBill(billId);
	}
	
	
	
	public List<SupplierBill> getBillsForProjectAndSupplier(Long projectId, Long supplierId){
		return persistenceFactory.getSupplierBillingPersistence().getSupplierBillsForProject(projectId, supplierId);
	}
	
	
	
	public List<SupplierBill> getSupplierBills(Long supplierId){
		return persistenceFactory.getSupplierBillingPersistence().getSupplierBills(supplierId);
	}
	
	
	
	public List<SupplierBill> getProjectBills(Long projectid){
		return persistenceFactory.getSupplierBillingPersistence().getProjectBills(projectid);
	}



	public SupplierBillingSummary getSupplierBillingSummaryForProject(Long projectId, Long supplierId) {
		DecimalFormat format = new DecimalFormat("##.00");
		SupplierBillingSummary summary = new SupplierBillingSummary();
		List<SupplierBill> bills = persistenceFactory.getSupplierBillingPersistence().getSupplierBillsForProject(projectId, supplierId);
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
	
	
	
	public List<SupplierBillingSummary> getAllSuppliersBillingSummaryForProject(Long projectId){
		List<SupplierBillingSummary> suppliersSummary = new ArrayList<SupplierBillingSummary>();
		if(projectId != null) {
			Project project = persistenceFactory.getProjectPersistence().getProjectById(projectId);
			if(project != null && project.getSuppliers() != null && project.getSuppliers().size() > 0) {
				for(Supplier supplier : project.getSuppliers()) {
					SupplierBillingSummary summary = getSupplierBillingSummaryForProject(projectId, supplier.getId());
					summary.setSupplierId(supplier.getId());
					summary.setSupplierName(supplier.getSupplierName());
					suppliersSummary.add(summary);
				}	
			}
		}
		return suppliersSummary;
	}

}
