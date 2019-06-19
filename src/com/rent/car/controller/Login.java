package com.rent.car.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rent.car.bean.Person;

@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	{
		UserController user = new UserController((Connection)getServletContext().getAttribute("dbConnection"));
		UserLogController userLog = new UserLogController((Connection)getServletContext().getAttribute("dbConnection"));
		BookingController booking = new BookingController((Connection)getServletContext().getAttribute("dbConnection"));
		CarController car  = new CarController((Connection)getServletContext().getAttribute("dbConnection"));

		HttpSession userSession = request.getSession();
		
		String id = user.getId(request.getParameter("username"));
		String password = request.getParameter("password");
		
		Person person = user.getPerson(id);
		
		// Used for console message
		System.out.println("[Form gave]: Id: " + id + " password: " + password);
		
//		response.setContentType("text/html");
		
		if((!id.equals("")) && (person.getPassword().equals(request.getParameter("password"))))	{
			userSession.setAttribute("session_id", id);
			
			// Associating all the objects to session
			userSession.setAttribute("user_controller", user);
			userSession.setAttribute("user_log_controller", userLog);
			userSession.setAttribute("booking_controller", booking);
			userSession.setAttribute("car_controller", car);
			
			//Moving to the login page
			//response.getWriter().append("success");
			
			if(id.equals("0"))	{
				response.getWriter().append("admin_success");
				//request.getRequestDispatcher("AdminPanel.jsp").forward(request, response);
			}
			else 	{
				response.getWriter().append("user_success");
				//request.getRequestDispatcher("User.jsp").forward(request, response);
			}
		}
		else	{
			// Sending the response to Index page for user login failure
			response.getWriter().append("failure");
			//request.getRequestDispatcher("Index.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
