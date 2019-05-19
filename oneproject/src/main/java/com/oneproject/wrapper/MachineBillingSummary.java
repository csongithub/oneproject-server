/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author chandan
 *
 */
public class MachineBillingSummary implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double totalBillingAmount = 0.0d;
	private Double totalPaidAmount = 0.0d;
	private Double totalDueAmount = 0.0d;
	private Double totalAdvanceAmount = 0.0d;
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
	 * @return the totalPaoidAmount
	 */
	public Double getTotalPaidAmount() {
		return totalPaidAmount;
	}
	/**
	 * @param totalPaoidAmount the totalPaoidAmount to set
	 */
	public void setTotalPaidAmount(Double totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
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
}
