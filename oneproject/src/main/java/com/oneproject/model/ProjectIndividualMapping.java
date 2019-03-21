/**
 * 
 */
package com.oneproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author chandan
 *
 */
@Entity
@Table(name = "PROJECT_INDIVIDUAL_MAPPING")
@IdClass(ProjectIndividualMappingKey.class)
public class ProjectIndividualMapping implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
	private Project projectId;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "INDIVIDUAL_ID", referencedColumnName = "INDIVIDUAL_ID")
	private Individual individualId;
	
	@Transient
	private String projectName;
	
	
	@Transient
	private String individualFullName;
	
	@JoinColumn(name = "ROLE")
	private String role;
	
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

	/**
	 * @return the individualFullName
	 */
	public String getIndividualFullName() {
		return individualFullName;
	}

	/**
	 * @param individualFullName the individualFullName to set
	 */
	public void setIndividualFullName(String individualFullName) {
		this.individualFullName = individualFullName;
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

	@JoinColumn(name = "JOINING_DATE")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId.getProjectId();
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the individualId
	 */
	public Long getIndividualId() {
		return individualId.getIndividualId();
	}

	/**
	 * @param individualId the individualId to set
	 */
	public void setIndividualId(Individual individualId) {
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
}
