package com.hibernate.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public Asset()
	{
		super();
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
