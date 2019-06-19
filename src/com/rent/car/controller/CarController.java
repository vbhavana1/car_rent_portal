package com.rent.car.controller;

import java.sql.Connection;

import com.rent.car.bean.Car;
import com.rent.car.model.CarModel;

public class CarController implements CarControllerInterface	{
	
	public CarModel carModel;
	
	public CarController(Connection dbConnection)	{
		this.carModel = new CarModel(dbConnection); 
	}
	
	@Override
	public boolean isCarIdPresent(String id) {
		return this.carModel.isCarIdPresent(id);
	}

	@Override
	public String getCarType(String id) {
		return this.carModel.getCarType(id);
	}

	@Override
	public String getMileage(String id) {
		return this.carModel.getMileage(id);
	}

	@Override
	public String getSeaters(String id) {
		return this.carModel.getSeaters(id);
	}

	@Override
	public String getDescription(String id) {
		return this.carModel.getDescription(id);
	}

	@Override
	public String getCost(String id) {
		return this.carModel.getCost(id);
	}

	@Override
	public String getCarName(String id) {
		return this.carModel.getCarName(id);
	}

	@Override
	public String getImgPath(String id) {
		return this.carModel.getImgPath(id);
	}

	@Override
	public boolean setCar(Car car) {
		return this.carModel.setCar(car);
	}

	@Override
	public boolean updateCarType(String id, String carType) {
		return this.carModel.updateCarType(id, carType);
	}

	@Override
	public boolean updateMileage(String id, String mileage) {
		return this.carModel.updateMileage(id, mileage);
	}

	@Override
	public boolean updateSeaters(String id, String seaters) {
		return this.carModel.updateSeaters(id, seaters);
	}

	@Override
	public boolean updateDescription(String id, String description) {
		return this.carModel.updateDescription(id, description);
	}

	@Override
	public boolean updateCost(String id, String cost) {
		return this.carModel.updateCost(id, cost);
	}

	@Override
	public boolean updateCarName(String id, String carName) {
		return this.carModel.updateCarName(id, carName);
	}

	@Override
	public boolean updateImgPath(String id, String imgPath) {
		return this.carModel.updateImgPath(id, imgPath);
	}

	@Override
	public String get(String id, String whatToGet) {
		return this.carModel.get(id, whatToGet);
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value) {
		return this.carModel.update(id, whatToUpdate, value);
	}

	public Car getCar(String id)	{
		return this.carModel.getCar(id);
	}
	
	public boolean deleteCar(String id)	{
		return this.carModel.deleteCar(id);
	}
	
	public String[] getCarIds(String carType)	{	// Leave this null for all cars
		return this.carModel.getCarIds(carType);	
	}
}
