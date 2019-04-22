/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.AdminEnumerationsPreferences;
import com.oneproject.repository.AdminEnumerationsPreferencesRepository;

/**
 * @author chandan
 *
 */
@Component
public class AdminEnumerationsPreferencesPersistence extends AbstractPersistence {

	private static final String GET_CLIENT_ENUMERATIONS = "select e from AdminEnumerationsPreferences e where e.clientId = ?1";
	
	
	@Autowired
	private AdminEnumerationsPreferencesRepository repository;
	
	
	
	public List<AdminEnumerationsPreferences> getAllEnumerations(){
		return repository.findAll();
	}
	
	
	
	public AdminEnumerationsPreferences getClientEnumerations(Long clientId) {
		try {
			TypedQuery<AdminEnumerationsPreferences> query = em.createQuery(GET_CLIENT_ENUMERATIONS, AdminEnumerationsPreferences.class);
			query.setParameter(1, clientId);
			return query.getSingleResult();
		}catch(NoResultException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	
	public void addOrUpdateEnumeration(AdminEnumerationsPreferences preferences) {
		repository.save(preferences);
	}
}
