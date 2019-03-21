/**
 * 
 */
package com.oneproject.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.ProjectIndividualMapping;
import com.oneproject.model.ProjectIndividualMappingKey;
import com.oneproject.repository.ProjectIndividualMappingRepository;

/**
 * @author chandan
 *
 */
@Component
public class ProjectIndividualMappingPersistence extends AbstractPersistence {
	
	@Autowired
	private ProjectIndividualMappingRepository repository;
	
	
	
	public void addOrUpdateMapping(ProjectIndividualMapping mapping) {
		repository.save(mapping);
	}

	
	
	public ProjectIndividualMapping getMappingByKey(ProjectIndividualMappingKey key) {
		return repository.getOne(key);
	}



	public void deleteMappingByKey(ProjectIndividualMappingKey key) {
		repository.delete(key);
	}

}
