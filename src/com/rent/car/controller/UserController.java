package com.rent.car.controller;

import java.sql.Connection;

import com.rent.car.bean.Person;
import com.rent.car.model.UserModel;

public class UserController implements UserControllerInterface	{
	public UserModel userModel;
	
	public UserController(Connection dbConnection)	{
		this.userModel = new UserModel(dbConnection);
	}
	
	@Override
	public boolean isIdPresent(String id) {
		return this.userModel.isIdPresent(id);
	}

	@Override
	public String getName(String id) {
		return this.userModel.getName(id);
	}

	@Override
	public String getFirstName(String id) {
		return this.userModel.getFirstName(id);
	}

	@Override
	public String getLastName(String id) {
		return this.userModel.getLastName(id);
	}

	@Override
	public String getMobileNumber(String id) {
		return this.userModel.getMobileNumber(id);
	}

	@Override
	public String getGovtIdType(String id) {
		return this.userModel.getGovtIdType(id);
	}

	@Override
	public String getGovtIdNumber(String id) {
		return this.userModel.getGovtIdNumber(id);
	}

	@Override
	public String getDrivingLicenseNumber(String id) {
		return this.userModel.getDrivingLicenseNumber(id);
	}

	@Override
	public String getUsername(String id) {
		return this.userModel.getUsername(id);
	}

	@Override
	public String getEmail(String id) {
		return this.userModel.getEmail(id);
	}

	@Override
	public String getWallet(String id) {
		return this.userModel.getWallet(id);
	}

	@Override
	public boolean setUser(Person person) {
		return this.userModel.setUser(person);
	}

	@Override
	public boolean updateFirstName(String id, String firstName) {
		return this.userModel.updateFirstName(id, firstName);
	}

	@Override
	public boolean updateLastName(String id, String lastName) {
		return this.userModel.updateLastName(id, lastName);
	}

	@Override
	public boolean updateMobileNumber(String id, String mobileNumber) {
		return this.userModel.updateMobileNumber(id, mobileNumber);
	}

	@Override
	public boolean updateGovtIdType(String id, String govtIdType) {
		return this.userModel.updateGovtIdType(id, govtIdType);
	}

	@Override
	public boolean updateGovtIdNumber(String id, String govtIdNumber) {
		return this.userModel.updateGovtIdNumber(id, govtIdNumber);
	}

	@Override
	public boolean updateDrivingLicenseNumber(String id, String drivingLicenseNumber) {
		return this.userModel.updateDrivingLicenseNumber(id, drivingLicenseNumber);
	}

	@Override
	public boolean updateUsername(String id, String username) {
		return this.userModel.updateUsername(id, username);
	}

	@Override
	public boolean updateEmail(String id, String email) {
		return this.userModel.updateEmail(id, email);
	}

	@Override
	public boolean updateWallet(String id, String wallet) {
		return this.userModel.updateWallet(id, wallet);
	}

	@Override
	public String get(String id, String whatToGet) {
		return this.userModel.get(id, whatToGet);
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value) {
		return this.userModel.update(id, whatToUpdate, value);
	}

	public Person getPerson(String id)	{
		return this.userModel.getPerson(id);
	}
	
	public boolean deletePerson(String id)	{
		return this.userModel.deletePerson(id);
	}
	
	public String getId(String uniqueId)	{
		return this.userModel.getId(uniqueId);
	}
}
