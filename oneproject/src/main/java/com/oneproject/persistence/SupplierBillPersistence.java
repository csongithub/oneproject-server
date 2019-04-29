/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.oneproject.model.SupplierBill;
import com.oneproject.repository.SupplierBillRepository;

/**
 * @author chandan
 *
 */
@Component
public class SupplierBillPersistence extends AbstractPersistence {
	
	private static final String GET_BILLS_FOR_SUPPIER_AND_PROJECT = "select s from SupplierBill s where s.key.supplierId = ?1 and s.key.projectId = ?2";
	private static final String GET_BILLS_FOR_SUPPIER = "select s from SupplierBill s where s.key.supplierId = ?1";
	private static final String GET_BILLS_FOR_PROJECT = "select s from SupplierBill s where s.key.projectId = ?1";
	
	@Autowired
	private SupplierBillRepository repository;
	
	
	public void addBill(SupplierBill bill) {
		repository.save(bill);
	}
	
	
	
	public List<SupplierBill> getBillsForSupplierAndProject(Long supplierId, Long projectid){
		try {
			TypedQuery<SupplierBill> query = em.createQuery(GET_BILLS_FOR_SUPPIER_AND_PROJECT, SupplierBill.class);
			query.setParameter(1, supplierId);
			query.setParameter(2, projectid);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<SupplierBill> getSupplierBills(Long supplierId){
		try {
			TypedQuery<SupplierBill> query = em.createQuery(GET_BILLS_FOR_SUPPIER, SupplierBill.class);
			query.setParameter(1, supplierId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<SupplierBill> getProjectBills(Long projectid){
		try {
			TypedQuery<SupplierBill> query = em.createQuery(GET_BILLS_FOR_PROJECT, SupplierBill.class);
			query.setParameter(1, projectid);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
}
