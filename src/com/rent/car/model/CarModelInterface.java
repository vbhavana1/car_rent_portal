package com.rent.car.model;

import com.rent.car.bean.Car;

public interface CarModelInterface {
	// Method to check if car is available
	public abstract boolean isCarIdPresent(String id);
	
	// Methods to get details of car
	public abstract String getCarType(String id);
	public abstract String getMileage(String id);
	public abstract String getSeaters(String id);
	public abstract String getDescription(String id);
	public abstract String getCost(String id);
	public abstract String getCarName(String id);
	public abstract String getImgPath(String id);
	
	// Method to set car in db
	public abstract boolean setCar(Car car);
	
	// Method to update details of car
	public abstract boolean updateCarType(String id, String carType);
	public abstract boolean updateMileage(String id, String mileage);
	public abstract boolean updateSeaters(String id, String seaters);
	public abstract boolean updateDescription(String id, String description);
	public abstract boolean updateCost(String id, String cost);
	public abstract boolean updateCarName(String id, String carName);
	public abstract boolean updateImgPath(String id, String imgPath);
	
	// General method to get and update properties
	public abstract String get(String id, String whatToGet);
	public abstract boolean update(String id, String whatToUpdate, String value);
}
