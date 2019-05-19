/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.oneproject.model.MachineBill;
import com.oneproject.repository.MachineBillRepository;

/**
 * @author chandan
 *
 */
@Component
public class MachineBillPersistence extends AbstractPersistence {

	private static final String GET_MACHINE_BILLS_FOR_PROJECT = "select mb from MachineBill mb where mb.machineId = ?1 AND mb.projectId = ?2";
	private static final String GET_MACHINE_BILLS = "select mb from MachineBill mb where mb.machineId = ?1";
	private static final String GET_PROJECT_BILLS = "select mb from MachineBill mb where mb.projectId = ?1";
	
	@Autowired
	private MachineBillRepository repository;
	
	public void addBill(MachineBill bill) {
		repository.save(bill);
	}
	
	
	
	public List<MachineBill> getMachineBills(Long machineId){
		try {
			TypedQuery<MachineBill> query = em.createQuery(GET_MACHINE_BILLS, MachineBill.class);
			query.setParameter(1, machineId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<MachineBill> getProjectBills(Long projectid){
		try {
			TypedQuery<MachineBill> query = em.createQuery(GET_PROJECT_BILLS, MachineBill.class);
			query.setParameter(1, projectid);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<MachineBill> getMachineBillsForProject(Long machineId, Long projectId){
		try {
			TypedQuery<MachineBill> query = em.createQuery(GET_MACHINE_BILLS_FOR_PROJECT, MachineBill.class);
			query.setParameter(1, machineId);
			query.setParameter(2, projectId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
}
