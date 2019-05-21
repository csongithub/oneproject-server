/**
 * 
 */
package com.oneproject.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.comparator.DateComparator;
import com.oneproject.model.OtherBill;
import com.oneproject.persistence.PersistenceFactory;
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
		factory.getOtherBillingPersistence().addBill(bill);
	}
	
	
	
	public List<OtherBill> getBillsForProjectId(Long  projectId) {
		List<OtherBill> bills =  factory.getOtherBillingPersistence().getBillsForProjectId(projectId);
		Collections.sort(bills,new DateComparator(OtherBill.class));  
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
}
