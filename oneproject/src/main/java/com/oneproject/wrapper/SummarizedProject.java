/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author chandan
 *
 */
public class SummarizedProject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3210401576966450031L;

	private Long projectId;

	private String projectName;

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
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
