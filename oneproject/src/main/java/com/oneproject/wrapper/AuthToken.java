/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author chandan
 *
 */
public class AuthToken implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long clientId;
	
	private Boolean authenticated;
	
	private String clientName;

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

	/**
	 * @return the authenticated
	 */
	public Boolean getAuthenticated() {
		return authenticated;
	}

	/**
	 * @param authenticated the authenticated to set
	 */
	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
}
