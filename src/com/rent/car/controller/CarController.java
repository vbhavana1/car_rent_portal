package com.rent.car.controller;

import com.rent.car.bean.Car;
import com.rent.car.model.CarModel;

public class CarController implements CarControllerInterface	{
	
	public static CarModel carModel;
	
	static	{
		CarController.carModel = new CarModel();
	}
	
	@Override
	public boolean isCarIdPresent(String id) {
		return CarController.carModel.isCarIdPresent(id);
	}

	@Override
	public String getCarType(String id) {
		return CarController.carModel.getCarType(id);
	}

	@Override
	public String getMileage(String id) {
		return CarController.carModel.getMileage(id);
	}

	@Override
	public String getSeaters(String id) {
		return CarController.carModel.getSeaters(id);
	}

	@Override
	public String getDescription(String id) {
		return CarController.carModel.getDescription(id);
	}

	@Override
	public String getCost(String id) {
		return CarController.carModel.getCost(id);
	}

	@Override
	public String getCarName(String id) {
		return CarController.carModel.getCarName(id);
	}

	@Override
	public String getImgPath(String id) {
		return CarController.carModel.getImgPath(id);
	}

	@Override
	public boolean setCar(Car car) {
		return CarController.carModel.setCar(car);
	}

	@Override
	public boolean updateCarType(String id, String carType) {
		return CarController.carModel.updateCarType(id, carType);
	}

	@Override
	public boolean updateMileage(String id, String mileage) {
		return CarController.carModel.updateMileage(id, mileage);
	}

	@Override
	public boolean updateSeaters(String id, String seaters) {
		return CarController.carModel.updateSeaters(id, seaters);
	}

	@Override
	public boolean updateDescription(String id, String description) {
		return CarController.carModel.updateDescription(id, description);
	}

	@Override
	public boolean updateCost(String id, String cost) {
		return CarController.carModel.updateCost(id, cost);
	}

	@Override
	public boolean updateCarName(String id, String carName) {
		return CarController.carModel.updateCarName(id, carName);
	}

	@Override
	public boolean updateImgPath(String id, String imgPath) {
		return CarController.carModel.updateImgPath(id, imgPath);
	}

	@Override
	public String get(String id, String whatToGet) {
		return CarController.carModel.get(id, whatToGet);
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value) {
		return CarController.carModel.update(id, whatToUpdate, value);
	}

	public Car getCar(String id)	{
		return CarController.carModel.getCar(id);
	}
	
	public boolean deleteCar(String id)	{
		return CarController.carModel.deleteCar(id);
	}
}
