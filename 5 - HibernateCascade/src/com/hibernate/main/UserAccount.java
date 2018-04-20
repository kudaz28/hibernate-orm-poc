package com.hibernate.main;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


@Entity
@Table(name = "USER_ACCOUNT")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)

public class UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5681950436382675963L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private boolean enabled = false;

	@Column(name = "AUTHORITY")
	private String authority;

	@Column(name = "DATE_CREATED")
	private Timestamp dateCreated;

	@OneToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private EmployeeAccount employee;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccount", fetch = FetchType.LAZY)
	private Collection<EmployeeOrder> employeeOrder = new ArrayList<EmployeeOrder>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccount", fetch = FetchType.LAZY)
	private Collection<Training> assetTraining = new ArrayList<Training>();

	public UserAccount() {
		super();
	}

	public Collection<EmployeeOrder> getEmployeeOrder() {
		return employeeOrder;
	}

	public void setEmployeeOrder(Collection<EmployeeOrder> employeeOrder) {
		this.employeeOrder = employeeOrder;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public EmployeeAccount getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeAccount employee) {
		this.employee = employee;
	}

	public Collection<Training> getAssetTraining() {
		return assetTraining;
	}

	public void setAssetTraining(Collection<Training> assetTraining) {
		this.assetTraining = assetTraining;
	}

	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", userName=" + userName + ", password=" + password + ", enabled="
				+ enabled + ", authority=" + authority + ", dateCreated=" + dateCreated + ", employee=" + employee
				+ "]";
	}

}
