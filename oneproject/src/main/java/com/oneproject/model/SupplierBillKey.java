/**
 * 
 */
package com.oneproject.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author chandan
 *
 */
@Embeddable
public class SupplierBillKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BILL_ID")
	private Long billId;
	
	@Column(name = "SUPPLIER_ID")
	private Long supplierId;
	
	@Column(name = "PROJECT_ID")
	private Long projectId;

	public SupplierBillKey() {
	}

	public SupplierBillKey(Long billId, Long supplierId, Long projectId) {
		super();
		this.billId = billId;
		this.supplierId = supplierId;
		this.projectId = projectId;
	}

	/**
	 * @return the billId
	 */
	public Long getBillId() {
		return billId;
	}

	/**
	 * @param billId the billId to set
	 */
	public void setBillId(Long billId) {
		this.billId = billId;
	}

	/**
	 * @return the supplierId
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o)
        	return true;
        if (!(o instanceof SupplierBillKey)) 
        	return false;
        SupplierBillKey that = (SupplierBillKey) o;
        return Objects.equals(getBillId(), that.getBillId()) 
        		&& Objects.equals(getSupplierId(), that.getSupplierId())
        		&& Objects.equals(getProjectId(), that.getProjectId());        
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getBillId(), getSupplierId(), getProjectId());
    }
}
