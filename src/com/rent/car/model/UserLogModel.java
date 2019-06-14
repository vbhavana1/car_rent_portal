package com.rent.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rent.car.bean.UserLog;
//import com.rent.car.controller.ContextListener;
import com.rent.car.helper.Debug;
//import com.rent.car.helper.RentCarException;


public class UserLogModel implements UserLogModelInterface	{
	
	private Connection dbConnection;
	private static PreparedStatement stmt;
	private static Debug debug;
	
	public UserLogModel(Connection dbConnection)	{
		this.dbConnection = dbConnection;
	}
	
	static	{
		
		// Setting the debug mode
		UserLogModel.debug = new Debug();
		UserLogModel.debug.setPrintLog(true);
		
//		try	{
//			this.dbConnection = ContextListener.useContextConnection();
//		}
//		catch(RentCarException rce)	{
//			UserLogModel.debug.printMessage("BookingModel.static_block", "connection is not established");
//			System.out.println(rce);
//		}
	}

	@Override
	public boolean isUserIdPresent(String id) {
		String query = "select userLog_id from user_table where user_id=?";
		
		try	{
			UserLogModel.stmt = this.dbConnection.prepareStatement(query);
			UserLogModel.stmt.setString(1, id);
			
			ResultSet rs = UserLogModel.stmt.executeQuery();
			
			while(rs.next())	{
				if(rs.getString(1).equals(id))	{
					debug.printMessage("isUserIdPresent", "id:" + id + " is present");
					return true;
				}
			}
			
			debug.printMessage("isUserIdPresent", "id:" + id + " is not present");
			return false;
		}
		catch(SQLException e)	{
			debug.printMessage("isUserIdPresent", "cannot fetch id");
			return false;
		}
	}

