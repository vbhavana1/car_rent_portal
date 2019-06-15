package com.rent.car.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rent.car.bean.Person;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession userSession= request.getSession();
		
		UserController user= new UserController((Connection)getServletContext().getAttribute("dbConnection"));

		Person person = new Person();
		
		if(user.isEmailPresent(request.getParameter("email"))) {
			
		}
		else {
			
			BookingController booking = new BookingController((Connection)getServletContext().getAttribute("dbConnection"));
			UserLogController userLog = new UserLogController((Connection)getServletContext().getAttribute("dbConnection"));
			CarController car = new CarController((Connection)getServletContext().getAttribute("dbConnection"));
			
			// Method to generate random user id
			int id = Math.abs(100000 + (new Random().nextInt()) * 90000);
			
			//Setting the attributes to person
			person.setId(Integer.toString(id));
			person.setFirstName(request.getParameter("firstname"));
			person.setLastName(request.getParameter("lastname"));
			person.setEmail(request.getParameter("email"));
			person.setMobileNumber(request.getParameter("mobileno"));
			person.setUsername(request.getParameter("username"));
			person.setDrivingLicenseNumber(request.getParameter("driving_id"));
			person.setPassword(request.getParameter("password"));
			person.setWallet("0");
			person.setGovtIdType(request.getParameter("idtype"));
			person.setGovtIdNumber(request.getParameter("verification_id"));
			
			//Checking the logs
			System.out.println(person.getGovtIdType());
			
			user.setUser(person);
			userSession.setAttribute("session_id", id);
			userSession.setAttribute("user_controller", user);
			userSession.setAttribute("user_log_controller", userLog);
			userSession.setAttribute("booking_controller", booking);
			userSession.setAttribute("car_controller", car);
			
			request.getRequestDispatcher("User.jsp").forward(request, response);;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
