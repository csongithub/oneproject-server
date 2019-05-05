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

import com.oneproject.model.IndividualPayment;
import com.oneproject.service.IndividualPaymentService;
import com.oneproject.wrapper.IndividualPaymentsSummary;

/**
 * @author chandan
 *
 */
@RestController
@RequestMapping(value = "IndividualPaymentEndPoint")
public class IndividualPaymentEndPoint {
	
	@Autowired
	private IndividualPaymentService service;
	
	
	
	@PutMapping(value = "addPayment")
	public IndividualPayment addPayment(@RequestBody IndividualPayment payment) {
		service.addPayment(payment);
		return payment;
	}
	
	
	
	@GetMapping(value = "getIndividualPayments/{individualId}")
	public List<IndividualPayment> getIndividualPayments(@PathVariable Long individualId){
		return service.getIndividualPayments(individualId);
	}
	
	
	
	@GetMapping(value = "getIndividualPaymentsSummary/{individualId}")
	public IndividualPaymentsSummary getIndividualPaymentsSummary(@PathVariable("individualId") Long individualId) {
		return service.getIndividualPaymentsSummary(individualId);
	}
}
