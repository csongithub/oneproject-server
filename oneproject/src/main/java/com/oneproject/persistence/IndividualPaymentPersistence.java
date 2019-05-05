/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.IndividualPayment;
import com.oneproject.repository.IndividualPaymentRepository;

/**
 * @author chandan
 *
 */
@Component
public class IndividualPaymentPersistence extends AbstractPersistence {
	
	public static final String GET_INDIVIDUAL_PAYMENTS = "select p from IndividualPayment p where p.individualId = ?1";
	
	@Autowired
	private IndividualPaymentRepository repository;
	
	
	
	public void addPayment(IndividualPayment payment) {
		repository.save(payment);
	}
	
	
	
	public List<IndividualPayment> getIndividualPayments(Long individualId){
		try {
			TypedQuery<IndividualPayment> query = em.createQuery(GET_INDIVIDUAL_PAYMENTS, IndividualPayment.class);
			query.setParameter(1, individualId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}

}
