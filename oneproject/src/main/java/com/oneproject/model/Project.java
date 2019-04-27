/**
 * 
 */
package com.oneproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author chandan
 *
 */
@Entity
@Table(name="PROJECT")
public class Project extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "PROJECT_ID")
	private Long projectId;
	
	@Column(name = "PROJECT_NAME")
	private String projectName;
	
	@Column(name = "PROJECT_TYPE")
	private String projectType;
	
	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date projectStartDate;
	
	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date projectEndDate;
	
	@Column(name = "PROJECT_COST")
	private double projectCost;
	
	@OneToMany(mappedBy = "projectId")
	private List<ProjectIndividualMapping> projectIndividuals = new ArrayList<ProjectIndividualMapping>();
	
	@OneToMany
	@JoinTable(name = "PROJECT_SUPPLIERS",
	          joinColumns = {@JoinColumn(name = "PROJECT_ID")},
	          inverseJoinColumns = {@JoinColumn(name = "SUPPLIER_ID")}
	)
	private List<Supplier> suppliers = new ArrayList<Supplier>();
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
	 * @return the projectIndividuals
	 */
	public List<ProjectIndividualMapping> getProjectIndividuals() {
		return projectIndividuals;
	}

	/**
	 * @param projectIndividuals the projectIndividuals to set
	 */
	public void setProjectIndividuals(List<ProjectIndividualMapping> projectIndividuals) {
		this.projectIndividuals = projectIndividuals;
	}

	/**
	 * @return the suppliers
	 */
	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	/**
	 * @param suppliers the suppliers to set
	 */
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
}
