/**
 * 
 */
package com.oneproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author chandan
 *
 */
@Entity
@Table(name = "ENUMERATIONS_PREFERENCES")
public class AdminEnumerationsPreferences {
	
	@Id
	@Column(name = "PREFERENCES_ID")
	private Long preferencesId = 1L;
	
	@Transient
	private String value;
	
	@Transient
	private String genderJson;
	
	@Transient
	private String positionJson;
	
	@Transient
	private String kycSupportedDocsJson;
	
	@Transient
	private String projectTypeJson;
	
	@Transient
	private String materialTypeJson;
	
	@Transient
	private String salaryIntervalJson;
	
	@Column(name = "GENDER", length=10000)
	private byte[] gender;
	
	@Column(name = "POSITION", length=10000)
	private byte[] position;
	
	@Column(name = "PROJECT_TYPE", length=10000)
	private byte[] projectType;
	
	@Column(name = "KYC_DOCUMENTS", length=10000)
	private byte[] kycSupportedDocs;
	
	@Column(name = "MATERIAL_TYPES", length=10000)
	private byte[] materialType;
	
	@Column(name = "SAL_INTERVAL", length=10000)
	private byte[] salaryInterval;
	
	@Transient
	private String preferencesType;
	/**
	 * @return the preferencesId
	 */
	public Long getPreferencesId() {
		return preferencesId;
	}
	/**
	 * @param preferencesId the preferencesId to set
	 */
	public void setPreferencesId(Long preferencesId) {
		this.preferencesId = preferencesId;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the gender
	 */
	public byte[] getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(byte[] gender) {
		this.gender = gender;
	}
	/**
	 * @return the position
	 */
	public byte[] getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(byte[] position) {
		this.position = position;
	}
	/**
	 * @return the projectType
	 */
	public byte[] getProjectType() {
		return projectType;
	}
	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType(byte[] projectType) {
		this.projectType = projectType;
	}
	/**
	 * @return the preferencesType
	 */
	public String getPreferencesType() {
		return preferencesType;
	}
	/**
	 * @param preferencesType the preferencesType to set
	 */
	public void setPreferencesType(String preferencesType) {
		this.preferencesType = preferencesType;
	}
	/**
	 * @return the genderJson
	 */
	public String getGenderJson() {
		return genderJson;
	}
	/**
	 * @param genderJson the genderJson to set
	 */
	public void setGenderJson(String genderJson) {
		this.genderJson = genderJson;
	}
	/**
	 * @return the positionJson
	 */
	public String getPositionJson() {
		return positionJson;
	}

	/**
	 * @param positionJson the positionJson to set
	 */
	public void setPositionJson(String positionJson) {
		this.positionJson = positionJson;
	}

	/**
	 * @return the projectTypeJson
	 */
	public String getProjectTypeJson() {
		return projectTypeJson;
	}
	/**
	 * @param projectTypeJson the projectTypeJson to set
	 */
	public void setProjectTypeJson(String projectTypeJson) {
		this.projectTypeJson = projectTypeJson;
	}
	/**
	 * @return the kycSupportedDocsJson
	 */
	public String getKycSupportedDocsJson() {
		return kycSupportedDocsJson;
	}
	/**
	 * @param kycSupportedDocsJson the kycSupportedDocsJson to set
	 */
	public void setKycSupportedDocsJson(String kycSupportedDocsJson) {
		this.kycSupportedDocsJson = kycSupportedDocsJson;
	}
	/**
	 * @return the kycSupportedDocs
	 */
	public byte[] getKycSupportedDocs() {
		return kycSupportedDocs;
	}
	/**
	 * @param kycSupportedDocs the kycSupportedDocs to set
	 */
	public void setKycSupportedDocs(byte[] kycSupportedDocs) {
		this.kycSupportedDocs = kycSupportedDocs;
	}
	/**
	 * @return the materialTypeJson
	 */
	public String getMaterialTypeJson() {
		return materialTypeJson;
	}
	/**
	 * @param materialTypeJson the materialTypeJson to set
	 */
	public void setMaterialTypeJson(String materialTypeJson) {
		this.materialTypeJson = materialTypeJson;
	}
	/**
	 * @return the materialType
	 */
	public byte[] getMaterialType() {
		return materialType;
	}
	/**
	 * @param materialType the materialType to set
	 */
	public void setMaterialType(byte[] materialType) {
		this.materialType = materialType;
	}
	/**
	 * @return the salaryIntervalJson
	 */
	public String getSalaryIntervalJson() {
		return salaryIntervalJson;
	}
	/**
	 * @param salaryIntervalJson the salaryIntervalJson to set
	 */
	public void setSalaryIntervalJson(String salaryIntervalJson) {
		this.salaryIntervalJson = salaryIntervalJson;
	}
	/**
	 * @return the salaryInterval
	 */
	public byte[] getSalaryInterval() {
		return salaryInterval;
	}
	/**
	 * @param salaryInterval the salaryInterval to set
	 */
	public void setSalaryInterval(byte[] salaryInterval) {
		this.salaryInterval = salaryInterval;
	}
}
