/**
 * 
 */
package com.oneproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author a698219
 *
 */
@Entity
@Table(name = "SALARY")
public class Salary {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "SALARY_ID")
	private Long id;
	
	@Column(name = "INDIVIDUAL_ID")
	private Long individualId;
	
	@Column(name = "SALARY")
	private Double salary;
	
	@Column(name = "SAL_INTERVAL")
	private String interval;
	
	@Column(name = "EFFECTIVE_FROM")
	@Temporal(TemporalType.DATE)
	private Date effectiveFrom;
	
	@Column(name = "EFFECTIVE_TO")
	@Temporal(TemporalType.DATE)
	private Date effectiveTo;
	
	@Column(name = "STATUS")
	private String status;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}


	/**
	 * @return the interval
	 */
	public String getInterval() {
		return interval;
	}


	/**
	 * @param interval the interval to set
	 */
	public void setInterval(String interval) {
		this.interval = interval;
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
	 * @return the effectiveFrom
	 */
	public Date getEffectiveFrom() {
		return effectiveFrom;
	}


	/**
	 * @param effectiveFrom the effectiveFrom to set
	 */
	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}


	/**
	 * @return the effectiveTo
	 */
	public Date getEffectiveTo() {
		return effectiveTo;
	}


	/**
	 * @param effectiveTo the effectiveTo to set
	 */
	public void setEffectiveTo(Date effectiveTo) {
		this.effectiveTo = effectiveTo;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
