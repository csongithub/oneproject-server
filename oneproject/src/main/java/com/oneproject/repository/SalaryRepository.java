/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.Salary;

/**
 * @author a698219
 *
 */
public interface SalaryRepository extends JpaRepository<Salary, Long> {

}
