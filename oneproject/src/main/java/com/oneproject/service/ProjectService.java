/**
 * 
 */
package com.oneproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.Individual;
import com.oneproject.model.Project;
import com.oneproject.model.ProjectIndividualMapping;
import com.oneproject.model.ProjectIndividualMappingKey;
import com.oneproject.model.Supplier;
import com.oneproject.persistence.IndividualPersistence;
import com.oneproject.persistence.ProjectIndividualMappingPersistence;
import com.oneproject.persistence.ProjectPersistence;
import com.oneproject.persistence.SupplierPersistence;
import com.oneproject.wrapper.ProjectIndividualMapingDataWrapper;
import com.oneproject.wrapper.SummarizedProject;

/**
 * @author chandan
 *
 */
@Service
public class ProjectService{
	
	@Autowired
	private ProjectPersistence projectPersistence;
	@Autowired
	private IndividualPersistence individualPersistence;
	@Autowired
	private ProjectIndividualMappingPersistence individualMappingPersistence;
	@Autowired
	private SupplierPersistence supplierPersistence;
	
	
	
	public List<Project> getAllProjects(){
		return projectPersistence.getAllProjects();
	}
	
	
	
	public List<Project> getClientProjects(Long clientId){
		return projectPersistence.getClientProjects(clientId);
	}
	
	
	
	public List<SummarizedProject> getSummarizedProjects(){
		return projectPersistence.getSummarizedProjects();
	}
	
	
	
	public List<SummarizedProject> getSummarizedProjectsForClient(Long clientId){
		return projectPersistence.getSummarizedProjectsForClient(clientId);
	}
	
	
	
	public List<Project> addOrUpdateProject(Project project){
		if(project != null) {
			boolean isNull = checkIfNull(project.getProjectName(),
								project.getProjectType(),
								project.getProjectStartDate(),
								project.getProjectEndDate(),
								project.getProjectCost());
			if(!isNull) {
				return projectPersistence.addOrUpdateProject(project);
			}else {
				throw new RuntimeException("null value evaluated");
			}
		}
		throw new RuntimeException("null value evaluated");
	}

	
	
	public List<Project> deleteProject(Long projectId) {
		return projectPersistence.deleteProject(projectId);
	}
	
	
	
	public List<ProjectIndividualMapping> linkIndividual(ProjectIndividualMapingDataWrapper wrapper){
		Project project = projectPersistence.getprojectById(wrapper.getProjectId());
		Individual individual = individualPersistence.getIndividualById(wrapper.getIndividualId());
		if(project != null && individual != null) {
			ProjectIndividualMapping mapping = new ProjectIndividualMapping();
			mapping.setIndividualId(individual);
			mapping.setProjectId(project);
			mapping.setJoiningDate(wrapper.getJoiningDate());
			mapping.setRole(wrapper.getRole());
			individualMappingPersistence.addOrUpdateMapping(mapping);
		}
		return this.getIndividualsForProject(wrapper.getProjectId());
	}
	
	
	
	public Project delinkIndividual(Long projectId, Long individualId){
		ProjectIndividualMappingKey key = new ProjectIndividualMappingKey();
		key.setProjectId(projectId);
		key.setIndividualId(individualId);
		ProjectIndividualMapping mapping =  individualMappingPersistence.getMappingByKey(key);
		if(mapping != null) {
			individualMappingPersistence.deleteMappingByKey(key);
		}
		return projectPersistence.getprojectById(projectId);
	}
	
	
	
	private boolean checkIfNull(String projectName, String projectType, Date projectStartDate, Date projectEndDate, double projectCost) {
		if(projectName == null || projectType == null || projectStartDate == null || projectEndDate== null || projectCost == 0)
			return true;
		else 
			return false;
	}



	public List<ProjectIndividualMapping> getIndividualsForProject(Long projectId) {
		Project project = projectPersistence.getprojectById(projectId);
		if(project != null && project.getProjectIndividuals() != null) {
			for(ProjectIndividualMapping mapping: project.getProjectIndividuals()) {
				Individual individual = individualPersistence.getIndividualById(mapping.getIndividualId());
				String fullName = individual.getFirstName() + " " +individual.getMiddleName() +" " +individual.getLastName();
				mapping.setIndividualFullName(fullName);
				mapping.setProjectName(project.getProjectName());
			}
			return project.getProjectIndividuals();
		}else {
			return new ArrayList<ProjectIndividualMapping>();
		}
	}


	
	public List<Supplier> linkSupplier(Long projectId, Long supplierId) {
		Project project = projectPersistence.getprojectById(projectId);
		Supplier supplier = supplierPersistence.getSupplierById(supplierId);
		if(project != null && supplier != null) {
			List<Supplier> suppliers = project.getSuppliers();
			if(suppliers != null && suppliers.size() > 0) {
				suppliers.add(supplier);
				projectPersistence.addOrUpdateProject(project);
			}else {
				suppliers = new ArrayList<Supplier>();
				suppliers.add(supplier);
				project.setSuppliers(suppliers);
				projectPersistence.addOrUpdateProject(project);
			}
		}
		return project.getSuppliers();
	}
	
	
	
	public List<Supplier> getProjectSupplier(Long projectId) {
		Project project = projectPersistence.getprojectById(projectId);
		return project.getSuppliers();
	}
}
