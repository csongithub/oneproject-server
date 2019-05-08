/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.Machine;

/**
 * @author chandan
 *
 */
public interface MachineRepository extends JpaRepository<Machine, Long> {

}
