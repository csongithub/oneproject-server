/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.Address;

/**
 * @author chandan
 *
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}
