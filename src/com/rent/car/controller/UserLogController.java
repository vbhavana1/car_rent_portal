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
	public String getStartTime(String id) {
		return this.userLogModel.getStartTime(id);
	}

	@Override
	public String getEndTime(String id) {
		return this.userLogModel.getEndTime(id);
	}

	@Override
	public String getDeliveredTime(String id) {
		return this.userLogModel.getDeliveredTime(id);
	}

	@Override
	public String getCurrentLocation(String id) {
		return this.userLogModel.getCurrentLocation(id);
	}

	@Override
	public String getDropLocation(String id) {
		return this.userLogModel.getDropLocation(id);
	}

	@Override
	public String getMessage(String id) {
		return this.userLogModel.getMessage(id);
	}

	@Override
	public String getTotalAmount(String id) {
		return this.userLogModel.getTotalAmount(id);
	}

	@Override
	public String getPaidAmount(String id) {
		return this.userLogModel.getPaidAmount(id);
	}

	@Override
	public String getSecretKey(String id) {
		return this.userLogModel.getSecretKey(id);
	}

	@Override
	public boolean updateStartTime(String id, String startTime) {
		return this.userLogModel.updateStartTime(id, startTime);
	}

	@Override
	public boolean updateEndTime(String id, String endTime) {
		return this.userLogModel.updateEndTime(id, endTime);
	}

	@Override
	public boolean updateDeliveredTime(String id, String deliveredTime) {
		return this.userLogModel.updateDeliveredTime(id, deliveredTime);
	}

	@Override
	public boolean updateCurrentLocation(String id, String currentLocation) {
		return this.userLogModel.updateCurrentLocation(id, currentLocation);
	}

	@Override
	public boolean updateDropLocation(String id, String dropLocation) {
		return this.userLogModel.updateDropLocation(id, dropLocation);
	}

	@Override
	public boolean updateMessage(String id, String message) {
		return this.userLogModel.updateMessage(id, message);
	}

	@Override
	public boolean updateTotalAmount(String id, String totalAmount) {
		return this.userLogModel.updateTotalAmount(id, totalAmount);
	}

	@Override
	public boolean updatePaidAmount(String id, String paidAmount) {
		return this.userLogModel.updatePaidAmount(id, paidAmount);
	}

	@Override
	public boolean updateSecretKey(String id, String updateToThisKey) {
		return this.userLogModel.updateSecretKey(id, updateToThisKey);
	}

	@Override
	public String get(String id, String whatToGet) {
		return this.userLogModel.get(id, whatToGet);
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value) {
		return this.userLogModel.update(id, whatToUpdate, value);
	}

	public boolean deleteUserLog(String id)	{
		return this.userLogModel.deleteUserLog(id);
	}
	
	public UserLog getUserLog(String id)	{
		return this.userLogModel.getUserLog(id);
	}
	
	public UserLog[] getUserHistory(String id)	{
		return this.userLogModel.getUserHistory(id);
	}
}
