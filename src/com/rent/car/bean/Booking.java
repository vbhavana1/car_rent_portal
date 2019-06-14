package com.rent.car.bean;

public class Booking {
	private String carNumber, carId, userId, bookingStatus;
	
	public Booking()	{
		this.carNumber = this.carId = this.userId = this.bookingStatus = "";
	}

	public Booking(String carNumber, String carId, String userId, String bookingStatus) {
		this.carNumber = carNumber;
		this.carId = carId;
		this.userId = userId;
		this.bookingStatus = bookingStatus;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
}
