package com.rent.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rent.car.bean.Person;
//import com.rent.car.controller.ContextListener;
import com.rent.car.helper.Debug;
//import com.rent.car.helper.RentCarException;

public class UserModel implements UserModelInterface {
	
	private Connection dbConnection;
	private static PreparedStatement stmt;
	private static Debug debug;
	
	public UserModel(Connection dbConnection)	{
		this.dbConnection = dbConnection;
	}
	
	static	{
		
		// Setting the debug mode
		UserModel.debug = new Debug();
		UserModel.debug.setPrintLog(true);
		
//		try	{
//			this.dbConnection = ContextListener.useContextConnection();
//		}
//		catch(RentCarException rce)	{
//			UserModel.debug.printMessage("UserModel.static_block", "connection is not established");
//			System.out.println(rce);
//		}
	}

	@Override
	public String get(String id, String whatToGet) {
		String query = String.format("select %s from user_table where user_id=?", whatToGet);
		
		try {
			UserModel.stmt = this.dbConnection.prepareStatement(query);
			UserModel.stmt.setString(1, id);
			
			ResultSet rs = UserModel.stmt.executeQuery();
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
	public boolean setUser(Person person) {
		String query = "insert into user_table values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try	{
			UserModel.stmt = this.dbConnection.prepareStatement(query);
			UserModel.stmt.setString(1, person.getId());
			UserModel.stmt.setString(2, person.getFirstName());
			UserModel.stmt.setString(3, person.getLastName());
			UserModel.stmt.setString(4, person.getMobileNumber());
			UserModel.stmt.setString(5, person.getGovtIdType());
			UserModel.stmt.setString(6, person.getGovtIdNumber());
			UserModel.stmt.setString(7, person.getDrivingLicenseNumber());
			UserModel.stmt.setString(8, person.getUsername());
			UserModel.stmt.setString(9, person.getPassword());
			UserModel.stmt.setString(10, person.getEmail());
			UserModel.stmt.setString(11, person.getWallet());
			
			if(UserModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("setUser", person.getFirstName() + " " + person.getLastName() + " is inserted in user_table");
				return true;
			}
			else	{
				debug.printMessage("setUser", person.getFirstName() + " " + person.getLastName() + " is not inserted in user_table");
				return false;
			}
		}
		catch(SQLException e)	{
			debug.printMessage("setUser", "cannot set the data");
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(String id, String whatToUpdate, String value)	{
		String query = String.format("update user_table set %s=? where user_id=?", whatToUpdate);
		
		try	{
			UserModel.stmt = this.dbConnection.prepareStatement(query);
			UserModel.stmt.setString(1, value);
			UserModel.stmt.setString(2, id);
			
			if(UserModel.stmt.executeUpdate() != 0)	{
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

	public boolean isPresent(String id, String whatToCheck)	{
		String query = String.format("select %s from user_table where user_id=?", whatToCheck);
		
		try	{
			UserModel.stmt = this.dbConnection.prepareStatement(query);
			UserModel.stmt.setString(1, id);
			
			ResultSet rs = UserModel.stmt.executeQuery();
			
			while(rs.next())	{
				if(rs.getString(1).equals(id))	{
					debug.printMessage("isPresent", "id:" + id + " is present");
					return true;
				}
			}
			
			debug.printMessage("isPresent", "id:" + id + " is not present");
			return false;
		}
		catch(SQLException e)	{
			debug.printMessage("isPresent", "cannot fetch id");
			return false;
		}
	}

	@Override
	public String getName(String id) {
		return this.getFirstName(id) + " " + this.getLastName(id);
	}

	@Override
	public String getFirstName(String id) {
		return this.get(id, "first_name");
	}

	@Override
	public String getLastName(String id) {
		return this.get(id, "last_name");
	}

	@Override
	public String getMobileNumber(String id) {
		return this.get(id, "mobile_num");
	}

	@Override
	public String getGovtIdType(String id) {
		return this.get(id, "govt_id_type");
	}

	@Override
	public String getGovtIdNumber(String id) {
		return this.get(id, "govt_id_no");
	}

	@Override
	public String getDrivingLicenseNumber(String id) {
		return this.get(id, "driving_license_no");
	}

	@Override
	public String getUsername(String id) {
		return this.get(id, "user_name");
	}
	
	public String getPassword(String id)	{
		return this.get(id, "password");
	}

	@Override
	public String getEmail(String id) {
		return this.get(id, "email");
	}

	@Override
	public String getWallet(String id) {
		return this.get(id, "wallet");
	}

	@Override
	public boolean updateFirstName(String id, String firstName) {
		return this.update(id, "first_name", firstName);
	}

	@Override
	public boolean updateLastName(String id, String lastName) {
		return this.update(id, "last_name", lastName);
	}

	@Override
	public boolean updateMobileNumber(String id, String mobileNumber) {
		return this.update(id, "mobile_num", mobileNumber);
	}

	@Override
	public boolean updateGovtIdType(String id, String govtIdType) {
		return this.update(id, "govt_id_type", govtIdType);
	}

	@Override
	public boolean updateGovtIdNumber(String id, String govtIdNumber) {
		return this.update(id, "govt_id_no", govtIdNumber);
	}

	@Override
	public boolean updateDrivingLicenseNumber(String id, String drivingLicenseNumber) {
		return this.update(id, "driving_license_no", drivingLicenseNumber);
	}

	@Override
	public boolean updateUsername(String id, String username) {
		return this.update(id, "username", username);
	}

	@Override
	public boolean updateEmail(String id, String email) {
		return this.update(id, "email", email);
	}

	@Override
	public boolean updateWallet(String id, String wallet) {
		return this.update(id, "wallet", wallet);
	}
	
	public Person getPerson(String id)	{
		if(this.isIdPresent(id))	{
			return new Person(id, this.getFirstName(id), this.getLastName(id), this.getMobileNumber(id), this.getGovtIdType(id), this.getGovtIdNumber(id),
					this.getDrivingLicenseNumber(id), this.getUsername(id), this.getPassword(id), this.getEmail(id), this.getWallet(id));
		}
		else	return new Person();
	}
	
	public boolean deletePerson(String id)	{
		String query = "delete from user_table where user_id=? limit 1";
		
		try	{
			UserModel.stmt = this.dbConnection.prepareStatement(query);
			UserModel.stmt.setString(1, id);
			
			if(UserModel.stmt.executeUpdate() != 0)	{
				debug.printMessage("deletePerson", "id: " + id + " is deleted from user_table");
				return true;
			}
			else	{
				debug.printMessage("deletePerson", "id: " + id + " is not deleted from user_table");
				return false;
			}
		}
		catch(SQLException e)	{
			debug.printMessage("deletePerson", "id: " + id + "cannot be deleted because foreign key might be using it");
			return false;
		}
	}
	
	public String getId(String uniqueId)	{
		String query = "select user_id from user_table where mobile_num=? or user_name=? or email=?";
		
		try {
			UserModel.stmt = this.dbConnection.prepareStatement(query);
			UserModel.stmt.setString(1, uniqueId);
			UserModel.stmt.setString(2, uniqueId);
			UserModel.stmt.setString(3, uniqueId);
			
			ResultSet rs = UserModel.stmt.executeQuery();
			String returnIt = "";
			
			while(rs.next())	{
				returnIt = rs.getString(1);
			}
			debug.printMessage("getId", "id: " + returnIt);
			return returnIt;
		}
		catch (SQLException e) {
			debug.printMessage("getId", "cannot get the data");
			e.printStackTrace();
			return "";
		}
	}
	
	@Override
	public boolean isIdPresent(String id)	{
		return this.isPresent(id, "user_id");
	}
	
	public boolean isEmailPresent(String email)	{
		return this.isPresent(email, "email");
	}
	
	public boolean isUsernamePresent(String username)	{
		return this.isPresent(username, "user_name");
	}
	
	public boolean isMobilePresent(String mobileNum)	{
		return this.isPresent(mobileNum, "mobile_num");
	}
	
	public String getTotalUsers()	{
		String query = "select count(user_id) from user_table";
		
		try {
			UserModel.stmt = this.dbConnection.prepareStatement(query);
			
			ResultSet rs = UserModel.stmt.executeQuery();
			String returnIt = "";
			
			while(rs.next())	{
				returnIt = rs.getString(1);
			}
			debug.printMessage("getTotalUsers", "users: " + returnIt);
			return returnIt;
		}
		catch (SQLException e) {
			debug.printMessage("getTotalUsers", "cannot get the data");
			e.printStackTrace();
			return "";
		}
	}
}
