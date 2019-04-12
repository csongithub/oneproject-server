/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.Payment;
import com.oneproject.repository.PaymentRepository;

/**
 * @author chandan
 *
 */
@Component
public class PaymentPersistence extends AbstractPersistence {
	
	public static final String GET_INDIVIDUAL_PAYMENTS = "select p from Payment p where p.individualId = ?1";
	
	@Autowired
	private PaymentRepository repository;
	
	
	
	public void addPayment(Payment payment) {
		repository.save(payment);
	}
	
	
	
	public List<Payment> getIndividualPayments(Long individualId){
		TypedQuery<Payment> query = em.createQuery(GET_INDIVIDUAL_PAYMENTS, Payment.class);
		query.setParameter(1, individualId);
		return query.getResultList();
	}

}
