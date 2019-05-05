/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author chandan
 *
 */
public class IndividualPaymentsSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 256989482070214095L;
	
	private Double totalPaymentAmount = 0.0d;
	
	private Double totalPaidAmount = 0.0d;
	
	private Double totalDueAmount = 0.0d;
	
	private Double totalAdvanceAmount = 0.0d;
	
	private Double totalOtherExpensePaid = 0.0;

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
	 * @return the totalPaidAmount
	 */
	public Double getTotalPaidAmount() {
		return totalPaidAmount;
	}

	/**
	 * @param totalPaidAmount the totalPaidAmount to set
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

	/**
	 * @return the totalOtherExpensePaid
	 */
	public Double getTotalOtherExpensePaid() {
		return totalOtherExpensePaid;
	}

	/**
	 * @param totalOtherExpensePaid the totalOtherExpensePaid to set
	 */
	public void setTotalOtherExpensePaid(Double totalOtherExpensePaid) {
		this.totalOtherExpensePaid = totalOtherExpensePaid;
	}
}
