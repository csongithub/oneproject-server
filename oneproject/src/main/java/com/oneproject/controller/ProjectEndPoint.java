/**
 * 
 */
package com.oneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneproject.model.Project;
import com.oneproject.model.ProjectIndividualMapping;
import com.oneproject.service.ProjectService;
import com.oneproject.wrapper.ProjectIndividualMapingDataWrapper;
import com.oneproject.wrapper.SummarizedProject;

/**
 * @author chandan
 *
 */
@RestController
@RequestMapping(value = "ProjectEndPoint")
public class ProjectEndPoint {
	
	@Autowired
	private ProjectService service;
	
	
	
	@GetMapping(value = "getAllProjects")
	public List<Project> getAllProjects(){
		return service.getAllProjects();
	}
	
	
	
	@GetMapping(value = "getSummarizedProjects")
	public List<SummarizedProject> getSummarizedProjects(){
		return service.getSummarizedProjects();
	}
	
	
	
	@PostMapping(value = "addOrUpdateProject")
	public List<Project> addOrUpdateProject(@RequestBody Project project){
		return service.addOrUpdateProject(project);
	}
	
	
	
	@DeleteMapping(value = "deleteProject/{projectId}")
	public List<Project> deleteProject(@PathVariable("projectId")Long projectId){
		return service.deleteProject(projectId);
	}
	
	
	
	@PostMapping(value = "linkIndividual")
	public List<ProjectIndividualMapping> linkIndividual(@RequestBody ProjectIndividualMapingDataWrapper wrapper){
		return service.linkIndividual(wrapper);
	}
	
	
	
	@PostMapping(value = "delinkIndividual/{projectId}/{individualId}")
	public Project delinkIndividual(@PathVariable("projectId")Long projectId, @PathVariable("individualId") Long individualId){
		return service.delinkIndividual(projectId, individualId);
	}
	
	
	
	@GetMapping(value = "getIndividualsForProject/{projectId}")
	public List<ProjectIndividualMapping> getIndividualsForProject(@PathVariable("projectId")Long projectId){
		return service.getIndividualsForProject(projectId);
	}
}
