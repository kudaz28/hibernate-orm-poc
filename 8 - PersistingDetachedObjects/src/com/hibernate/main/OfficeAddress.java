package com.hibernate.main;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OFFICE_ADDRESS")
public class OfficeAddress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8738754885593440323L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OFFICE_ADDRESS_ID")
	private int officeId;

	@Column(name = "BUILDING_NUMBER")
	private int buildingNumber;

	@Column(name = "DESK_NUMBER")
	private String deskNumber;

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTY")
	private String county;

	@Column(name = "STATE")
	private String state;

	@Column(name = "POST_CODE")
	private String postCode;

	@Column(name = "COUNTRY")
	private String country;

	public OfficeAddress() {
		super();
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getDeskNumber() {
		return deskNumber;
	}

	public void setDeskNumber(String deskNumber) {
		this.deskNumber = deskNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "OfficeAddress [buildingNumber=" + buildingNumber + ", deskNumber=" + deskNumber + ", street=" + street
				+ ", city=" + city + ", county=" + county + ", state=" + state + ", postCode=" + postCode + ", country="
				+ country + "]";
	}
}
