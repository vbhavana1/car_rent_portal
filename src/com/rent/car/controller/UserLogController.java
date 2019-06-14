package com.rent.car.controller;

import java.sql.Connection;

import com.rent.car.bean.UserLog;
import com.rent.car.model.UserLogModel;

public class UserLogController implements UserLogControllerInterface	{
	public UserLogModel userLogModel;
	
	public UserLogController(Connection dbConnection)	{
		this.userLogModel = new UserLogModel(dbConnection);
	}
	
	@Override
	public boolean isUserIdPresent(String id) {
		return this.userLogModel.isUserIdPresent(id);
	}

	@Override
	public boolean setBookingDetail(UserLog userLog) {
		return this.userLogModel.setBookingDetail(userLog);
	}

	@Override
	public String getStartTime(String id, String secretKey) {
		return this.userLogModel.getStartTime(id, secretKey);
	}

	@Override
	public String getEndTime(String id, String secretKey) {
		return this.userLogModel.getEndTime(id, secretKey);
	}

	@Override
	public String getDeliveredTime(String id, String secretKey) {
		return this.userLogModel.getDeliveredTime(id, secretKey);
	}

	@Override
	public String getCurrentLocation(String id, String secretKey) {
		return this.userLogModel.getCurrentLocation(id, secretKey);
	}

	@Override
	public String getDropLocation(String id, String secretKey) {
		return this.userLogModel.getDropLocation(id, secretKey);
	}

	@Override
	public String getMessage(String id, String secretKey) {
		return this.userLogModel.getMessage(id, secretKey);
	}

	@Override
	public String getTotalAmount(String id, String secretKey) {
		return this.userLogModel.getTotalAmount(id, secretKey);
	}

	@Override
	public String getPaidAmount(String id, String secretKey) {
		return this.userLogModel.getPaidAmount(id, secretKey);
	}

	@Override
	public String getSecretKey(String id, String secretKey) {
		return this.userLogModel.getSecretKey(id, secretKey);
	}

	@Override
	public boolean updateStartTime(String id, String startTime, String secretKey) {
		return this.userLogModel.updateStartTime(id, startTime, secretKey);
	}

	@Override
	public boolean updateEndTime(String id, String endTime, String secretKey) {
		return this.userLogModel.updateEndTime(id, endTime, secretKey);
	}

	@Override
	public boolean updateDeliveredTime(String id, String deliveredTime, String secretKey) {
		return this.userLogModel.updateDeliveredTime(id, deliveredTime, secretKey);
	}

	@Override
	public boolean updateCurrentLocation(String id, String currentLocation, String secretKey) {
		return this.userLogModel.updateCurrentLocation(id, currentLocation, secretKey);
	}

	@Override
	public boolean updateDropLocation(String id, String dropLocation, String secretKey) {
		return this.userLogModel.updateDropLocation(id, dropLocation, secretKey);
	}

	@Override
	public boolean updateMessage(String id, String message, String secretKey) {
		return this.userLogModel.updateMessage(id, message, secretKey);
	}

	@Override
	public boolean updateTotalAmount(String id, String totalAmount, String secretKey) {
		return this.userLogModel.updateTotalAmount(id, totalAmount, secretKey);
	}

	@Override
	public boolean updatePaidAmount(String id, String paidAmount, String secretKey) {
		return this.userLogModel.updatePaidAmount(id, paidAmount, secretKey);
	}

	@Override
	public boolean updateSecretKey(String id, String secretKey, String updateToThisKey) {
		return this.userLogModel.updateSecretKey(id, updateToThisKey, secretKey);
	}

	@Override
	public String get(String id, String whatToGet, String secretKey) {
		return this.userLogModel.get(id, whatToGet, secretKey);
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value, String secretKey) {
		return this.userLogModel.update(id, whatToUpdate, value, secretKey);
	}

	public boolean deleteUserLog(String id, String secretKey)	{
		return this.userLogModel.deleteUserLog(id, secretKey);
	}
	
	public UserLog getUserLog(String id, String secretKey)	{
		return this.userLogModel.getUserLog(id, secretKey);
	}
}
