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
import com.oneproject.model.Machine;
import com.oneproject.model.Project;
import com.oneproject.model.ProjectIndividualMapping;
import com.oneproject.model.ProjectIndividualMappingKey;
import com.oneproject.model.ProjectMachineLinkage;
import com.oneproject.model.Supplier;
import com.oneproject.persistence.IndividualPersistence;
import com.oneproject.persistence.ProjectIndividualMappingPersistence;
import com.oneproject.persistence.ProjectPersistence;
import com.oneproject.persistence.SupplierPersistence;
import com.oneproject.wrapper.ProjectIndividualMapingDataWrapper;
import com.oneproject.wrapper.ProjectMachineWrapper;
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
	
	
	
	public List<Project> updateProject(SummarizedProject summarizedProject){
		Long projectId = summarizedProject.getProjectId();
		if(projectId != null) {
			Project project = projectPersistence.getProjectById(projectId);
			if(project != null) {
				project.setProjectName(summarizedProject.getProjectName());
				project.setProjectType(summarizedProject.getProjectType());
				project.setProjectStartDate(summarizedProject.getProjectStartDate());
				project.setProjectEndDate(summarizedProject.getProjectEndDate());
				project.setProjectCost(summarizedProject.getProjectCost());
				project.setBgNumber(summarizedProject.getBgNumber());
				project.setSecurity(summarizedProject.getSecurity());
				project.setSecurityDepositDate(summarizedProject.getSecurityDepositDate());
				project.setSecurityExpiryDate(summarizedProject.getSecurityExpiryDate());
				return projectPersistence.addOrUpdateProject(project);
			}
		} else {
			throw new RuntimeException("No Project Found");
		}
		return null;
		
	}

	
	
	public List<Project> deleteProject(Long projectId) {
		return projectPersistence.deleteProject(projectId);
	}
	
	
	
	public List<ProjectIndividualMapping> linkIndividual(ProjectIndividualMapingDataWrapper wrapper){
		Project project = projectPersistence.getProjectById(wrapper.getProjectId());
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
		return projectPersistence.getProjectById(projectId);
	}
	
	
	
	private boolean checkIfNull(String projectName, String projectType, Date projectStartDate, Date projectEndDate, double projectCost) {
		if(projectName == null || projectType == null || projectStartDate == null || projectEndDate== null || projectCost == 0)
			return true;
		else 
			return false;
	}



	public List<ProjectIndividualMapping> getIndividualsForProject(Long projectId) {
		Project project = projectPersistence.getProjectById(projectId);
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
		Project project = projectPersistence.getProjectById(projectId);
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
	
	
	
	public List<Supplier> getProjectSuppliers(Long projectId){
		return projectPersistence.getProjectSuppliers(projectId);
	}
	
	
	
	
	public List<ProjectMachineWrapper> addMachineToProject(Long projectId, ProjectMachineLinkage machineLinkage) {
		Project project = projectPersistence.getProjectById(projectId);
		List<ProjectMachineLinkage> linkages = null;
		if(project != null) {
			linkages = project.getProjectMachineLinkage();
			if(linkages != null && linkages.size() > 0) {
				linkages.add(machineLinkage);
			}else {
				linkages = new ArrayList<ProjectMachineLinkage>();
				linkages.add(machineLinkage);
				project.setProjectMachineLinkage(linkages);
			}
			projectPersistence.addOrUpdateProject(project);
			return this.getProjectMachines(projectId);
		}else {
			throw new RuntimeException("No Project Found");
		}
	}
	


	public List<ProjectMachineWrapper> getProjectMachines(Long projectId) {
		Project project = projectPersistence.getProjectById(projectId);
		List<ProjectMachineWrapper> wrappers = new ArrayList<ProjectMachineWrapper>();
		if(project != null) {
			List<ProjectMachineLinkage> machineLinkages = project.getProjectMachineLinkage();
			for(ProjectMachineLinkage projectMachineLinkage : machineLinkages) {
				ProjectMachineWrapper wrapper = new ProjectMachineWrapper();
				Machine machine = projectMachineLinkage.getMachine();
				wrapper.setMachineId(machine.getMachineId());
				wrapper.setMachineName(machine.getMachineName());
				wrapper.setMachineNumber(machine.getMachineNumber());
				wrapper.setMachineType(machine.getMachineType());
				
				Individual individual = individualPersistence.getIndividualById( machine.getOwnerId());
				String owner = individual.getFirstName() + " " + individual.getMiddleName() + " " + individual.getLastName();
				wrapper.setOwner(owner);
				String charge = "\u20B9" +" " + projectMachineLinkage.getPrice() + " / " + projectMachineLinkage.getPricingUnit();
				wrapper.setCharge(charge);
				Date joined = projectMachineLinkage.getJoinedOn();
				wrapper.setJoined(joined);
				wrappers.add(wrapper);
			}
		}
		return wrappers;
	}
}
