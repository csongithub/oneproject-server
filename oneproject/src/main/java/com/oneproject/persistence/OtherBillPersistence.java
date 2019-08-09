/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.oneproject.model.OtherBill;
import com.oneproject.repository.OtherBillRepository;

/**
 * @author chandan
 *
 */
@Component
public class OtherBillPersistence extends AbstractPersistence {
	
	private static final String GET_BILLS_FOR_PROJECT_ID = "select b from OtherBill b where b.projectId = ?1";
	private static final String GET_BILLS_FOR_CLIENT_AND_PROJECT = "select b from OtherBill b where b.clientId = ?1 and b.projectId = ?2";
	private static final String GET_BILL_FOR_CLIENT_AND_PROJECT = "select ob from OtherBill ob where ob.billId = ?1 and ob.projectId = ?2 and ob.clientId = ?3";
	
	@Autowired
	private OtherBillRepository repository;
	
	public void addBill(OtherBill bill) {
		repository.save(bill);
	}
	
	
	public List<OtherBill> getBillsForProjectId(Long  projectId) {
		try {
			TypedQuery<OtherBill> query = em.createQuery(GET_BILLS_FOR_PROJECT_ID, OtherBill.class);
			query.setParameter(1, projectId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<OtherBill> getBillsForClientAndProject(Long clientId, Long projectId) {
		try {
			TypedQuery<OtherBill> query = em.createQuery(GET_BILLS_FOR_CLIENT_AND_PROJECT, OtherBill.class);
			query.setParameter(1, clientId);
			query.setParameter(2, projectId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public OtherBill getBillForProjectAndClientId(Long billId, Long projectId, Long clientId) {
		try {
			TypedQuery<OtherBill> query = em.createQuery(GET_BILL_FOR_CLIENT_AND_PROJECT, OtherBill.class);
			query.setParameter(1, billId);
			query.setParameter(2, projectId);
			query.setParameter(3, clientId);
			return query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public void deleteBill(Long billId) {
		repository.delete(billId);
	}

}
