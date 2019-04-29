/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.Individual;

/**
 * @author chandan
 *
 */
public interface IndividualRepository extends JpaRepository<Individual, Long>{

}
