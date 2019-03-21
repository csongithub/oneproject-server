/**
 * 
 */
package com.oneproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author chandan
 *
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private Long id;
	
	@Column(name = "HOUSE_NUMBER")
	private String houseNumber;
	
	@Column(name = "VILLAGE")
	private String village;
	
	@Column(name = "AREA")
	private String area;
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "POST_OFFICE")
	private String postOffice;
	
	@Column(name = "POLICE_STATION")
	private String policeStation;
	
	@Column(name = "LINE_ONE")
	private String lineOne;
	
	@Column(name = "LINE_TWO")
	private String lineTwo;
	
	@Column(name = "DISTRICT")
	private String district;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "ZIP")
	private String zip;
	
	@Column(name = "PHONE_ONE")
	private String phoneOne;
	
	@Column(name = "PHONE_TWO")
	private String phoneTwo;
	
	@Column(name = "EMAIL")
	private String email;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * @return the village
	 */
	public String getVillage() {
		return village;
	}

	/**
	 * @param village the village to set
	 */
	public void setVillage(String village) {
		this.village = village;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the postOffice
	 */
	public String getPostOffice() {
		return postOffice;
	}

	/**
	 * @param postOffice the postOffice to set
	 */
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	/**
	 * @return the policeStation
	 */
	public String getPoliceStation() {
		return policeStation;
	}

	/**
	 * @param policeStation the policeStation to set
	 */
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	/**
	 * @return the lineOne
	 */
	public String getLineOne() {
		return lineOne;
	}

	/**
	 * @param lineOne the lineOne to set
	 */
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	/**
	 * @return the lineTwo
	 */
	public String getLineTwo() {
		return lineTwo;
	}

	/**
	 * @param lineTwo the lineTwo to set
	 */
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the phoneOne
	 */
	public String getPhoneOne() {
		return phoneOne;
	}

	/**
	 * @param phoneOne the phoneOne to set
	 */
	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}

	/**
	 * @return the phoneTwo
	 */
	public String getPhoneTwo() {
		return phoneTwo;
	}

	/**
	 * @param phoneTwo the phoneTwo to set
	 */
	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}	
}
