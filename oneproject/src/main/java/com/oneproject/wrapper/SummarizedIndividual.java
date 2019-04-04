/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author a698219
 *
 */
public class SummarizedIndividual implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long individualId;
	private String firstName;
	private String middleName;
	private String lastName;
	
	public SummarizedIndividual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SummarizedIndividual(Long individualId, String firstName, String middleName, String lastName) {
		super();
		this.individualId = individualId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	/**
	 * @return the individualId
	 */
	public Long getIndividualId() {
		return individualId;
	}

	/**
	 * @param individualId the individualId to set
	 */
	public void setIndividualId(Long individualId) {
		this.individualId = individualId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
