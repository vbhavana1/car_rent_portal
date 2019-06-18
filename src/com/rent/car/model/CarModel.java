package com.rent.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rent.car.bean.Car;
//import com.rent.car.controller.ContextListener;
import com.rent.car.helper.Debug;
//import com.rent.car.helper.RentCarException;

public class CarModel implements CarModelInterface	{
	private Connection dbConnection;
	private static PreparedStatement stmt;
	private static Debug debug;
	
	public CarModel(Connection dbConnection)	{
		this.dbConnection = dbConnection;
	}
	
	static	{
		// Setting the debug mode
		CarModel.debug = new Debug();
		CarModel.debug.setPrintLog(true);
		
//		try	{
//			this.dbConnection = ContextListener.useContextConnection();
//		}
//		catch(RentCarException rce)	{
//			CarModel.debug.printMessage("CarModel.static_block", "connection is not established");
//			System.out.println(rce);
//		}
	}

	@Override
	public String get(String id, String whatToGet) {
		String query = String.format("select %s from car_table where car_id=?", whatToGet);
		
		try {
			CarModel.stmt = this.dbConnection.prepareStatement(query);
			CarModel.stmt.setString(1, id);
			
			ResultSet rs = CarModel.stmt.executeQuery();
			String returnIt = "";
			
			while(rs.next())	{
				returnIt = rs.getString(1);
			}
			debug.printMessage("get", "id: " + id + " " + whatToGet + ": " + returnIt);
			return returnIt;
		}
		catch (SQLException e) {
			debug.printMessage("get", "cannot get the data");
			e.printStackTrace();
			return "";
		}	
	}
	
	@Override
	public boolean setCar(Car car) {
		String query = "insert into car_table values (?,?,?,?,?,?,?,?)";
		
		try	{
			CarModel.stmt = this.dbConnection.prepareStatement(query);
			CarModel.stmt.setString(1, car.getId());
			CarModel.stmt.setString(2, car.getType());
			CarModel.stmt.setString(3, car.getMileage());
			CarModel.stmt.setString(4, car.getSeats());
			CarModel.stmt.setString(5, car.getDescription());
			CarModel.stmt.setString(6, car.getCost());
			CarModel.stmt.setString(7, car.getName());
			CarModel.stmt.setString(8, car.getImgPath());
			
			if(CarModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("setCar", car.getName() + " is inserted in car_table");
				return true;
			}
			else	{
				debug.printMessage("setCar", car.getName() + " is not inserted in car_table");
				return false;
			}
		}
		catch(SQLException e)	{
			debug.printMessage("setCar", "cannot set the data");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value) {
		String query = String.format("update car_table set %s=? where car_id=?", whatToUpdate);
		
		try	{
			CarModel.stmt = this.dbConnection.prepareStatement(query);
			CarModel.stmt.setString(1, value);
			CarModel.stmt.setString(2, id);
			
			if(CarModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("update", "value " + whatToUpdate + ": " + value + " is updated in user_table");
				return true;
			}
			else	{
				debug.printMessage("update", "value " + whatToUpdate + ": " + value + " is not updated in user_table");
				return false;
			}
		}
		catch(SQLException e) {
			debug.printMessage("update", "cannot update the data");
			return false;
		}
	}

	@Override
	public boolean isCarIdPresent(String id) {
		String query = "select car_id from car_table where car_id=?";
		
		try	{
			CarModel.stmt = this.dbConnection.prepareStatement(query);
			CarModel.stmt.setString(1, id);
			
			ResultSet rs = CarModel.stmt.executeQuery();
			
			while(rs.next())	{
				if(rs.getString(1).equals(id))	{
					debug.printMessage("isCarIdPresent", "id:" + id + " is present");
					return true;
				}
			}
			
			debug.printMessage("isCarIdPresent", "id:" + id + " is not present");
			return false;
		}
		catch(SQLException e)	{
			debug.printMessage("isCarIdPresent", "cannot fetch id");
			return false;
		}
	}

	@Override
	public String getCarType(String id) {
		return this.get(id, "car_type");
	}

	@Override
	public String getMileage(String id) {
		return this.get(id, "mileage");
	}

	@Override
	public String getSeaters(String id) {
		return this.get(id, "seaters");
	}

	@Override
	public String getDescription(String id) {
		return this.get(id, "description");
	}

	@Override
	public String getCost(String id) {
		return this.get(id, "cost");
	}

	@Override
	public String getCarName(String id) {
		return this.get(id, "car_name");
	}

	@Override
	public String getImgPath(String id) {
		return this.get(id, "img_path");
	}

	@Override
	public boolean updateCarType(String id, String carType) {
		return this.update(id, "car_type", carType);
	}

	@Override
	public boolean updateMileage(String id, String mileage) {
		return this.update(id, "mileage", mileage);
	}

	@Override
	public boolean updateSeaters(String id, String seaters) {
		return this.update(id, "seaters", seaters);
	}

	@Override
	public boolean updateDescription(String id, String description) {
		return this.update(id, "description", description);
	}

	@Override
	public boolean updateCost(String id, String cost) {
		return this.update(id, "cost", cost);
	}

	@Override
	public boolean updateCarName(String id, String carName) {
		return this.update(id, "car_name", carName);
	}

	@Override
	public boolean updateImgPath(String id, String imgPath) {
		return this.update(id, "img_path", imgPath);
	}
	
	public Car getCar(String id)	{
		if(this.isCarIdPresent(id))	{
			return new Car(id, this.getCarName(id), this.getCarType(id), this.getMileage(id), this.getSeaters(id), this.getCost(id), this.getDescription(id),
					this.getImgPath(id));
		}
		else	return new Car();
	}
	
	public String[] getCarIds(String carType)	{
		String query;
		if(carType.equals("mini"))	{
			query = "select car_id from car_table where car_type=mini";
		}
		else if(carType.equals("micro"))	{
			query = "select car_id from car_table where car_type=micro";
		}
		else if(carType.equals("deluxe"))	{
			query = "select car_id from car_table where car_type=deluxe";
		}
		else if(carType.equals("suv"))	{
			query = "select car_id from car_table where car_type=suv";
		}
		else	{
			query = "select car_id from car_table";
		}
		
		try	{
			CarModel.stmt = this.dbConnection.prepareStatement(query);
			
			ResultSet rs = CarModel.stmt.executeQuery();
			
			String ids = "";
			
			while(rs.next())	{
				ids += rs.getString(1) + ",";
			}
			
			debug.printMessage("getCarIds", "car_ids:" + ids);
			return ids.substring(0, ids.length()-1).split(",");
		}
		catch(SQLException e)	{
			debug.printMessage("getCarIds", "cannot fetch id");
			
			String arr[] = new String[1];
			arr[0] = "";
			return arr;
		}
	}
	
	public boolean deleteCar(String id)	{
		String query = "delete from car_table where car_id=? limit 1";
		
		try	{
			CarModel.stmt = this.dbConnection.prepareStatement(query);
			CarModel.stmt.setString(1, id);
			
			if(CarModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("deleteCar", "id: " + id + " is deleted from car_table");
				return true;
			}
			else	{
				debug.printMessage("deleteCar", "id: " + id + " is not deleted from car_table");
				return false;
			}
		}
		catch(SQLException e)	{
			debug.printMessage("deleteCar", "id: " + id + "cannot be deleted because foreign key might be using it");
			return false;
		}
	}
}
