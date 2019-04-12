/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author chandan
 *
 */
public class EarningsDataWrapper implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double totalEarnings;
	
	private Double totalDues;
	
	private Double overPaid;

	/**
	 * @return the totalEarnings
	 */
	public Double getTotalEarnings() {
		return totalEarnings;
	}

	/**
	 * @param totalEarnings the totalEarnings to set
	 */
	public void setTotalEarnings(Double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	/**
	 * @return the totalDues
	 */
	public Double getTotalDues() {
		return totalDues;
	}

	/**
	 * @param totalDues the totalDues to set
	 */
	public void setTotalDues(Double totalDues) {
		this.totalDues = totalDues;
	}

	/**
	 * @return the overPaid
	 */
	public Double getOverPaid() {
		return overPaid;
	}

	/**
	 * @param overPaid the overPaid to set
	 */
	public void setOverPaid(Double overPaid) {
		this.overPaid = overPaid;
	}
}
