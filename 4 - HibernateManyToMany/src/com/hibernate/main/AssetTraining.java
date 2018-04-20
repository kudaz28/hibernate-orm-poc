package com.hibernate.main;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ASSET_TRAINING")
public class AssetTraining implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2361086479250814470L;
	private int assetTrainingId;
	private String assetName;
	private Date dateOfTraining;
	private String roomNumber;

	public AssetTraining() {
		super();
	}

	public int getAssetTrainingId() {
		return assetTrainingId;
	}

	public void setAssetTrainingId(int assetTrainingId) {
		this.assetTrainingId = assetTrainingId;
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

	@Override
	public String toString() {
		return "AssetTraining [assetTrainingId=" + assetTrainingId + ", assetName=" + assetName + ", dateOfTraining="
				+ dateOfTraining + ", roomNumber=" + roomNumber + "]";
	}

}
