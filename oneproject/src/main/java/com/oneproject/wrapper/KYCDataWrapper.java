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
public class KYCDataWrapper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3012041468769591886L;
	
	private Long individualId;
	
	private String fullName;
	
	private String document;
	
	private String documentId;
	
	private String status;
	
	private Date confirmationDate;

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
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * @return the documentId
	 */
	public String getDocumentId() {
		return documentId;
	}

	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the confirmationDate
	 */
	public Date getConfirmationDate() {
		return confirmationDate;
	}

	/**
	 * @param confirmationDate the confirmationDate to set
	 */
	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}
}
