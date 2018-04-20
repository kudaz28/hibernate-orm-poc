package com.hibernate.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "ASSET_TRAINING")
public class AssetTraining implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2361086479250814470L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRAINING_ID")
	private int trainingId;

	@Column(name = "ASSET_NAME")
	private String assetName;

	@Column(name = "DATE_OF_TRAINING")
	private Date dateOfTraining;

	@Column(name = "ROOM_NUMBER")
	private String roomNumber;

	@ManyToMany(mappedBy = "trainingList")
	// Ignore exceptions if an employee does not have an asset or vice-versa
	@NotFound(action = NotFoundAction.IGNORE)
	private Collection<Employee> employeeList = new ArrayList<Employee>();

	public AssetTraining() {
		super();
	}

	public Collection<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Collection<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
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
}
