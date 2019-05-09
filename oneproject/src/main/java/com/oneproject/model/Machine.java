/**
 * 
 */
package com.oneproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "MACHINE_NUMBER")
	private String machineNumber;
	
	@Column(name = "CLIENT_ID")
	private Long clientId;
	
	@Column(name = "MACHINE_NAME")
	private String machineName;
	
	@OneToOne
	@JoinColumn(name="INDIVIDUAL_ID")
	private Individual owner;
	
	@Column(name = "MACHINE_TYPE")
	private String machineType;
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
