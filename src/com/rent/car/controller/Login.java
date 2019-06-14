package com.rent.car.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	{
		 //Testing the basic functionality of dbControllers
		UserController user = new UserController((Connection)getServletContext().getAttribute("dbConnection"));
		UserLogController userLog = new UserLogController((Connection)getServletContext().getAttribute("dbConnection"));
		BookingController booking = new BookingController((Connection)getServletContext().getAttribute("dbConnection"));
		CarController car = new CarController((Connection)getServletContext().getAttribute("dbConnection"));
		
			response.getWriter().append("FirstName: " + user.getFirstName("432523443"));
			response.getWriter().append(" CarName: " + car.getCarName("1001"));
			response.getWriter().append(" Status: " + booking.getStatus("KA-4234231"));
			response.getWriter().append(" Current Location: " + userLog.getCurrentLocation("432523443", "552424244"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
