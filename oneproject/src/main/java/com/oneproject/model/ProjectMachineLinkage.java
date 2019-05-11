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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author chandan
 *
 */
@Entity
@Table(name = "PROJECT_MACHINE_LINKAGE")
public class ProjectMachineLinkage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LINKAGE_ID")
	private Long linkageId;
	
	@OneToOne
	@JoinColumn(name = "MACHINE_ID")
	private Machine machine;
	
	@Column(name = "JOINED_ON")
	@Temporal(TemporalType.DATE)
	private Date joinedOn;
	
	@Column(name = "PRICE")
	private Float price;
	
	@Column(name = "PRICING_UNIT")
	private String pricingUnit; // hour, month

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
	 * @return the machine
	 */
	public Machine getMachine() {
		return machine;
	}

	/**
	 * @param machine the machine to set
	 */
	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	/**
	 * @return the joinedOn
	 */
	public Date getJoinedOn() {
		return joinedOn;
	}

	/**
	 * @param joinedOn the joinedOn to set
	 */
	public void setJoinedOn(Date joinedOn) {
		this.joinedOn = joinedOn;
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the pricingUnit
	 */
	public String getPricingUnit() {
		return pricingUnit;
	}

	/**
	 * @param pricingUnit the pricingUnit to set
	 */
	public void setPricingUnit(String pricingUnit) {
		this.pricingUnit = pricingUnit;
	}
}
