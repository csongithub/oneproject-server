/**
 * 
 */
package com.oneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.IndividualPayment;
import com.oneproject.persistence.IndividualPaymentPersistence;
import com.oneproject.wrapper.IndividualPaymentsSummary;

/**
 * @author chandan
 *
 */
@Service
public class IndividualPaymentService {
	
	@Autowired
	private IndividualPaymentPersistence persistence;
	
	
	
	public void addPayment(IndividualPayment payment) {
		if(payment.getForMonth() != null && payment.getForYear() != null) {
			payment.setPaymentFor(payment.getForMonth()+"-"+payment.getForYear());
		}
		persistence.addPayment(payment);
	}
	
	
	
	public List<IndividualPayment> getIndividualPayments(Long individualId){
		List<IndividualPayment> payments = persistence.getIndividualPayments(individualId);
		return payments;
	}
	
	
	
	public IndividualPaymentsSummary getIndividualPaymentsSummary(Long individualId) {
		IndividualPaymentsSummary summary = new IndividualPaymentsSummary();
		List<IndividualPayment> payments = persistence.getIndividualPayments(individualId);
		if(payments != null && payments.size() > 0){
			Double totalPaymentAmount = 0.0d;
			Double totalPaidAmount = 0.0d;
			Double diff = 0.0d;
			for(IndividualPayment payment: payments) {
				totalPaymentAmount = totalPaymentAmount + payment.getSalaryAmount();
				totalPaidAmount = totalPaidAmount + payment.getPaidAmount();
			}
			diff = totalPaymentAmount - totalPaidAmount;
			
			summary.setTotalPaymentAmount(totalPaymentAmount);
			summary.setTotalPaidAmount(totalPaidAmount);
			if(diff >= 0) {
				summary.setTotalDueAmount(diff);
				summary.setTotalAdvanceAmount(0.0d);
			}else {
				summary.setTotalDueAmount(0.0d);
				summary.setTotalAdvanceAmount(-diff);
			}
		}
		return summary;
	}
}
