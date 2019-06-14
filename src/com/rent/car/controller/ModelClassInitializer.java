package com.rent.car.controller;

import com.rent.car.model.BookingModel;
import com.rent.car.model.CarModel;
import com.rent.car.model.UserLogModel;
import com.rent.car.model.UserModel;

// This class is responsible for initializing all the classes inside model package
public class ModelClassInitializer {
	
	private static BookingModel bookingModel;
	private static CarModel carModel;
	private static UserLogModel userLogModel;
	private static UserModel userModel;
	//private Debug debug;
	
	static	{
		ModelClassInitializer.bookingModel = new BookingModel();
		ModelClassInitializer.carModel = new CarModel();
		ModelClassInitializer.userLogModel = new UserLogModel();
		ModelClassInitializer.userModel = new UserModel();
	}
	
	public static BookingModel useBookingModel()	{
		return ModelClassInitializer.bookingModel;
	}
	
	public static CarModel useCarModel()	{
		return ModelClassInitializer.carModel;
	}
	
	public static UserLogModel useUserLogModel()	{
		return ModelClassInitializer.userLogModel;
	}
	
	public static UserModel useUserModel()	{
		return ModelClassInitializer.userModel;
	}
}
