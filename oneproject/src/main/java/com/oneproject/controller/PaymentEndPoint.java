/**
 * 
 */
package com.oneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneproject.model.Payment;
import com.oneproject.service.PaymentService;
import com.oneproject.wrapper.EarningsDataWrapper;

/**
 * @author chandan
 *
 */
@RestController
@RequestMapping(value = "PaymentEndPoint")
public class PaymentEndPoint {
	
	@Autowired
	private PaymentService service;
	
	
	
	@PutMapping(value = "addPayment")
	public Payment addPayment(@RequestBody Payment payment) {
		service.addPayment(payment);
		return payment;
	}
	
	
	
	@GetMapping(value = "getIndividualPayments/{individualId}")
	public List<Payment> getIndividualPayments(@PathVariable Long individualId){
		List<Payment> payments = service.getIndividualPayments(individualId);
		return payments;
	}
	
	
	
	@GetMapping(value = "getIndividualEarnings/{individualId}")
	public EarningsDataWrapper getIndividualEarnings(@PathVariable("individualId") Long individualId) {
		return service.getIndividualEarnings(individualId);
	}

}
