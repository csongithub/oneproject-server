package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author chandan
 *
 */
public class MachinePricingWrapper implements Serializable {
	/**
	 * @return the linkageId
	 */
	public Long getLinkageId() {
		return linkageId;
	}

	/**
	 * @param linkageId the linkageId to set
	 */
	public void setLinkageId(Long linkageId) {
		this.linkageId = linkageId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long linkageId;
	
	private Double billAmount;
	
	private int hours;
	
	private int minutes;
	
	private int months;
	
	private int days;

	/**
	 * @return the linkageID
	 */
	public Long getLinkageID() {
		return linkageId;
	}

	/**
	 * @param linkageID the linkageID to set
	 */
	public void setLinkageID(Long linkageID) {
		this.linkageId = linkageID;
	}
	
	/**
	 * @return the billAmount
	 */
	public Double getBillAmount() {
		return billAmount;
	}

	/**
	 * @param billAmount the billAmount to set
	 */
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}


	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the months
	 */
	public int getMonths() {
		return months;
	}

	/**
	 * @param months the months to set
	 */
	public void setMonths(int months) {
		this.months = months;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}
}
