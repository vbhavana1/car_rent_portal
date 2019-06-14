package com.rent.car.controller;

import com.rent.car.bean.Booking;

public interface BookingControllerInterface {
	// Method to check if id is present
	public abstract boolean isCarNumberPresent(String id);
	
	// Method to get details
	public abstract String getCarId(String id);
	public abstract String getUserId(String id);
	public abstract String getStatus(String id);
	
	// Method to update details
	//public abstract boolean updateCarNumber(String id);
	public abstract boolean updateCarId(String id, String carId);
	public abstract boolean updateUserId(String id, String userId);
	public abstract boolean updateStatus(String id, String status);
	
	// Method to set details
	public abstract boolean setBooking(Booking booking);
	
	// General methods
	public abstract String get(String id, String whatToGet);
	public abstract boolean update(String id, String whatToUpdate, String value);
}
