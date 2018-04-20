package com.hibernate.main;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "TRAINING")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Training implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2361086479250814470L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRAINING_ID")
	private int assetTrainingId;

	@Column(name = "TRAINING_DATE")
	private Date dateOfTraining;

	@Column(name = "DATE_OF_BOOKING")
	private Date bookingDate;

	@Column(name = "ROOM_NUMBER")
	private String roomNumber;

	@Column(name = "TRAINING_COURSE")
	private String trainingCourse;

	@Column(name = "TRAINING_OFFICE")
	private String trainingOffice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_USER_ID")
	private UserAccount userAccount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSET_ID")
	private TechAsset asset;

	public Training() {
		super();
	}
	

	public Date getBookingDate() {
		return bookingDate;
	}



	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}



	public String getTrainingCourse() {
		return trainingCourse;
	}

	public void setTrainingCourse(String trainingCourse) {
		this.trainingCourse = trainingCourse;
	}

	public int getAssetTrainingId() {
		return assetTrainingId;
	}

	public void setAssetTrainingId(int assetTrainingId) {
		this.assetTrainingId = assetTrainingId;
	}

	public Date getDateOfTraining() {
		return dateOfTraining;
	}

	public void setDateOfTraining(Date dateOfTraining) {
		this.dateOfTraining = dateOfTraining;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public TechAsset getAsset() {
		return asset;
	}

	public void setAsset(TechAsset asset) {
		this.asset = asset;
	}

	public String getTrainingOffice() {
		return trainingOffice;
	}

	public void setTrainingOffice(String trainingOffice) {
		this.trainingOffice = trainingOffice;
	}

	@Override
	public String toString() {
		return "Training [assetTrainingId=" + assetTrainingId + ", dateOfTraining=" + dateOfTraining + ", roomNumber="
				+ roomNumber + ", trainingOffice=" + trainingOffice + ", trainingCourse=" + trainingCourse
				+ ", userAccount=" + userAccount + ", asset=" + asset + "]";
	}

}
