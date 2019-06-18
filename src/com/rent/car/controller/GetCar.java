//Author Dheeraj Joshi
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

/**
 * Servlet implementation class GetCar
 */
@WebServlet("/getcar")
public class GetCar extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarController car  = new CarController((Connection)getServletContext().getAttribute("dbConnection"));
		response.setContentType("application/json");
		
		HttpSession userSession = request.getSession();
		
		String carname =request.getParameter("carname");
		String[] carids=car.getCarIds(carname);
		response.getWriter().append("[");
		for(int i=1;i<carids.length;i++) {
			
			response.getWriter().print(car.getCar(carids[i]));
			if(i<carids.length-1)
			response.getWriter().append(",");
			
		}
		response.getWriter().append("]");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
