package com.rent.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rent.car.bean.Booking;
//import com.rent.car.controller.ContextListener;
import com.rent.car.helper.Debug;
//import com.rent.car.helper.RentCarException;

public class BookingModel implements BookingModelInterface {
	private Connection dbConnection;
	private static PreparedStatement stmt;
	private static Debug debug;
	
	public BookingModel(Connection dbConnection)	{
		this.dbConnection = dbConnection;
	}
	
	static	{
		// Setting the debug mode
		BookingModel.debug = new Debug();
		BookingModel.debug.setPrintLog(true);
		
//		try	{
//			this.dbConnection = ContextListener.useContextConnection();
//		}
//		catch(RentCarException rce)	{
//			BookingModel.debug.printMessage("BookingModel.static_block", "connection is not established");
//			System.out.println(rce);
//		}
	}

	@Override
	public boolean isCarNumberPresent(String id) {
		String query = "select car_no from car_status where car_no=?";
		
		try	{
			BookingModel.stmt = this.dbConnection.prepareStatement(query);
			BookingModel.stmt.setString(1, id);
			
			ResultSet rs = BookingModel.stmt.executeQuery();
			
			while(rs.next())	{
				if(rs.getString(1).equals(id))	{
					debug.printMessage("isCarNumberPresent", "id:" + id + " is present");
					return true;
				}
			}
			
			debug.printMessage("isCarNumberPresent", "id:" + id + " is not present");
			return false;
		}
		catch(SQLException e)	{
			debug.printMessage("isCarNumberPresent", "cannot fetch id");
			return false;
		}
	}

	@Override
	public boolean setBooking(Booking booking) {
		String query = "insert into car_status values (?,?,?,?)";
		
		try	{
			BookingModel.stmt = this.dbConnection.prepareStatement(query);
			BookingModel.stmt.setString(1, booking.getCarNumber());
			BookingModel.stmt.setString(2, booking.getCarId());
			BookingModel.stmt.setString(3, booking.getUserId());
			BookingModel.stmt.setString(4, booking.getBookingStatus());
			
			if(BookingModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("setBooking", booking.getCarNumber() + " is inserted in car_status");
				return true;
			}
			else	{
				debug.printMessage("setBooking", booking.getCarNumber() + " is not inserted in car_status");
				return false;
			}
		}
		catch(SQLException e)	{
			debug.printMessage("setBooking", "cannot set the data");
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String get(String id, String whatToGet) {
		String query = String.format("select %s from car_status where car_no=?", whatToGet);
		
		try {
			BookingModel.stmt = this.dbConnection.prepareStatement(query);
			BookingModel.stmt.setString(1, id);
			
			ResultSet rs = BookingModel.stmt.executeQuery(query);
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
	public boolean update(String id, String whatToUpdate, String value) {
		String query = String.format("update car_status set %s=? where car_no=?", whatToUpdate);
		
		try	{
			BookingModel.stmt = this.dbConnection.prepareStatement(query);
			BookingModel.stmt.setString(1, value);
			BookingModel.stmt.setString(2, id);
			
			if(BookingModel.stmt.executeUpdate() != 0)	{
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
	public String getCarId(String id) {
		return this.get(id, "car_id");
	}

	@Override
	public String getUserId(String id) {
		return this.get(id, "user_id");
	}

	@Override
	public String getStatus(String id) {
		return this.get(id, "status");
	}

	@Override
	public boolean updateCarId(String id, String carId) {
		return this.update(id, "car_id", carId);
	}

	@Override
	public boolean updateUserId(String id, String userId) {
		return this.update(id, "user_id", userId); 
	}

	@Override
	public boolean updateStatus(String id, String status) {
		return this.update(id, "status", status);
	}
	
	public boolean deleteBooking(String id)	{
		String query = "delete from car_status where car_no=? limit 1";
		
		try	{
			BookingModel.stmt = this.dbConnection.prepareStatement(query);
			BookingModel.stmt.setString(1, id);
			
			if(BookingModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("deleteBooking", "car_no: " + id + " is deleted from car_status");
				return true;
			}
			else	{
				debug.printMessage("deleteBooking", "car_no: " + id + " is not deleted from car_status");
				return false;
			}
		}
		catch(SQLException e)	{
			debug.printMessage("deleteBooking", "car_no: " + id + "cannot be deleted because foreign key might be using it");
			return false;
		}
	}
}
