package com.rent.car.controller;

import com.rent.car.bean.Booking;
import com.rent.car.model.BookingModel;

public class BookingController implements BookingControllerInterface	{
	
	public static BookingModel bookingModel;
	
	static	{
		BookingController.bookingModel = new BookingModel();
	}
	
	@Override
	public boolean isCarNumberPresent(String id) {
		return BookingController.bookingModel.isCarNumberPresent(id);
	}
	
	@Override
	public String getCarId(String id) {
		return BookingController.bookingModel.getCarId(id);
	}

	@Override
	public String getUserId(String id) {
		return BookingController.bookingModel.getUserId(id);
	}

	@Override
	public String getStatus(String id) {
		return BookingController.bookingModel.getStatus(id);
	}

	@Override
	public boolean updateCarId(String id, String carId) {
		return BookingController.bookingModel.updateCarId(id, carId);
	}

	@Override
	public boolean updateUserId(String id, String userId) {
		return BookingController.bookingModel.updateUserId(id, userId);
	}

	@Override
	public boolean updateStatus(String id, String status) {
		return BookingController.bookingModel.updateStatus(id, status);
	}

	@Override
	public boolean setBooking(Booking booking) {
		return BookingController.bookingModel.setBooking(booking);
	}

	@Override
	public String get(String id, String whatToGet) {
		return BookingController.bookingModel.get(id, whatToGet);
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value) {
		return BookingController.bookingModel.update(id, whatToUpdate, value);
	}

	public boolean deleteBooking(String id)	{
		return BookingController.bookingModel.deleteBooking(id);
	}
}
