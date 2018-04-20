package com.hibernate.main;

/**
 * @author MasterWill
 * @date   21 Mar 2017
 * @time   00:49:13
 * @year   2017
 * @class  Asset.java
 * @project ProjectChronos
 * @package com.williamkzhou.chronos.web.model
 * @description
 * @version
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@NamedQuery(name = "TechAsset.assetId", query = "FROM TechAsset WHERE assetId = ?")
@NamedNativeQuery(name = "TechAsset.assetCategory", query = "SELECT * FROM ASSETS WHERE ASSET_CATEGORY = ?", resultClass = TechAsset.class)
@Table(name = "ASSETS")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class TechAsset implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7901561364253785543L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ASSET_ID")
	private int assetId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "ASSET_BAR_CODE")
	private String assetBarCode;

	@Column(name = "ASSET_MODEL")
	private String assetModel;

	@Column(name = "ASSET_CONDITION")
	private String assetCondition;

	@Column(name = "ASSET_MANUFACTURER")
	private String assetManufacturer;

	@Column(name = "SERIAL_NUMBER")
	private String serialNumber;

	@Column(name = "ASSET_CATEGORY")
	private String assetCategory;

	@Column(name = "COST_CENTER_PRICE", nullable = false)
	private double costCenterPrice;

	@Column(name = "ASSET_STATUS")
	private String assetStatus;
	
	@Column(name = "ASSIGNED_OFFICE")
	private String assignedOffice;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "WARRANTY_VALID")
	private Date warrantyExpirationDate;

	@Column(name = "UNITS_AVAILABLE")
	private int unitsAvailable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ADDED_ON")
	private Date addedOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PURCHASE_DATE")
	private Date purchaseDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MAINTENANCE_DATE")
	private Date maintenanceDate;


	public TechAsset() {
		super();
		new ArrayList<EmployeeOrder>();
	}


	public int getAssetId() {
		return assetId;
	}


	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getAssetBarCode() {
		return assetBarCode;
	}


	public void setAssetBarCode(String assetBarCode) {
		this.assetBarCode = assetBarCode;
	}


	public String getAssetModel() {
		return assetModel;
	}


	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}


	public String getAssetCondition() {
		return assetCondition;
	}


	public void setAssetCondition(String assetCondition) {
		this.assetCondition = assetCondition;
	}


	public String getAssetManufacturer() {
		return assetManufacturer;
	}


	public void setAssetManufacturer(String assetManufacturer) {
		this.assetManufacturer = assetManufacturer;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getAssetCategory() {
		return assetCategory;
	}


	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}


	public double getCostCenterPrice() {
		return costCenterPrice;
	}


	public void setCostCenterPrice(double costCenterPrice) {
		this.costCenterPrice = costCenterPrice;
	}


	public String getAssetStatus() {
		return assetStatus;
	}


	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}


	public String getAssignedOffice() {
		return assignedOffice;
	}


	public void setAssignedOffice(String assignedOffice) {
		this.assignedOffice = assignedOffice;
	}


	public Date getWarrantyExpirationDate() {
		return warrantyExpirationDate;
	}


	public void setWarrantyExpirationDate(Date warrantyExpirationDate) {
		this.warrantyExpirationDate = warrantyExpirationDate;
	}


	public int getUnitsAvailable() {
		return unitsAvailable;
	}


	public void setUnitsAvailable(int unitsAvailable) {
		this.unitsAvailable = unitsAvailable;
	}


	public Date getAddedOn() {
		return addedOn;
	}


	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Date getMaintenanceDate() {
		return maintenanceDate;
	}


	public void setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	
}
