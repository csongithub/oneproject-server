/**
 * 
 */
package com.oneproject.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.constant.NamedQueryConstant;
import com.oneproject.model.Project;
import com.oneproject.model.Supplier;
import com.oneproject.repository.ProjectRepository;
import com.oneproject.wrapper.SummarizedProject;

/**
 * @author chandan
 *
 */
@Component
public class ProjectPersistence extends AbstractPersistence{
	
	@Autowired
	private ProjectRepository repository;
	
	private static final String GET_SUMMARIZED_PROJECT = "SELECT P.projectId, P.projectName FROM Project P order by P.projectId";
	private static final String GET_SUMMARIZED_PROJECTS_FOR_CLIENT = "SELECT P.projectId, P.projectName FROM Project P where P.clientId = ?1 order by P.projectId";
	private static final String GET_CLIENT_PROJECTS = "select p from Project p where p.clientId = ?1";
	
	
	
	public List<Project> getAllProjects(){
		try {
			return repository.findAll();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<SummarizedProject> getSummarizedProjects(){
		try {
			Query query = em.createQuery(GET_SUMMARIZED_PROJECT);
			List<Object[]> projectList = query.getResultList();
			List<SummarizedProject> summarizedProjectList = new ArrayList<SummarizedProject>();
			for(Object[] object: projectList) {
				SummarizedProject project = new SummarizedProject();
				project.setProjectId((Long)object[0]);
				project.setProjectName((String)object[1]);
				summarizedProjectList.add(project);
			}
			return summarizedProjectList;
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<SummarizedProject> getSummarizedProjectsForClient(Long ClientId){
		try {
			Query query = em.createQuery(GET_SUMMARIZED_PROJECTS_FOR_CLIENT);
			query.setParameter(1, ClientId);
			List<Object[]> projectList = query.getResultList();
			List<SummarizedProject> summarizedProjectList = new ArrayList<SummarizedProject>();
			for(Object[] object: projectList) {
				SummarizedProject project = new SummarizedProject();
				project.setProjectId((Long)object[0]);
				project.setProjectName((String)object[1]);
				summarizedProjectList.add(project);
			}
			return summarizedProjectList;
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public Project getProjectById(Long projectId) {
		try {
			return repository.findOne(projectId);
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<Project> addOrUpdateProject(Project project){
		repository.save(project);
		try {
			return this.getClientProjects(project.getClientId());
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<Project> deleteProject(Long projectId) {
		Project obj = repository.findOne(projectId);
		if(obj != null) {
			repository.delete(projectId);
		}
		return repository.findAll();
	}



	public List<Project> getClientProjects(Long clientId) {
		try {
			TypedQuery<Project> query = em.createQuery(GET_CLIENT_PROJECTS, Project.class);
			query.setParameter(1, clientId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<Supplier> getProjectSuppliers(Long projectId){
		try {
			Query query = em.createNamedQuery(NamedQueryConstant.GET_PROJECT_SUPPLIERS);
			query.setParameter("projectId", projectId);
			return (List<Supplier>) query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
}
