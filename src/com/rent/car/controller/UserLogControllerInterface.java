package com.rent.car.controller;

import com.rent.car.bean.UserLog;

public interface UserLogControllerInterface {
	// Method to check if user is present
	public abstract boolean isUserIdPresent(String id);
	
	// Method to set booking details
	public abstract boolean setBookingDetail(UserLog userLog);
	
	// Method to get booking details
	public abstract String getStartTime(String id, String secretKey);
	public abstract String getEndTime(String id, String secretKey);
	public abstract String getDeliveredTime(String id, String secretKey);
	public abstract String getCurrentLocation(String id, String secretKey);
	public abstract String getDropLocation(String id, String secretKey);
	public abstract String getMessage(String id, String secretKey);
	public abstract String getTotalAmount(String id, String secretKey);
	public abstract String getPaidAmount(String id, String secretKey);
	public abstract String getSecretKey(String id, String secretKey);
	
	// Method to update booking details
	public abstract boolean updateStartTime(String id, String startTime, String secretKey);
	public abstract boolean updateEndTime(String id, String endTime, String secretKey);
	public abstract boolean updateDeliveredTime(String id, String deliveredTime, String secretKey);
	public abstract boolean updateCurrentLocation(String id, String currentLocation, String secretKey);
	public abstract boolean updateDropLocation(String id, String dropLocation, String secretKey);
	public abstract boolean updateMessage(String id, String message, String secretKey);
	public abstract boolean updateTotalAmount(String id, String totalAmount, String secretKey);
	public abstract boolean updatePaidAmount(String id, String paidAmount, String secretKey);
	public abstract boolean updateSecretKey(String id, String secretKey, String updateToThisKey);
	
	// General method to get and update properties
	public abstract String get(String id, String whatToGet, String secretKey);
	public abstract boolean update(String id, String whatToUpdate, String value, String secretKey);
}
