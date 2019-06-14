package com.rent.car.bean;

public class UserLog {
	String userId, startTime, endTime, deliveredTime, currentLocation, dropLocation, message, totalAmount, paidAmount, secretKey;
	
	public UserLog()	{
		this.userId = this.startTime = this.endTime = this.deliveredTime = this.currentLocation = this.dropLocation = this.message = this.totalAmount = this.paidAmount = this.secretKey = "";
	}

	public UserLog(String userId, String startTime, String endTime, String deliveredTime, String currentLocation,
			String dropLocation, String message, String totalAmount, String paidAmount, String secretKey) {
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.deliveredTime = deliveredTime;
		this.currentLocation = currentLocation;
		this.dropLocation = dropLocation;
		this.message = message;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.secretKey = secretKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDeliveredTime() {
		return deliveredTime;
	}

	public void setDeliveredTime(String deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
