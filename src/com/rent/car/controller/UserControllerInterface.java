package com.rent.car.controller;

import com.rent.car.bean.Person;

public interface UserControllerInterface {
	// Abstract method to check Id
	public abstract boolean isIdPresent(String id);
	
	// Method to get details except password
	public abstract String getName(String id);
	public abstract String getFirstName(String id);
	public abstract String getLastName(String id);
	public abstract String getMobileNumber(String id);
	public abstract String getGovtIdType(String id);
	public abstract String getGovtIdNumber(String id);
	public abstract String getDrivingLicenseNumber(String id);
	public abstract String getUsername(String id);
	public abstract String getEmail(String id);
	public abstract String getWallet(String id);
	
	// Method to set details
	public abstract boolean setUser(Person person);
	
	// Method to update details
	public abstract boolean updateFirstName(String id, String firstName);
	public abstract boolean updateLastName(String id, String lastName);
	public abstract boolean updateMobileNumber(String id, String mobileNumber);
	public abstract boolean updateGovtIdType(String id, String govtIdType);
	public abstract boolean updateGovtIdNumber(String id, String govtIdNumber);
	public abstract boolean updateDrivingLicenseNumber(String id, String drivingLicenseNumber);
	public abstract boolean updateUsername(String id, String username);
	public abstract boolean updateEmail(String id, String email);
	public abstract boolean updateWallet(String id, String wallet);
	
	// General method to get and update properties
	public abstract String get(String id, String whatToGet);
	public abstract boolean update(String id, String whatToUpdate, String value);
}
