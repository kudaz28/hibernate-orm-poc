package com.hibernate.main;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "DEPARTMENT")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class EmployeeDepartment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTMENT_ID")
	private int departmentId;

	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	@Column(name = "COST_CENTER_CODE")
	private String costCenterCode;

	@Column(name = "DEPARTMENT_MANAGER")
	private String departmentManager;

	@Column(name = "DEPARTMENT_DIRECTOR")
	private String departmentDirector;

	@OneToMany(mappedBy="department")
	private Collection<Employee> employee = new ArrayList<Employee>();

	public EmployeeDepartment() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCostCenterCode() {
		return costCenterCode;
	}

	public void setCostCenterCode(String costCenterCode) {
		this.costCenterCode = costCenterCode;
	}

	public String getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(String departmentManager) {
		this.departmentManager = departmentManager;
	}

	public String getDepartmentDirector() {
		return departmentDirector;
	}

	public void setDepartmentDirector(String departmentDirector) {
		this.departmentDirector = departmentDirector;
	}

	public Collection<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Collection<Employee> employees) {
		this.employee = employees;
	}

}
