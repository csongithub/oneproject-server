/**
 * 
 */
package com.oneproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author chandan
 *
 */
@Entity
@Table(name = "MACHINE")
public class Machine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MACHINE_ID")
	private Long machineId;
	
	@Column(name = "CLIENT_ID")
	private Long clientId;
	
	@Column(name = "MACHINE_NAME")
	private String machineName;
	
	@Column(name = "MACHINE_NUMBER")
	private String machineNumber;
	
	@Column(name = "RATE")
	private String rate;
	
	@Column(name = "RATE_INTR")
	private String rateInterval;
	
	@OneToOne
	@JoinColumn(name="INDIVIDUAL_ID")
	private Individual owner;
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
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * @return the rateInterval
	 */
	public String getRateInterval() {
		return rateInterval;
	}
	/**
	 * @param rateInterval the rateInterval to set
	 */
	public void setRateInterval(String rateInterval) {
		this.rateInterval = rateInterval;
	}
	/**
	 * @return the owner
	 */
	public Individual getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Individual owner) {
		this.owner = owner;
	}
	/**
	 * @return the clientId
	 */
	public Long getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
}
