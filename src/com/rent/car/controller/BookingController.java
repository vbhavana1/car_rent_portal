package com.rent.car.controller;

import java.sql.Connection;

import com.rent.car.bean.Booking;
import com.rent.car.model.BookingModel;

public class BookingController implements BookingControllerInterface	{
	
	private BookingModel bookingModel;
	
	public BookingController(Connection dbConnection)	{
		this.bookingModel = new BookingModel(dbConnection);
	}
	
	@Override
	public boolean isCarNumberPresent(String id) {
		return this.bookingModel.isCarNumberPresent(id);
	}
	
	@Override
	public String getCarId(String id) {
		return this.bookingModel.getCarId(id);
	}

	@Override
	public String getUserId(String id) {
		return this.bookingModel.getUserId(id);
	}

	@Override
	public String getStatus(String id) {
		return this.bookingModel.getStatus(id);
	}

	@Override
	public boolean updateCarId(String id, String carId) {
		return this.bookingModel.updateCarId(id, carId);
	}

	@Override
	public boolean updateUserId(String id, String userId) {
		return this.bookingModel.updateUserId(id, userId);
	}

	@Override
	public boolean updateStatus(String id, String status) {
		return this.bookingModel.updateStatus(id, status);
	}

	@Override
	public boolean setBooking(Booking booking) {
		return this.bookingModel.setBooking(booking);
	}

	@Override
	public String get(String id, String whatToGet) {
		return this.bookingModel.get(id, whatToGet);
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value) {
		return this.bookingModel.update(id, whatToUpdate, value);
	}

	public boolean deleteBooking(String id)	{
		return this.bookingModel.deleteBooking(id);
	}
}
