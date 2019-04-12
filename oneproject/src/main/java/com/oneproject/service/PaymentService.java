/**
 * 
 */
package com.oneproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.Payment;
import com.oneproject.persistence.PaymentPersistence;
import com.oneproject.wrapper.EarningsDataWrapper;

/**
 * @author chandan
 *
 */
@Service
public class PaymentService {
	
	@Autowired
	private PaymentPersistence persistence;
	
	
	
	public void addPayment(Payment payment) {
		Date currentDateSystemDate = new Date();
		payment.setEntryDate(currentDateSystemDate);
		persistence.addPayment(payment);
	}
	
	
	
	public List<Payment> getIndividualPayments(Long individualId){
		List<Payment> payments = persistence.getIndividualPayments(individualId);
		return payments;
	}
	
	
	
	public EarningsDataWrapper getIndividualEarnings(Long individualId) {
		EarningsDataWrapper wrapper = new EarningsDataWrapper();
		Double salaryPayment = 0.0d;
		Double duesAmount = 0.0d;
		Double advancePayment = 0.0d;
		Double duesPayment = 0.0d;
		Double recoveryAmount = 0.0d;
		List<Payment> payments = persistence.getIndividualPayments(individualId);
		for(Payment payment : payments) {
			salaryPayment	= 	salaryPayment + (payment.getSalaryAmount() != null ? payment.getSalaryAmount() : 0.0d);
			duesAmount 		= 	duesAmount + (payment.getDueSalaryAmount() != null ? payment.getDueSalaryAmount() : 0.0d);
			advancePayment 	= 	advancePayment + (payment.getAdvancePayment() != null ? payment.getAdvancePayment() : 0.0d);
			duesPayment 	= 	duesPayment + (payment.getDuesPayment() != null ? payment.getDuesPayment() : 0.0d);
			recoveryAmount 	= 	recoveryAmount + (payment.getRecoveryAmount() != null ? payment.getRecoveryAmount() : 0.0d);
		}
		
		Double totalEarnings = salaryPayment + advancePayment + duesPayment - recoveryAmount;
		Double totalDues = 0.0d;
		Double totalOverpaid = 0.0d;
		
		
		if((advancePayment + duesPayment) < (duesAmount+recoveryAmount)) {
			totalDues = (duesAmount+recoveryAmount) - (advancePayment + duesPayment);
		}
		else if((advancePayment + duesPayment) > (duesAmount+recoveryAmount)) {
			totalOverpaid = (advancePayment + duesPayment) - (duesAmount + recoveryAmount);
		}
		
		
		wrapper.setTotalEarnings(totalEarnings);
		wrapper.setTotalDues(totalDues);
		wrapper.setOverPaid(totalOverpaid);
		return wrapper;
	}
}
