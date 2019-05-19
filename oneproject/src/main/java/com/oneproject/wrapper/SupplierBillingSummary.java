/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author chandan
 *
 */
public class SupplierBillingSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String supplierName;
	
	private Long supplierId;
	
	private Double totalBillingAmount = 0.0d;
	
	private Double totalPaymentAmount = 0.0d;
	
	private Double totalDueAmount = 0.0d;
	
	private Double totalAdvanceAmount = 0.0d;
	
	private float billingPercentage = 100.0f;
	private float paymentPercentage = 0.0f;
	private float duePercentage = 0.0f;
	private float advPercentage = 0.0f;

	/**
	 * @return the totalBillingAmount
	 */
	public Double getTotalBillingAmount() {
		return totalBillingAmount;
	}

	/**
	 * @param totalBillingAmount the totalBillingAmount to set
	 */
	public void setTotalBillingAmount(Double totalBillingAmount) {
		this.totalBillingAmount = totalBillingAmount;
	}

	/**
	 * @return the totalPaymentAmount
	 */
	public Double getTotalPaymentAmount() {
		return totalPaymentAmount;
	}

	/**
	 * @param totalPaymentAmount the totalPaymentAmount to set
	 */
	public void setTotalPaymentAmount(Double totalPaymentAmount) {
		this.totalPaymentAmount = totalPaymentAmount;
	}

	/**
	 * @return the totalDueAmount
	 */
	public Double getTotalDueAmount() {
		return totalDueAmount;
	}

	/**
	 * @param totalDueAmount the totalDueAmount to set
	 */
	public void setTotalDueAmount(Double totalDueAmount) {
		this.totalDueAmount = totalDueAmount;
	}

	/**
	 * @return the totalAdvanceAmount
	 */
	public Double getTotalAdvanceAmount() {
		return totalAdvanceAmount;
	}

	/**
	 * @param totalAdvanceAmount the totalAdvanceAmount to set
	 */
	public void setTotalAdvanceAmount(Double totalAdvanceAmount) {
		this.totalAdvanceAmount = totalAdvanceAmount;
	}

	/**
	 * @return the billingPercentage
	 */
	public float getBillingPercentage() {
		return billingPercentage;
	}

	/**
	 * @param billingPercentage the billingPercentage to set
	 */
	public void setBillingPercentage(float billingPercentage) {
		this.billingPercentage = billingPercentage;
	}

	/**
	 * @return the paymentPercentage
	 */
	public float getPaymentPercentage() {
		return paymentPercentage;
	}

	/**
	 * @param paymentPercentage the paymentPercentage to set
	 */
	public void setPaymentPercentage(float paymentPercentage) {
		this.paymentPercentage = paymentPercentage;
	}

	/**
	 * @return the duePercentage
	 */
	public float getDuePercentage() {
		return duePercentage;
	}

	/**
	 * @param duePercentage the duePercentage to set
	 */
	public void setDuePercentage(float duePercentage) {
		this.duePercentage = duePercentage;
	}

	/**
	 * @return the advPercentage
	 */
	public float getAdvPercentage() {
		return advPercentage;
	}

	/**
	 * @param advPercentage the advPercentage to set
	 */
	public void setAdvPercentage(float advPercentage) {
		this.advPercentage = advPercentage;
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return the supplierId
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
}
