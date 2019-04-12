/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.Payment;

/**
 * @author chandan
 *
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
