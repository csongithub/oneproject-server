/**
 * 
 */
package com.oneproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.oneproject.constant.NamedQueryConstant;

/**
 * @author chandan
 *
 */
@Entity
@Table(name="PROJECT")
@NamedQuery(name=NamedQueryConstant.GET_PROJECT_SUPPLIERS, query=NamedQueryConstant.GET_PROJECT_SUPPLIERS_QUERY)
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
	
	@Column(name = "BG_NUMBER")
	private String bgNumber;
	
	@Column(name = "SECURITY_AMOUNT")
	private Double security;
	
	@Column(name = "SEC_SUB_DATE")
	@Temporal(TemporalType.DATE)
	private Date securityDepositDate;
	
	@Column(name = "SEC_EXP_DATE")
	@Temporal(TemporalType.DATE)
	private Date securityExpiryDate;
	
	@OneToMany(mappedBy = "projectId", cascade = CascadeType.ALL)
	private List<ProjectIndividualMapping> projectIndividuals = new ArrayList<ProjectIndividualMapping>();
	
	@ManyToMany
	@JoinTable(name = "PROJECT_SUPPLIERS",
	          joinColumns = {@JoinColumn(name = "PROJECT_ID", unique = false)},
	          inverseJoinColumns = {@JoinColumn(name = "SUPPLIER_ID", unique = false)}
	)
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PROJECT_MACHINES",
    	joinColumns = {@JoinColumn(name = "PROJECT_ID", unique = false)},
    	inverseJoinColumns = {@JoinColumn(name = "LINKAGE_ID", unique = false)}
	)
	private List<ProjectMachineLinkage> projectMachineLinkage = new ArrayList<ProjectMachineLinkage>();
	
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

	/**
	 * @return the projectMachineLinkage
	 */
	public List<ProjectMachineLinkage> getProjectMachineLinkage() {
		return projectMachineLinkage;
	}

	/**
	 * @param projectMachineLinkage the projectMachineLinkage to set
	 */
	public void setProjectMachineLinkage(List<ProjectMachineLinkage> projectMachineLinkage) {
		this.projectMachineLinkage = projectMachineLinkage;
	}
}
