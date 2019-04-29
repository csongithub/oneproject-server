/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.SupplierBill;
import com.oneproject.model.SupplierBillKey;

/**
 * @author chandan
 *
 */
public interface SupplierBillRepository extends JpaRepository<SupplierBill, SupplierBillKey> {

}