	@Override
	public boolean setBookingDetail(UserLog userLog) {
		String query = "insert into users_log values (?,?,?,?,?,?,?,?,?,?)";
		
		try	{
			UserLogModel.stmt = this.dbConnection.prepareStatement(query);
			UserLogModel.stmt.setString(1, userLog.getUserId());
			UserLogModel.stmt.setString(2, userLog.getStartTime());
			UserLogModel.stmt.setString(3, userLog.getEndTime());
			UserLogModel.stmt.setString(4, userLog.getDeliveredTime());
			UserLogModel.stmt.setString(5, userLog.getCurrentLocation());
			UserLogModel.stmt.setString(6, userLog.getDropLocation());
			UserLogModel.stmt.setString(7, userLog.getMessage());
			UserLogModel.stmt.setString(8, userLog.getTotalAmount());
			UserLogModel.stmt.setString(9, userLog.getPaidAmount());
			UserLogModel.stmt.setString(10, userLog.getSecretKey());
			
			if(UserLogModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("setuserLog", userLog.getUserId() + " data is inserted in users_log");
				return true;
			}
			else	{
				debug.printMessage("setuserLog", userLog.getUserId() + " data is not inserted in users_log");
				return false;
			}
		}
		catch(SQLException e)	{
			debug.printMessage("setuserLog", "cannot set the data");
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String get(String id, String whatToGet, String secretKey) {
		String query = String.format("select %s from users_log where user_id=? and secret_key=?", whatToGet);
		
		try {
			UserLogModel.stmt = this.dbConnection.prepareStatement(query);
			UserLogModel.stmt.setString(1, id);
			UserLogModel.stmt.setString(2, secretKey);
			
			ResultSet rs = UserLogModel.stmt.executeQuery(query);
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
	public boolean update(String id, String whatToUpdate, String value, String secretKey) {
		String query = String.format("update users_log set %s=? where user_id=? and secret_key=?", whatToUpdate);
		
		try	{
			UserLogModel.stmt = this.dbConnection.prepareStatement(query);
			UserLogModel.stmt.setString(1, value);
			UserLogModel.stmt.setString(2, id);
			UserLogModel.stmt.setString(3, secretKey);
			
			if(UserLogModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("update", "value " + whatToUpdate + ": " + value + " is updated in users_log");
				return true;
			}
			else	{
				debug.printMessage("update", "value " + whatToUpdate + ": " + value + " is not updated in users_log");
				return false;
			}
		}
		catch(SQLException e) {
			debug.printMessage("update", "cannot update the data");
			return false;
		}
	}

	@Override
	public String getStartTime(String id, String secretKey) {
		return this.get(id, "start_time", secretKey);
	}

	@Override
	public String getEndTime(String id, String secretKey) {
		return this.get(id, "end_time", secretKey);
	}

	@Override
	public String getDeliveredTime(String id, String secretKey) {
		return this.get(id, "delivered_time", secretKey);
	}

	@Override
	public String getCurrentLocation(String id, String secretKey) {
		return this.get(id, "current_location", secretKey);
	}

	@Override
	public String getDropLocation(String id, String secretKey) {
		return this.get(id, "drop_location", secretKey);
	}

	@Override
	public String getMessage(String id, String secretKey) {
		return this.get(id, "msg", secretKey);
	}

	@Override
	public String getTotalAmount(String id, String secretKey) {
		return this.get(id, "total_amount", secretKey);
	}

	@Override
	public String getPaidAmount(String id, String secretKey) {
		return this.get(id, "paid_amount", secretKey);
	}

	@Override
	public String getSecretKey(String id, String secretKey) {
		return this.get(id, "secret_key", secretKey);
	}

	@Override
	public boolean updateStartTime(String id, String startTime, String secretKey) {
		return this.update(id, "start_time", startTime, secretKey);
	}

	@Override
	public boolean updateEndTime(String id, String endTime, String secretKey) {
		return this.update(id, "end_time", endTime, secretKey);
	}

	@Override
	public boolean updateDeliveredTime(String id, String deliveredTime, String secretKey) {
		return this.update(id, "delivered_time", deliveredTime, secretKey);
	}

	@Override
	public boolean updateCurrentLocation(String id, String currentLocation, String secretKey) {
		return this.update(id, "current_location", currentLocation, secretKey);
	}

	@Override
	public boolean updateDropLocation(String id, String dropLocation, String secretKey) {
		return this.update(id, "drop_location", dropLocation, secretKey);
	}

	@Override
	public boolean updateMessage(String id, String message, String secretKey) {
		return this.update(id, "msg", message, secretKey);
	}

	@Override
	public boolean updateTotalAmount(String id, String totalAmount, String secretKey) {
		return this.update(id, "total_amount", totalAmount, secretKey);
	}

	@Override
	public boolean updatePaidAmount(String id, String paidAmount, String secretKey) {
		return this.update(id, "paid_amount", paidAmount, secretKey);
	}

	@Override
	public boolean updateSecretKey(String id, String updateToThisKey, String secretKey) {
		return this.update(id, "secret_key", updateToThisKey, secretKey);
	}
	
	public boolean deleteUserLog(String id, String secretKey) {
		String query = "delete from users_log where userLog_id=? limit 1";
		
		try	{
			UserLogModel.stmt = this.dbConnection.prepareStatement(query);
			UserLogModel.stmt.setString(1, id);
			
			if(UserLogModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("deleteUserLog", "id: " + id + " is deleted from users_log");
				return true;
			}
			else	{
				debug.printMessage("deleteUserLog", "id: " + id + " is not deleted from users_log");
				return false;
			}
		}
		catch(SQLException e)	{
			debug.printMessage("deleteUserLog", "id: " + id + "cannot be deleted because foreign key might be using it");
			return false;
		}
	}
	
	public UserLog getUserLog(String id, String secretKey)	{
		if(!this.getSecretKey(id, secretKey).equals(""))	{
			return new UserLog(id, this.getStartTime(id, secretKey), this.getEndTime(id, secretKey), this.getDeliveredTime(id, secretKey),
					this.getCurrentLocation(id, secretKey), this.getDropLocation(id, secretKey), this.getMessage(id, secretKey), this.getTotalAmount(id, secretKey),
					this.getPaidAmount(id, secretKey), this.getSecretKey(id, secretKey));
		}
		else	return new UserLog();
	}

}
