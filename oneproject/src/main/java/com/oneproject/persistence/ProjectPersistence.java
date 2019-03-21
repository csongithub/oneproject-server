/**
 * 
 */
package com.oneproject.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.Project;
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
	
	
	
	public List<Project> getAllProjects(){
		return repository.findAll();
	}
	
	
	
	public List<SummarizedProject> getSummarizedProjects(){
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
	}
	
	
	
	public Project getprojectById(Long projectId) {
		return repository.findOne(projectId);
	}
	
	
	
	public List<Project> addOrUpdateProject(Project project){
		repository.save(project);
		return repository.findAll();
	}
	
	
	
	public List<Project> deleteProject(Long projectId) {
		Project obj = repository.findOne(projectId);
		if(obj != null) {
			repository.delete(projectId);
		}
		return repository.findAll();
	}

}
