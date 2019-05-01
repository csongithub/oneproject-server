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
	
	private Double totalBillingAmount = 0.0d;
	
	private Double totalPaymentAmount = 0.0d;
	
	private Double totalDueAmount = 0.0d;

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
}
