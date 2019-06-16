<%@page import="com.rent.car.bean.UserLog"%>
<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ 
	page import="
		com.rent.car.controller.UserController, 
		com.rent.car.controller.BookingController, 
		com.rent.car.controller.UserLogController, 
		javax.servlet.http.HttpSession
	"
%>
<!DOCTYPE html>
<html>
<head>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!-- Compiled and minified CSS -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
      <title>RentoCar: Welcome</title>
      <style media="screen">
         .card-style{
         	height: 56.25%;
         	width: 99.5%;
         }
      </style>
</head>
<body>

	<%
		String id = (String)request.getSession().getAttribute("session_id");
		UserController user = (UserController)request.getSession().getAttribute("user_controller");
		
		if(id != null && !user.getFirstName(id).equals(""))	{
			
			// Getting the necessary objects from session
			UserLogController userLog = (UserLogController)request.getSession().getAttribute("user_log_controller");
			BookingController booking = (BookingController)request.getSession().getAttribute("booking_controller");
			
			// Using the necessary objects
			String userWallet = user.getWallet(id);
			String userFirstName = user.getFirstName(id);
			String userEmail = user.getEmail(id);
			String carPickupLocation = userLog.getCurrentLocation(id);
			String carPickupTime = userLog.getStartTime(id);
	%>
      <!-- Navigation -->
      <div class="navbar-fixed">
         <nav class="nav-wrapper indigo darken-3">
            <div class="container">
               <a class="sidenav-trigger" href="#" data-target="menu-link">
               <i class="material-icons">menu</i>
               </a>
               <div class="brand-logo">
                  <a href="#">
                  RentoCar
                  </a>
               </div>
               <ul class="right hide-on-med-and-down">
                  <li>
                     <a href="#wallet" class="waves-effect waves-dark">Wallet</a>
                  </li>
                  <li>
                     <a href="#booking" class="waves-effect waves-dark dropdown-trigger" data-target="booking_dropdown">Booking</a>
                  </li>
				  <!-- Booking Dropdown -->
				  <ul id="booking_dropdown" class="dropdown-content">
					  <li><a href="rent_car" class="indigo-text">Rent a car</a></li>
					  <li><a href="current_bookings" class="indigo-text">Current Booking</a></li>
					  <li><a href="history" class="indigo-text">History</a></li>
				  </ul>
				  <li>
					  <a href="#username" class="waves-effect waves-dark dropdown-trigger" data-target="account_dropdown">
						  <i class="material-icons">person_outline</i>
					  </a>
				  </li>
				  <!-- Account Dropdown -->
				  <ul id="account_dropdown" class="dropdown-content">
				  	<li>
				  		<a class="indigo-text">Hi <%= userFirstName %></a>
				  	</li>
					  <li><a href="user_profile" class="indigo-text">Profile</a></li>
					  <li><a href="logout" class="indigo-text">Logout</a></li>
				  </ul>
               </ul>
            </div>
         </nav>
      </div>

      <!-- Side Navigation for mobile devices -->
      <ul class="sidenav" id="menu-link">
		  <li>
			  <div class="user-view">
				   <div class="background indigo accent-2"></div>
				   <a href="#user">
					   <img src="../images/mini_car.jpg" class="circle">
				   </a>
				   <a href="#name"><span class="name white-text"><%= userFirstName %></span></a>
				   <a href="#email"><span class="email white-text"><%= userEmail %></span></a>
			  </div>
		  </li>
         <li>
            <a href="#wallet" class="waves-effect waves-dark">Wallet</a>
         </li>
         <li>
            <a href="#booking" class="waves-effect waves-dark">Booking</a>
         </li>
         <li>
            <a href="#account" class="waves-effect waves-dark">Account</a>
         </li>
      </ul>

	  <!-- Card Panel [Author: Akash Chandra]-->
	  <div class="row">
		  <div class="col s12 m6 l3">
			  <div class="card-panel blue darken-3 z-depth-2">
				  <div class="row">
				  	<div class="col s3">
				  		<i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">account_balance_wallet</i>
				  	</div>
					<div class="col s9">
						<div class="card-content white-text">
							<h4>Wallet</h4>
							<% if(Integer.parseInt(userWallet)>=1000)	{ %>
							<p>You have <b><%= userWallet %> Rs</b> remaining in your wallet balance</p>
							<%
								}
								else	{
							%>
							<p>You have <b><%= userWallet %> Rs</b> remaining, please recharge your account</p>	
							<%
								}
							%>
						</div>
					</div>
				  </div>
			  </div>
		  </div>
		  <div class="col s12 m6 l3">
			  <div class="card-panel blue darken-3 z-depth-3">
				  <div class="row">
					<div class="col s3">
						<i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">bookmark</i>
					</div>
					<div class="col s9">
						<div class="card-content white-text">
							<h4>Booking</h4>
							<% if(userLog.isUserIdPresent(id))	{ %>
							<p>Pick up your car from <b><%= carPickupLocation %></b> at <b><%= carPickupTime %></b></p>
							<%
								}
								else	{
							%>
							<p>No current booking</p>	
							<%
								}
							%>
						</div>
					</div>
				  </div>
			  </div>
		  </div>
		  <div class="col s12 m6 l3">
			  <div class="card-panel blue darken-3 z-depth-3">
				  <div class="row">
					<div class="col s3">
						<i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">local_offer</i>
					</div>
					<div class="col s9">
						<div class="card-content white-text">
							<h4>Offer</h4>
							<p>Refer a friend to get <b>70% off</b> on a booking <b>use GET70OFF</b></p>
						</div>
					</div>
				  </div>
			  </div>
		  </div>
		  <div class="col s12 m6 l3">
			  <div class="card-panel blue darken-3 z-depth-3">
				  <div class="row">
				  	<div class="col s3">
				  		<i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">people</i>
				  	</div>
					<div class="col s9">
						<div class="card-content white-text">
							<h4>Refer</h4>
							<p>Refer your friend to get <b>70%</b> discount</p>
						</div>
					</div>
				  </div>
			  </div>
		  </div>
	  </div>

      <footer>
         <div class="footer-copyright indigo lighten-4" style="padding-top: 20px; padding-bottom: 1px;">
            <div class="container">
               <div class="row">
                  <div class="col">
                     &copy RentoCar 2018-2019
                  </div>
                  <div class="col right">
                     <a href="#!" class="">Contact Us</a>
                  </div>
               </div>
            </div>
         </div>
      </footer>
      <!-- JQuery -->
      <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
      <!-- Compiled and minified JavaScript -->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
      <!-- Initializing all the materialize elements -->
      <script type="text/javascript">
         $(document).ready(
         	()=>	{
         		// Sidenav initialization
            	$('.sidenav').sidenav();

         		// Slider initialization and params setting
         		$('.slider').slider(
         			{
         				indicators: false,
         				height: 450,
         				interval: 3000
         			}
         		);

				//Dropdown initialization
				$('.dropdown-trigger').dropdown();

         		// Modal initialization
         		$('.modal').modal();

         		// Form initialization
         		$('select').formSelect();

         		// $('.datepicker').datepicker();
         		// $('.timepicker').timepicker();
          	}
         );
      </script>
      
      <%
      	}
		else	{
			response.sendRedirect("index.html");
		}
		%>

</body>
</html>