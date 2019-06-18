package com.rent.car.bean;

public class Car {
	private String id, name, type, mileage, seats, cost, description, imgPath;
	
	public Car()	{
		this.id = this.name = this.type = this.mileage = this.seats = this.cost = this.description = this.imgPath = "";
	}

	public Car(String id, String name, String type, String mileage, String seats, String cost, String description,
			String imgPath) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.mileage = mileage;
		this.seats = seats;
		this.cost = cost;
		this.description = description;
		this.imgPath = imgPath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	@Override
	public String toString()	{
		return "{" + 
					"id: " + this.id + "," +
					"name: " + this.name + "," +
					"type: " + this.type + "," +
					"mileage: " + this.mileage + "," +
					"seats: " + this.seats + "," +
					"cost: " + this.cost + "," +
					"description: " + this.description + "," +
					"img_path: " + this.imgPath
				+
				"}";
	}
}
