package com.hibernate.main;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 * @author MasterWill
 * @date @{date}
 * @filename OrderInformation.java
 * @project ProjectChronos
 * @description
 * @version
 */

@Entity
@Table(name = "ORDER_INFORMATION")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class OrderInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ORDER_INFORMATION_ID")
	private int orderInformationId;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ORDER_ID")
	private EmployeeOrder employeeOrder;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "ORDER_AMOUNT")
	private double orderAmount;
	
	@Column(name="COST_CENTER_PRICE")
	private double price;

	@OneToOne
	@JoinColumn(name = "TECH_ASSET_ID")
	private TechAsset techAsset;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_REQUIRED")
	private Date dateRequired;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ASSET_RETURN_DATE")
	private Date assetReturnDate;

	public OrderInformation()
	{
		super();
	}

	public OrderInformation(int orderInformationId, EmployeeOrder employeeOrder, int quantity, double orderAmount, double price, Date dateRequired, Date assetReturnDate)
	{
		super();
		this.orderInformationId = orderInformationId;
		this.employeeOrder = employeeOrder;
		this.quantity = quantity;
		this.orderAmount = orderAmount;
		this.price = price;
		this.assetReturnDate = 	assetReturnDate;
		this.dateRequired = dateRequired;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrderInformationId() {
		return orderInformationId;
	}

	public void setOrderInformationId(int orderInformationId) {
		this.orderInformationId = orderInformationId;
	}

	public EmployeeOrder getEmployeeOrder() {
		return employeeOrder;
	}

	public void setEmployeeOrder(EmployeeOrder employeeOrder) {
		this.employeeOrder = employeeOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public TechAsset getTechAsset() {
		return techAsset;
	}

	public void setTechAsset(TechAsset techAsset) {
		this.techAsset = techAsset;
	}

	public Date getDateRequired() {
		return dateRequired;
	}

	public void setDateRequired(Date dateRequired) {
		this.dateRequired = dateRequired;
	}

	public Date getAssetReturnDate() {
		return assetReturnDate;
	}

	public void setAssetReturnDate(Date assetReturnDate) {
		this.assetReturnDate = assetReturnDate;
	}
}
