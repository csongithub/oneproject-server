/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chandan
 *
 */
public class ProjectIndividualMapingDataWrapper implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2684568714364661593L;
	Long projectId;
	Long individualId;
	String role;
	Date joiningDate;
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
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}
	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
}
