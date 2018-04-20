package com.hibernate.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ASSETS")
public class Asset 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ASSET_ID")
	private int assetId;
	
	@Column(name="ASSET_NAME")
	private String name;
	
	@Column(name="ASSET_CONDITION")
	private String assetCondition;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;
	
	public Asset()
	{
		super();
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
