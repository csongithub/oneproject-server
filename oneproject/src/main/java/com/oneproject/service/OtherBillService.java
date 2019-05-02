/**
 * 
 */
package com.oneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.Item;
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
		return persistence.getBillsForProjectId(projectId);
	}
	
	
	
	public OtherBillingSummary getProjectBillingSummary(Long projectId) {
		Double amount = 0.0d;
		OtherBillingSummary summary = new OtherBillingSummary();
		List<OtherBill> bills = persistence.getBillsForProjectId(projectId);
		if(bills != null && bills.size() > 0) {
			for(OtherBill bill : bills) {
				List<Item> items = bill.getItmes();
				if(items != null && items.size() > 0) {
					for(Item item : items) {
						amount = amount + item.getPrice();
					}
				}
			}
			summary.setTotalBillingAmount(amount);
		}
		return summary;
	}
}
