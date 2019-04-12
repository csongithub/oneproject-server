/**
 * 
 */
package com.oneproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.Salary;
import com.oneproject.persistence.SalaryPersistence;

/**
 * @author chandan
 *
 */
@Service
public class SalaryService {
	
	@Autowired
	private SalaryPersistence persistence;
	
	public Salary addSalary(Salary salary) {
		persistence.addOrUpdateSalary(salary);
		return persistence.getIndividualActiveSalary(salary.getIndividualId());
	}

}
