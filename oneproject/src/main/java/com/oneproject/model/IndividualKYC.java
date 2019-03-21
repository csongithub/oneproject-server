/**
 * 
 */
package com.oneproject.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author chandan
 *
 */
@Entity
@Table(name = "INDIVIDUAL_KYC")
public class IndividualKYC implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "KYC_ID")
	private Long kycId;
	
	@Column(name = "DOCUMENT")
	private String documentType;
	
	@Column(name = "DOCUMENT_ID")
	private String documentId;
	
	@Column(name = "STATUS")
	private String status = "NOT CONFIRMED";
	
	@Column(name = "CONFIRMATION_DATE")
	@Temporal(TemporalType.DATE)
	private Date confirmationDate;

	/**
	 * @return the kycId
	 */
	public Long getKycId() {
		return kycId;
	}

	/**
	 * @param kycId the kycId to set
	 */
	public void setKycId(Long kycId) {
		this.kycId = kycId;
	}

	/**
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}

	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
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
