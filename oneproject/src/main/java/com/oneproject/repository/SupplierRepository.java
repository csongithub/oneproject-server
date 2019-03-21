/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.Supplier;

/**
 * @author chandan
 *
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
