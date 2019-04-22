/**
 * 
 */
package com.oneproject.persistence;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.ClientCredential;
import com.oneproject.repository.ClientCredentialRepository;
/**
 * @author a698219
 *
 */
@Component
public class ClientCredentialPersistence extends AbstractPersistence {

	private static final String GET_USER_CREDENTIAL = "select c from ClientCredential c where c.username = ?1";
	
	@Autowired
	private ClientCredentialRepository repository;
	
	
	
	public ClientCredential getClientCredential(Long id) {
		return repository.findOne(id);
	}
	
	
	
	public ClientCredential getCredentialForUserId(String username) {
		TypedQuery<ClientCredential> query = em.createQuery(GET_USER_CREDENTIAL, ClientCredential.class);
		query.setParameter(1, username);
		try {
			return query.getSingleResult();
		}catch(NoResultException e) {
			e.printStackTrace();
		}
		return null;
	}
}
