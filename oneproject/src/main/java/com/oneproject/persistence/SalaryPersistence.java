/**
 * 
 */
package com.oneproject.persistence;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.Salary;
import com.oneproject.repository.SalaryRepository;

/**
 * @author a698219
 *
 */
@Component
public class SalaryPersistence extends AbstractPersistence{
	
	private static final String GET_INDIVIDUAL_ACTIVE_SALARY = "select sal from Salary sal where sal.individualId = ?1 and sal.status = 'Active'";
	
	@Autowired
	private SalaryRepository repository;
	
	
	
	public void addOrUpdateSalary(Salary salary) {
		repository.save(salary);
	}
	
	
	
	public Salary getSalary(Long saaryId) {
		return repository.findOne(saaryId);
	}
	
	
	
	public Salary getIndividualActiveSalary(Long individualId) {
		TypedQuery<Salary> query = em.createQuery(GET_INDIVIDUAL_ACTIVE_SALARY, Salary.class);
		query.setParameter(1, individualId);
		return query.getSingleResult();
	}
}
