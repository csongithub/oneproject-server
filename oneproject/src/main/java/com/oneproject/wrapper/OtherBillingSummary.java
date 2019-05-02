/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author chandan
 *
 */
public class OtherBillingSummary implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double totalBillingAmount = 0.0d;
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
}
