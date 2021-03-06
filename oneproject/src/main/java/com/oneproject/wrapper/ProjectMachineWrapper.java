/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chandan
 *
 */
public class ProjectMachineWrapper implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long linkageId;
	private Long machineId;
	private String machineName;
	private String machineNumber;
	private String machineType;
	private String owner;
	private String charge; // 200 Per Month "\u20B9"
	private Float price;
	private Date joined;
	private String pricingUnit;
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
	 * @return the machineName
	 */
	public String getMachineName() {
		return machineName;
	}
	/**
	 * @param machineName the machineName to set
	 */
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	/**
	 * @return the machineNumber
	 */
	public String getMachineNumber() {
		return machineNumber;
	}
	/**
	 * @param machineNumber the machineNumber to set
	 */
	public void setMachineNumber(String machineNumber) {
		this.machineNumber = machineNumber;
	}
	/**
	 * @return the machineType
	 */
	public String getMachineType() {
		return machineType;
	}
	/**
	 * @param machineType the machineType to set
	 */
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the charge
	 */
	public String getCharge() {
		return charge;
	}
	/**
	 * @param charge the charge to set
	 */
	public void setCharge(String charge) {
		this.charge = charge;
	}
	/**
	 * @return the joined
	 */
	public Date getJoined() {
		return joined;
	}
	/**
	 * @param joined the joined to set
	 */
	public void setJoined(Date joined) {
		this.joined = joined;
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
}
