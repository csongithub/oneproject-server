/**
 * 
 */
package com.oneproject.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.comparator.DateComparator;
import com.oneproject.model.OtherBill;
import com.oneproject.persistence.OtherBillPersistence;
import com.oneproject.wrapper.OtherBillingSummary;

/**
 * @author chandan	
 *
 */	
@Service
public class OtherBillService {

	@Autowired	
	private OtherBillPersistence persistence;
	
	
	
	public void addBill(OtherBill bill) {
		persistence.addBill(bill);
	}
	
	
	
	public List<OtherBill> getBillsForProjectId(Long  projectId) {
		List<OtherBill> bills =  persistence.getBillsForProjectId(projectId);
		Collections.sort(bills,new DateComparator(OtherBill.class));  
		return bills;
	}
	
	
	
	public OtherBillingSummary getProjectBillingSummary(Long projectId) {
		Double amount = 0.0d;
		OtherBillingSummary summary = new OtherBillingSummary();
		List<OtherBill> bills = persistence.getBillsForProjectId(projectId);
		if(bills != null && bills.size() > 0) {
			for(OtherBill bill : bills) {
				amount = amount + bill.getBillAmount();
			}
			summary.setTotalBillingAmount(amount);
		}
		return summary;
	}
}
