package com.rent.car.controller;

import com.rent.car.bean.Person;
import com.rent.car.model.UserModel;

public class UserController implements UserControllerInterface	{
	public static UserModel userModel;
	
	static	{
		UserController.userModel = new UserModel();
	}
	
	@Override
	public boolean isIdPresent(String id) {
		return UserController.userModel.isIdPresent(id);
	}

	@Override
	public String getName(String id) {
		return UserController.userModel.getName(id);
	}

	@Override
	public String getFirstName(String id) {
		return UserController.userModel.getFirstName(id);
	}

	@Override
	public String getLastName(String id) {
		return UserController.userModel.getLastName(id);
	}

	@Override
	public String getMobileNumber(String id) {
		return UserController.userModel.getMobileNumber(id);
	}

	@Override
	public String getGovtIdType(String id) {
		return UserController.userModel.getGovtIdType(id);
	}

	@Override
	public String getGovtIdNumber(String id) {
		return UserController.userModel.getGovtIdNumber(id);
	}

	@Override
	public String getDrivingLicenseNumber(String id) {
		return UserController.userModel.getDrivingLicenseNumber(id);
	}

	@Override
	public String getUsername(String id) {
		return UserController.userModel.getUsername(id);
	}

	@Override
	public String getEmail(String id) {
		return UserController.userModel.getEmail(id);
	}

	@Override
	public String getWallet(String id) {
		return UserController.userModel.getWallet(id);
	}

	@Override
	public boolean setUser(Person person) {
		return UserController.userModel.setUser(person);
	}

	@Override
	public boolean updateFirstName(String id, String firstName) {
		return UserController.userModel.updateFirstName(id, firstName);
	}

	@Override
	public boolean updateLastName(String id, String lastName) {
		return UserController.userModel.updateLastName(id, lastName);
	}

	@Override
	public boolean updateMobileNumber(String id, String mobileNumber) {
		return UserController.userModel.updateMobileNumber(id, mobileNumber);
	}

	@Override
	public boolean updateGovtIdType(String id, String govtIdType) {
		return UserController.userModel.updateGovtIdType(id, govtIdType);
	}

	@Override
	public boolean updateGovtIdNumber(String id, String govtIdNumber) {
		return UserController.userModel.updateGovtIdNumber(id, govtIdNumber);
	}

	@Override
	public boolean updateDrivingLicenseNumber(String id, String drivingLicenseNumber) {
		return UserController.userModel.updateDrivingLicenseNumber(id, drivingLicenseNumber);
	}

	@Override
	public boolean updateUsername(String id, String username) {
		return UserController.userModel.updateUsername(id, username);
	}

	@Override
	public boolean updateEmail(String id, String email) {
		return UserController.userModel.updateEmail(id, email);
	}

	@Override
	public boolean updateWallet(String id, String wallet) {
		return UserController.userModel.updateWallet(id, wallet);
	}

	@Override
	public String get(String id, String whatToGet) {
		return UserController.userModel.get(id, whatToGet);
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value) {
		return UserController.userModel.update(id, whatToUpdate, value);
	}

	public Person getPerson(String id)	{
		return UserController.userModel.getPerson(id);
	}
	
	public boolean deletePerson(String id)	{
		return UserController.userModel.deletePerson(id);
	}
	
	public String getId(String uniqueId)	{
		return UserController.userModel.getId(uniqueId);
	}
}
