package com.hibernate.main;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "OFFICE_ADDRESS")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class OfficeAddress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9019975360263062821L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OFFICE_ID")
	private int officeId;

	@Column(name = "BUILDING_NUMBER")
	private String buildingNumber;

	@Column(name = "DESK_NUMBER")
	private String deskNumber;

	@Column(name = "STREET_NAME")
	private String streetName;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTY")
	private String county;

	@Column(name = "POST_CODE")
	private String postCode;

	@Column(name = "COUNTRY")
	private String country;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_ID")
	private EmployeeAccount employee;

	public OfficeAddress() {
		super();
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getDeskNumber() {
		return deskNumber;
	}

	public void setDeskNumber(String deskNumber) {
		this.deskNumber = deskNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
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

	public EmployeeAccount getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeAccount employee) {
		this.employee = employee;
	}
}
