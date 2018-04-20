package com.hibernate.main;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "EMPLOYEE")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5585797727331233255L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

	@Column(name = "GLOBAL_IDENTIFIER")
	private String globalIdentifier;

	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	@Column(name = "WORK_EMAIL")
	private String workEmail;

	@Column(name = "WORK_TELEPHONE")
	private String workTelephone;

	@Column(name = "EMPLOYMENT_STATUS")
	private String employmentStatus;

	@Column(name = "JOINED_DATE")
	private Date joinedDate;

	@Column(name = "EMPLOYEE_TYPE")
	private String employeeType;

	@Column(name = "JOB_TITLE")
	private String jobTitle;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPARTMENT_ID")
	private EmployeeDepartment department;

	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getGlobalIdentifier() {
		return globalIdentifier;
	}

	public void setGlobalIdentifier(String globalIdentifier) {
		this.globalIdentifier = globalIdentifier;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getWorkTelephone() {
		return workTelephone;
	}

	public void setWorkTelephone(String workTelephone) {
		this.workTelephone = workTelephone;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public EmployeeDepartment getDepartment() {
		return department;
	}

	public void setDepartment(EmployeeDepartment department) {
		this.department = department;
	}

}
