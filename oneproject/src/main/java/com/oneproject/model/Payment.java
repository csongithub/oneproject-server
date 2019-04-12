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
@Table(name = "PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAYMENT_ID")
	private Long id;
	
	@Column(name = "INDIVIDUAL_ID")
	private Long individualId;
	
	@Column(name = "ENTITY")
	private String entity;
	/**
	 * amount represents the salary amount
	 */
	@Column(name = "SALARY_AMOUNT")
	private Double salaryAmount;
	/**
	 * dueAmount represent due salary amount
	 */
	@Column(name = "DUE_SALARY_AMOUNT")
	private Double dueSalaryAmount;
	/**
	 * duesAmount represent the payment of previous dues
	 */
	@Column(name = "DUES_PAYMENT")
	private Double duesPayment;
	/**
	 * advanceAmount represents the amount of advance payment
	 */
	@Column(name = "ADVANCE_PAYMENT")
	private Double advancePayment;
	
	@Column(name = "RECOVERY_AMOUNT")
	private Double recoveryAmount;
	
	@Column(name = "PAYMENT_FOR")
	@Temporal(TemporalType.DATE)
	private Date paymentFor;
	
	@Column(name = "REASON")
	private String reason;
	
	@Column(name = "MODE")
	private String mode;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "ENTRY_DATE")
	@Temporal(TemporalType.DATE)
	private Date entryDate;

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
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
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
	 * @return the dueSalaryAmount
	 */
	public Double getDueSalaryAmount() {
		return dueSalaryAmount;
	}

	/**
	 * @param dueSalaryAmount the dueSalaryAmount to set
	 */
	public void setDueSalaryAmount(Double dueSalaryAmount) {
		this.dueSalaryAmount = dueSalaryAmount;
	}

	/**
	 * @return the duesPayment
	 */
	public Double getDuesPayment() {
		return duesPayment;
	}

	/**
	 * @param duesPayment the duesPayment to set
	 */
	public void setDuesPayment(Double duesPayment) {
		this.duesPayment = duesPayment;
	}

	/**
	 * @return the advancePayment
	 */
	public Double getAdvancePayment() {
		return advancePayment;
	}

	/**
	 * @param advancePayment the advancePayment to set
	 */
	public void setAdvancePayment(Double advancePayment) {
		this.advancePayment = advancePayment;
	}
	/**
	 * @return the recoveryAmount
	 */
	public Double getRecoveryAmount() {
		return recoveryAmount;
	}

	/**
	 * @param recoveryAmount the recoveryAmount to set
	 */
	public void setRecoveryAmount(Double recoveryAmount) {
		this.recoveryAmount = recoveryAmount;
	}

	/**
	 * @return the paymentFor
	 */
	public Date getPaymentFor() {
		return paymentFor;
	}

	/**
	 * @param paymentFor the paymentFor to set
	 */
	public void setPaymentFor(Date paymentFor) {
		this.paymentFor = paymentFor;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the entryDate
	 */
	public Date getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
}
