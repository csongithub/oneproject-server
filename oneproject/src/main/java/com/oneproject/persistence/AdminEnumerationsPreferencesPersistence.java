/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

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

	@Autowired
	private AdminEnumerationsPreferencesRepository repository;
	
	
	
	public List<AdminEnumerationsPreferences> getAllEnumerations(){
		return repository.findAll();
	}
	
	
	
	public void addOrUpdateEnumeration(AdminEnumerationsPreferences preferences) {
		repository.save(preferences);
	}
}
