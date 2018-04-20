package com.hibernate.main;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "USER_ACCOUNT")

/*
 * If you are using openSession() then you have to use both DynamicUpdate and
 * SelectBeforeUpdate to make it effective.
 * 
 * As openSession every time opens new session, any object you want to update,
 * that object doesn't lies in that session so you have to use
 * SelectBeforeUpdate to retrieve that object in session. Then and then
 * hibernate can determine how many fields are actually changed. So hibernate
 * will update only changed field as we have set DynamicUpdate=true.
 */

@DynamicUpdate(true)
@SelectBeforeUpdate(true)

public class UserAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private boolean enabled = false;

	@Column(name = "AUTHORITY")
	private String authority;

	@Column(name = "DATE_CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	public UserAccount() {
		super();
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
