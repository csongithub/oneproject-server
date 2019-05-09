/**
 * 
 */
package com.oneproject.persistence;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.ProjectMachineLinkage;
import com.oneproject.repository.ProjectMachineLinkageRepository;

/**
 * @author a698219
 *
 */
@Component
public class ProjectMachineLinkagePersistence extends AbstractPersistence {
	
	@Autowired
	private ProjectMachineLinkageRepository repository;
	
	
	public void addMachineLinkage(ProjectMachineLinkage linkage) {
		repository.save(linkage);
	}
	
	
	
	public ProjectMachineLinkage getMachineLinkageById(Long linkageId) {
		try {
			ProjectMachineLinkage machineLinkage = repository.findOne(linkageId);
			return machineLinkage;
		}catch (NoResultException e) {
			return null;
		}
	}
	
	
	

}
