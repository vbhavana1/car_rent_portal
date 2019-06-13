package com.rent.car.bean;

public class Person {
	private String id, firstName, lastName, mobileNumber, govtIdType, govtIdNumber, drivingLicenseNumber, username, password, email, wallet;
	
	public Person()	{
		this.id = this.firstName = this.lastName = this.mobileNumber = this.govtIdType = this.govtIdNumber = this.drivingLicenseNumber = this.username = this.password = this.email = this.wallet = ""; 
	}

	public Person(String id, String firstName, String lastName, String mobileNumber, String govtIdType,
			String govtIdNumber, String drivingLicenseNumber, String username, String password, String email,
			String wallet) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.govtIdType = govtIdType;
		this.govtIdNumber = govtIdNumber;
		this.drivingLicenseNumber = drivingLicenseNumber;
		this.username = username;
		this.password = password;
		this.email = email;
		this.wallet = wallet;	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGovtIdType() {
		return govtIdType;
	}

	public void setGovtIdType(String govtIdType) {
		this.govtIdType = govtIdType;
	}

	public String getGovtIdNumber() {
		return govtIdNumber;
	}

	public void setGovtIdNumber(String govtIdNumber) {
		this.govtIdNumber = govtIdNumber;
	}

	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}
}
