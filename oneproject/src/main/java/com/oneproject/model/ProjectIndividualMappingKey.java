/**
 * 
 */
package com.oneproject.model;

import java.io.Serializable;

/**
 * @author chandan
 *
 */

public class ProjectIndividualMappingKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7202170884234677880L;

	private Long projectId;
	
	private Long individualId;

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the individualId
	 */
	public Long getIndividualId() {
		return individualId;
	}

	/**
	 * @param individualId the individualId to set
	 */
	public void setIndividualId(Long individualId) {
		this.individualId = individualId;
	}
	
}
