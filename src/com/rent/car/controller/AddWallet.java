package com.rent.car.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rent.car.bean.Person;

@WebServlet("/addwallet")
public class AddWallet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UserController user = (UserController)request.getSession().getAttribute("user_controller");
			String id = (String)request.getSession().getAttribute("session_id");
	
			if(!id.equals(""))	{
				int amount=Integer.parseInt(user.getWallet(id));
				int entered_amount = ((String)request.getParameter("amount")).equals("")? 0 : Integer.parseInt((String)request.getParameter("amount"));
				amount = amount + entered_amount;
				user.updateWallet(id, new Integer(amount).toString());		

				//Moving to the login page
				request.getRequestDispatcher("User.jsp").forward(request, response);
			}
			else	{
				response.sendRedirect("index.html");
			}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
