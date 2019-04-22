/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.ClientCredential;

/**
 * @author chandan
 *
 */
public interface ClientCredentialRepository extends JpaRepository<ClientCredential, Long> {

}
