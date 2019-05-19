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
@Table(name = "MACHINE_BILL")
public class MachineBill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BILL_ID")
	private Long billId;
	
	@Column(name = "MACHINE_ID")
	private Long machineId;
	
	@Column(name = "PROJECT_ID")
	private  Long projectId;
	
	@Column(name = "REASON")
	private String reason;
	
	@Column(name = "BILLING_DATE")
	@Temporal(TemporalType.DATE)
	private Date billingDate;
	
	@Column(name = "PAYMENT_DATE")
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
	@Column(name = "RUNNING_PERIOD")
	private String runningPeriod;
	
	@Column(name = "PAYMENT_FOR")
	private String paymentFor;
	
	@Column(name = "BILLING_AMOUNT")
	private Double billingAmount;
	
	@Column(name = "PAID_AMOUNT")
	private Double paidAmount;
	
	@Column(name = "DUE_AMOUNT")
	private Double dueAmount;
	
	@Column(name = "MODE")
	private String mode;
	
	@Column(name = "COMMENT")
	private String comment;
	/**
	 * @return the billId
	 */
	public Long getBillId() {
		return billId;
	}

	/**
	 * @param billId the billId to set
	 */
	public void setBillId(Long billId) {
		this.billId = billId;
	}

	/**
	 * @return the machineId
	 */
	public Long getMachineId() {
		return machineId;
	}

	/**
	 * @param machineId the machineId to set
	 */
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}

	/**
	 * @return the billingDate
	 */
	public Date getBillingDate() {
		return billingDate;
	}

	/**
	 * @param billingDate the billingDate to set
	 */
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
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
	 * @return the runningPeriod
	 */
	public String getRunningPeriod() {
		return runningPeriod;
	}

	/**
	 * @param runningPeriod the runningPeriod to set
	 */
	public void setRunningPeriod(String runningPeriod) {
		this.runningPeriod = runningPeriod;
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

	/**
	 * @return the billingAmount
	 */
	public Double getBillingAmount() {
		return billingAmount;
	}

	/**
	 * @param billingAmount the billingAmount to set
	 */
	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
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
}
