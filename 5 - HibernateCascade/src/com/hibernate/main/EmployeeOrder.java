package com.hibernate.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "EMPLOYEE_ORDER")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class EmployeeOrder implements Serializable {
	private static final long serialVersionUID = 2983360377227484514L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ORDER_ID")
	private int employeeOrderId;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ACCOUNT_ID")
	private UserAccount userAccount;

	@OneToOne
	@JoinColumn(name = "OFFICE_ADDRESS")
	private OfficeAddress officeAddress;

	@Column(name = "ORDER_NUMBER")
	private String orderNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "ORDER_STATUS")
	private OrderStatus orderStatus;

	@Column(name = "ORDER_AMOUNT")
	private double orderAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORDER_DATE")
	private Date orderDate;

	@OneToMany(mappedBy = "employeeOrder")
	private List<OrderInformation> orderInformation = new ArrayList<OrderInformation>();

	public EmployeeOrder() {
		super();
	}
	
	public EmployeeOrder(int employeeOrderId, UserAccount userAccount, OfficeAddress officeAddress, String orderNumber, OrderStatus orderStatus,
			double orderAmount, Date orderDate)
	{
		super();
	}

	public int getEmployeeOrderId() {
		return employeeOrderId;
	}

	public void setEmployeeOrderId(int employeeOrderId) {
		this.employeeOrderId = employeeOrderId;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public OfficeAddress getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(OfficeAddress officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderInformation> getOrderInformation() {
		return orderInformation;
	}

	public void setOrderInformation(List<OrderInformation> orderInformation) {
		this.orderInformation = orderInformation;
	}
}
