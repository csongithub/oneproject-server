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
public class SummarizedProject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3210401576966450031L;

	private Long projectId;

	private String projectName;
	
	private String projectType;
	
	private Date projectStartDate;
	
	private Date projectEndDate;
	
	private double projectCost;
	
	private String bgNumber;
	
	private Double security;
	
	private Date securityDepositDate;
	
	private Date securityExpiryDate;

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

	/**
	 * @return the projectType
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * @return the projectStartDate
	 */
	public Date getProjectStartDate() {
		return projectStartDate;
	}

	/**
	 * @param projectStartDate the projectStartDate to set
	 */
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	/**
	 * @return the projectEndDate
	 */
	public Date getProjectEndDate() {
		return projectEndDate;
	}

	/**
	 * @param projectEndDate the projectEndDate to set
	 */
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	/**
	 * @return the projectCost
	 */
	public double getProjectCost() {
		return projectCost;
	}

	/**
	 * @param projectCost the projectCost to set
	 */
	public void setProjectCost(double projectCost) {
		this.projectCost = projectCost;
	}

	/**
	 * @return the bgNumber
	 */
	public String getBgNumber() {
		return bgNumber;
	}

	/**
	 * @param bgNumber the bgNumber to set
	 */
	public void setBgNumber(String bgNumber) {
		this.bgNumber = bgNumber;
	}

	/**
	 * @return the security
	 */
	public Double getSecurity() {
		return security;
	}

	/**
	 * @param security the security to set
	 */
	public void setSecurity(Double security) {
		this.security = security;
	}

	/**
	 * @return the securityDepositDate
	 */
	public Date getSecurityDepositDate() {
		return securityDepositDate;
	}

	/**
	 * @param securityDepositDate the securityDepositDate to set
	 */
	public void setSecurityDepositDate(Date securityDepositDate) {
		this.securityDepositDate = securityDepositDate;
	}

	/**
	 * @return the securityExpiryDate
	 */
	public Date getSecurityExpiryDate() {
		return securityExpiryDate;
	}

	/**
	 * @param securityExpiryDate the securityExpiryDate to set
	 */
	public void setSecurityExpiryDate(Date securityExpiryDate) {
		this.securityExpiryDate = securityExpiryDate;
	}
}
