/**
 * 
 */
package com.oneproject.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.MachineBill;
import com.oneproject.model.ProjectMachineLinkage;
import com.oneproject.persistence.PersistenceFactory;
import com.oneproject.wrapper.MachineBillingSummary;
import com.oneproject.wrapper.MachinePricingWrapper;

/**
 * @author chandan
 *
 */
@Service
public class MachineBillService {
	
	@Autowired
	private PersistenceFactory factory;
	
	public void addBill(MachineBill bill) {
		factory.getMachineBillingPersistence().addBill(bill);
	}
	
	
	
	public List<MachineBill> getMachineBills(Long machineId){
		return factory.getMachineBillingPersistence().getMachineBills(machineId);
	}
	
	
	
	public List<MachineBill> getProjectBills(Long projectid){
		return factory.getMachineBillingPersistence().getProjectBills(projectid);
	}
	
	
	
	public List<MachineBill> getMachineBillsForProject(Long machineId, Long projectId){
		return factory.getMachineBillingPersistence().getMachineBillsForProject(machineId, projectId);
	}
	
	
	
	public MachinePricingWrapper generateBillByPeriod(MachinePricingWrapper wrapper) {
		try {
			ProjectMachineLinkage linkage = factory.getProjectMachineLinkagePersistence().getMachineLinkageById(wrapper.getLinkageID());
			if(linkage != null) {
				DecimalFormat format = new DecimalFormat("##.00");
				String pricingUnit = linkage.getPricingUnit();
				if("HOUR".equalsIgnoreCase(pricingUnit)) {
					int hours = wrapper.getHours();
					int minutes = wrapper.getMinutes();
					int totalMinutes = (hours * 60) + minutes;
					float pricePerMinute = (linkage.getPrice() / 60);
					double billAmount = (totalMinutes * pricePerMinute);
					wrapper.setBillAmount(Double.parseDouble(format.format(billAmount)));
				}
			}
		}catch(Exception e) {
			throw new RuntimeException("Error in generating bill");
		}
		return wrapper;
	}
	
	
	
	public MachineBillingSummary getMachineBillingSummaryForProject(Long machineId, Long projectId){
		List<MachineBill> bills = factory.getMachineBillingPersistence().getMachineBillsForProject(machineId, projectId);
		DecimalFormat format = new DecimalFormat("##.00");
		MachineBillingSummary summary = new MachineBillingSummary();
		if(bills != null && bills.size() > 0) {
			Double totalBillingAmount = 0.0d;
			Double totalPaidAmount = 0.0d;
			Double diff = 0.0d;
			
			for(MachineBill bill: bills) {
				totalBillingAmount = totalBillingAmount + bill.getBillingAmount();
				totalPaidAmount = totalPaidAmount + bill.getPaidAmount();
			}
			diff = totalBillingAmount - totalPaidAmount;
			summary.setTotalBillingAmount(totalBillingAmount);
			summary.setTotalPaidAmount(totalPaidAmount);
			
			if(diff < 0) {
				summary.setTotalAdvanceAmount(-diff);
			}else {
				summary.setTotalDueAmount(diff);
			}
			if(totalBillingAmount > 0) {
				summary.setPaymentPercentage(Float.parseFloat(format.format((float)((totalPaidAmount/totalBillingAmount) * 100))));
				summary.setDuePercentage(Float.parseFloat(format.format((float)((summary.getTotalDueAmount()/totalBillingAmount)*100))));
			}else{
				summary.setBillingPercentage(Float.parseFloat(format.format(0.0f)));
			}
			if(summary.getPaymentPercentage() > summary.getBillingPercentage()) {
				summary.setAdvPercentage(Float.parseFloat(format.format((float)(summary.getPaymentPercentage() - summary.getBillingPercentage()))));
			}
		}else {
			summary.setBillingPercentage(Float.parseFloat(format.format(0.0f)));
		}
		return summary;
	}
}
