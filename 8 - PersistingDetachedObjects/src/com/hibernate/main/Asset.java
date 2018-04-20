package com.hibernate.main;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "ASSETS")
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ASSET_ID")
	private int assetId;

	@Column(name = "ASSET_NAME")
	private String name;

	@Column(name = "ASSET_CONDITION")
	private String assetCondition;

	@ManyToMany(mappedBy="assets")
	// Ignore exceptions if an employee does not have an  asset or vice-versa
	@NotFound(action=NotFoundAction.IGNORE)
	private Collection<Employee> employeeList = new ArrayList<Employee>();

	public Asset() {
		super();
	}

	public Collection<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Collection<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssetCondition() {
		return assetCondition;
	}

	public void setAssetCondition(String assetCondition) {
		this.assetCondition = assetCondition;
	}
}
