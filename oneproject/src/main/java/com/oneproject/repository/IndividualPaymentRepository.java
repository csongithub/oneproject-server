/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.IndividualPayment;

/**
 * @author chandan
 *
 */
public interface IndividualPaymentRepository extends JpaRepository<IndividualPayment, Long> {

}
