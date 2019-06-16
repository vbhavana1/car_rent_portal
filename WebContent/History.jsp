<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mysql.cj.Session"%>
<%@ 
	page
	import="
		com.rent.car.controller.UserController, 
		com.rent.car.controller.BookingController, 
		com.rent.car.controller.UserLogController, 
		javax.servlet.http.HttpSession
	"%>
	
<!DOCTYPE html>
<html>
<head>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<title>RentoCar: History</title>
</head>
<body>

	<%
		String id = (String) request.getSession().getAttribute("session_id");
		UserController user = (UserController) request.getSession().getAttribute("user_controller");

		if (id != null && !user.getFirstName(id).equals("")) {

			// Getting the necessary objects from session
			UserLogController userLog = (UserLogController) request.getSession()
					.getAttribute("user_log_controller");
			BookingController booking = (BookingController) request.getSession().getAttribute("booking_controller");

			// Using the necessary objects
			String userWallet = user.getWallet(id);
			String userFirstName = user.getFirstName(id);
			String userEmail = user.getEmail(id);
			String carPickupLocation = userLog.getCurrentLocation(id);
			String carPickupTime = userLog.getStartTime(id);
	%>
	<%
		} else {
			response.sendRedirect("Index.jsp");
		}
	%>

</body>
</html>