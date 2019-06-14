package com.rent.car.controller;

import com.rent.car.bean.UserLog;
import com.rent.car.model.UserLogModel;

public class UserLogController implements UserLogControllerInterface	{
	
	public static UserLogModel userLogModel;
	
	static	{
		UserLogController.userLogModel = new UserLogModel();
	}
	
	@Override
	public boolean isUserIdPresent(String id) {
		return UserLogController.userLogModel.isUserIdPresent(id);
	}

	@Override
	public boolean setBookingDetail(UserLog userLog) {
		return UserLogController.userLogModel.setBookingDetail(userLog);
	}

	@Override
	public String getStartTime(String id, String secretKey) {
		return UserLogController.userLogModel.getStartTime(id, secretKey);
	}

	@Override
	public String getEndTime(String id, String secretKey) {
		return UserLogController.userLogModel.getEndTime(id, secretKey);
	}

	@Override
	public String getDeliveredTime(String id, String secretKey) {
		return UserLogController.userLogModel.getDeliveredTime(id, secretKey);
	}

	@Override
	public String getCurrentLocation(String id, String secretKey) {
		return UserLogController.userLogModel.getCurrentLocation(id, secretKey);
	}

	@Override
	public String getDropLocation(String id, String secretKey) {
		return UserLogController.userLogModel.getDropLocation(id, secretKey);
	}

	@Override
	public String getMessage(String id, String secretKey) {
		return UserLogController.userLogModel.getMessage(id, secretKey);
	}

	@Override
	public String getTotalAmount(String id, String secretKey) {
		return UserLogController.userLogModel.getTotalAmount(id, secretKey);
	}

	@Override
	public String getPaidAmount(String id, String secretKey) {
		return UserLogController.userLogModel.getPaidAmount(id, secretKey);
	}

	@Override
	public String getSecretKey(String id, String secretKey) {
		return UserLogController.userLogModel.getSecretKey(id, secretKey);
	}

	@Override
	public boolean updateStartTime(String id, String startTime, String secretKey) {
		return UserLogController.userLogModel.updateStartTime(id, startTime, secretKey);
	}

	@Override
	public boolean updateEndTime(String id, String endTime, String secretKey) {
		return UserLogController.userLogModel.updateEndTime(id, endTime, secretKey);
	}

	@Override
	public boolean updateDeliveredTime(String id, String deliveredTime, String secretKey) {
		return UserLogController.userLogModel.updateDeliveredTime(id, deliveredTime, secretKey);
	}

	@Override
	public boolean updateCurrentLocation(String id, String currentLocation, String secretKey) {
		return UserLogController.userLogModel.updateCurrentLocation(id, currentLocation, secretKey);
	}

	@Override
	public boolean updateDropLocation(String id, String dropLocation, String secretKey) {
		return UserLogController.userLogModel.updateDropLocation(id, dropLocation, secretKey);
	}

	@Override
	public boolean updateMessage(String id, String message, String secretKey) {
		return UserLogController.userLogModel.updateMessage(id, message, secretKey);
	}

	@Override
	public boolean updateTotalAmount(String id, String totalAmount, String secretKey) {
		return UserLogController.userLogModel.updateTotalAmount(id, totalAmount, secretKey);
	}

	@Override
	public boolean updatePaidAmount(String id, String paidAmount, String secretKey) {
		return UserLogController.userLogModel.updatePaidAmount(id, paidAmount, secretKey);
	}

	@Override
	public boolean updateSecretKey(String id, String secretKey, String updateToThisKey) {
		return UserLogController.userLogModel.updateSecretKey(id, updateToThisKey, secretKey);
	}

	@Override
	public String get(String id, String whatToGet, String secretKey) {
		return UserLogController.userLogModel.get(id, whatToGet, secretKey);
	}

	@Override
	public boolean update(String id, String whatToUpdate, String value, String secretKey) {
		return UserLogController.userLogModel.update(id, whatToUpdate, value, secretKey);
	}

	public boolean deleteUserLog(String id, String secretKey)	{
		return UserLogController.userLogModel.deleteUserLog(id, secretKey);
	}
	
	public UserLog getUserLog(String id, String secretKey)	{
		return UserLogController.userLogModel.getUserLog(id, secretKey);
	}
}
