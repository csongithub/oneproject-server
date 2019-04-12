/**
 * 
 */
package com.oneproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneproject.model.Salary;
import com.oneproject.service.SalaryService;

/**
 * @author a698219
 *
 */
@RestController
@RequestMapping(value = "SalaryEndPoint")
public class SalaryEndPoint {
	
	@Autowired
	private SalaryService service;
	
	
	
	@PostMapping(value = "addSalary")
	public Salary addSalary(@RequestBody  Salary salary) {
		return service.addSalary(salary);
	}

}
