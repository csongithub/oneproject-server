/**
 * 
 */
package com.oneproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author a698219
 *
 */
@Entity
@Table(name = "OTHER_BILL")
public class OtherBill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BILL_ID")
	private Long billId;
	
	@Column(name = "CLIENT_ID")
	private Long clientId;
	
	@Column(name = "PROJECT_ID")
	private Long projectId;
	
	@Column(name = "BILLING_DATE")
	private Date billingDate;
	
	@OneToMany
	@JoinTable(name = "OTHER_BILL_ITEMS",
	          joinColumns = {@JoinColumn(name = "BILL_ID", unique = false)},
	          inverseJoinColumns = {@JoinColumn(name = "ITEM_ID", unique = false)}
	)
	private List<Item> itmes = new ArrayList<Item>();

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

	/**
	 * @return the billingDate
	 */
	public Date getBillingDate() {
		return billingDate;
	}

	/**
	 * @param billingDate the billingDate to set
	 */
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	/**
	 * @return the itmes
	 */
	public List<Item> getItmes() {
		return itmes;
	}

	/**
	 * @param itmes the itmes to set
	 */
	public void setItmes(List<Item> itmes) {
		this.itmes = itmes;
	}
}
