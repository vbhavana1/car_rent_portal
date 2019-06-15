package com.rent.car.model;

import com.rent.car.bean.UserLog;

public interface UserLogModelInterface {
	// Method to check if user is present
	public abstract boolean isUserIdPresent(String id);
	
	// Method to set booking details
	public abstract boolean setBookingDetail(UserLog userLog);
	
	// Method to get booking details
	public abstract String getStartTime(String id);
	public abstract String getEndTime(String id);
	public abstract String getDeliveredTime(String id);
	public abstract String getCurrentLocation(String id);
	public abstract String getDropLocation(String id);
	public abstract String getMessage(String id);
	public abstract String getTotalAmount(String id);
	public abstract String getPaidAmount(String id);
	public abstract String getSecretKey(String id);
	
	// Method to update booking details
	public abstract boolean updateStartTime(String id, String startTime);
	public abstract boolean updateEndTime(String id, String endTime);
	public abstract boolean updateDeliveredTime(String id, String deliveredTime);
	public abstract boolean updateCurrentLocation(String id, String currentLocation);
	public abstract boolean updateDropLocation(String id, String dropLocation);
	public abstract boolean updateMessage(String id, String message);
	public abstract boolean updateTotalAmount(String id, String totalAmount);
	public abstract boolean updatePaidAmount(String id, String paidAmount);
	public abstract boolean updateSecretKey(String id, String updateToThisKey);
	
	// General method to get and update properties
	public abstract String get(String id, String whatToGet);
	public abstract boolean update(String id, String whatToUpdate, String value);
}
