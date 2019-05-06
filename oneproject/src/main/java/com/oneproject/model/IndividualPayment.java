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
 * @author chandan
 *
 */
@Entity
@Table(name = "INDIVIDUAL_PAYMENT")
public class IndividualPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAYMENT_ID")
	private Long id;
	
	@Column(name = "INDIVIDUAL_ID")
	private Long individualId;
	
	@Column(name = "REASON")
	private String reason;
	
	@Column(name = "SAL_AMOUNT")
	private Double salaryAmount;
	
	@Column(name = "PAID_AMOUNT")
	private Double paidAmount;
	
	//this will be stamped against paid amount
	@Column(name = "DUE_AMOUNT")
	private Double dueAmount;
	
	@Column(name = "MODE") // Cash or Card or Account Transfer
	private String mode;
	
	@Column(name = "STATUS") //PAID or PENDING
	private String status;
	
	@Column(name = "PAYMENT_DATE")
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
	@Column(name = "FOR_MONTH")
	private String forMonth;
	
	@Column(name = "FOR_YEAR")
	private String forYear;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "PAYMENT_FOR")
	private String paymentFor;

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
	 * @return the salaryAmount
	 */
	public Double getSalaryAmount() {
		return salaryAmount;
	}

	/**
	 * @param salaryAmount the salaryAmount to set
	 */
	public void setSalaryAmount(Double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	/**
	 * @return the paidAmount
	 */
	public Double getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @param paidAmount the paidAmount to set
	 */
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * @return the dueAmount
	 */
	public Double getDueAmount() {
		return dueAmount;
	}

	/**
	 * @param dueAmount the dueAmount to set
	 */
	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
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

	/**
	 * @return the forMonth
	 */
	public String getForMonth() {
		return forMonth;
	}

	/**
	 * @param forMonth the forMonth to set
	 */
	public void setForMonth(String forMonth) {
		this.forMonth = forMonth;
	}

	/**
	 * @return the forYear
	 */
	public String getForYear() {
		return forYear;
	}

	/**
	 * @param forYear the forYear to set
	 */
	public void setForYear(String forYear) {
		this.forYear = forYear;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the paymentFor
	 */
	public String getPaymentFor() {
		return paymentFor;
	}

	/**
	 * @param paymentFor the paymentFor to set
	 */
	public void setPaymentFor(String paymentFor) {
		this.paymentFor = paymentFor;
	}
}
