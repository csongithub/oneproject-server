/**
 * 
 */
package com.oneproject.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oneproject.model.Item;
import com.oneproject.model.OtherBill;
import com.oneproject.persistence.PersistenceFactory;
import com.oneproject.utils.Strings;
import com.oneproject.wrapper.OtherBillingSummary;
import com.oneproject.wrapper.SearchCriteriaDataWrapper;

/**
 * @author chandan					
 *
 */	
@Service
public class OtherBillService {

	@Autowired	
	private PersistenceFactory factory;
	
	
	
	public void addBill(OtherBill bill) {
		if(bill.getItems().size() == 0)
			throw new RuntimeException("No Item Found");
		validateItems(bill.getItems());
		factory.getOtherBillingPersistence().addBill(bill);
	}
	
	
	
	public void deleteBill(Long billId) {
		factory.getOtherBillingPersistence().deleteBill(billId);
	}
	
	
	
	private void validateItems(List<Item> items) {
		int count  = 0;
		for(Item item: items) {
			count++;
			if(Strings.isNullOrEmpty(item.getItemName()) || Strings.isNullOrEmpty(item.getRemark()) || item.getPrice() == null || item.getPrice() == 0.0d)
				throw new RuntimeException("Invalid Items, Missing Item Name/Price/Remark.\nPlease Check Item number "+count); 
		}
		
	}



	public List<OtherBill> getBillsForProjectId(Long  projectId) {
		List<OtherBill> bills =  factory.getOtherBillingPersistence().getBillsForProjectId(projectId);
		bills.sort((b1,b2) -> b2.getBillingDate().compareTo(b1.getBillingDate())); 
		return bills;
	}
	
	
	
	public List<OtherBill> getBillsBySearchCriteria(SearchCriteriaDataWrapper wrapper){
		 List<OtherBill> bills = new ArrayList<OtherBill>();
		if(wrapper.getProjectId() != null) {
			List<OtherBill> allBills =  factory.getOtherBillingPersistence().getBillsForProjectId(wrapper.getProjectId());
			for(OtherBill bill: allBills) {
				Date date = bill.getBillingDate();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				if(cal.get(Calendar.YEAR) == wrapper.getForYear()
						&& (cal.get(Calendar.MONTH)+1) == wrapper.getForMonth()){
					bills.add(bill);
				}
			}
		}
		return bills;
	}
	
	
	
	public OtherBillingSummary getProjectBillingSummary(Long projectId) {
		Double amount = 0.0d;
		OtherBillingSummary summary = new OtherBillingSummary();
		List<OtherBill> bills = factory.getOtherBillingPersistence().getBillsForProjectId(projectId);
		if(bills != null && bills.size() > 0) {
			for(OtherBill bill : bills) {
				amount = amount + bill.getBillAmount();
			}
			summary.setTotalBillingAmount(amount);
		}
		return summary;
	}



	public OtherBill getBillForProjectAndClientId(Long billId, Long projectId, Long clientId) {
		return factory.getOtherBillingPersistence().getBillForProjectAndClientId(billId, projectId, clientId);
	}
}
