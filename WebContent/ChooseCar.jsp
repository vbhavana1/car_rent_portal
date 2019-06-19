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
<title>RentoCar: Choose Car</title>
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
	
	<!-- Navigation -->
	<div class="navbar-fixed">
		<nav class="nav-wrapper indigo darken-3">
			<div class="container">
				<a class="sidenav-trigger" href="#" data-target="menu-link"> <i
					class="material-icons">menu</i>
				</a>
				<div class="brand-logo">
					<a href="#"> RentoCar </a>
				</div>
				<ul class="right hide-on-med-and-down">
					<li><a href="#modalwallet"
						class="waves-effect waves-light modal-trigger">Wallet</a></li>
					<li><a href="#booking"
						class="waves-effect waves-dark dropdown-trigger"
						data-target="booking_dropdown">Booking</a></li>
					<!-- Booking Dropdown -->
					<ul id="booking_dropdown" class="dropdown-content">
						<li><a href="RentCar.jsp" class="indigo-text">Rent a car</a></li>
<!-- 						<li><a href="CurrentBooking.jsp" class="indigo-text">Current -->
<!-- 								Booking</a></li> -->
						<li><a href="History.jsp" class="indigo-text">History</a></li>
					</ul>
					<li><a href="#username"
						class="waves-effect waves-dark dropdown-trigger"
						data-target="account_dropdown"> <i class="material-icons">person_outline</i>
					</a></li>
					<!-- Account Dropdown -->
					<ul id="account_dropdown" class="dropdown-content">
						<li><a class="indigo-text">Hi <%=userFirstName%></a></li>
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
				<div class="background indigo accent-4"></div>
				<a href="#user"> <img src="images/user_profile.png"
					class="circle">
				</a> <a href="#name"><span class="name white-text"><%=userFirstName%></span></a>
				<a href="#email"><span class="email white-text"><%=userEmail%></span></a>
			</div>
		</li>
		<li><a href="#modalwallet"
			class="waves-effect waves-light modal-trigger">Wallet</a></li>
		<li>
			<ul class="collapsible" id="collapsibleBooking"
				style="margin-left: 5%;">
				<li>
					<div class="collapsible-header">Booking</div>
					<div class="collapsible-body">
						<a href="RentCar.jsp"
							class="waves-effect waves-light modal-trigger"
							style="margin-left: 5%;">Rent a Car</a>
					</div>
<!-- 					<div class="collapsible-body"> -->
<!-- 						<a href="CurrentBooking.jsp" -->
<!-- 							class="waves-effect waves-light modal-trigger" -->
<!-- 							style="margin-left: 5%;">Current Booking</a> -->
<!-- 					</div> -->
					<div class="collapsible-body">
						<a href="History.jsp"
							class="waves-effect waves-light modal-trigger"
							style="margin-left: 5%;">History</a>
					</div>
				</li>
				<!--             <a href="#booking" class="waves-effect waves-dark"></a> -->
			</ul>
		</li>
		<li>
			<ul class="collapsible" id="collapsibleAccount"
				style="margin-left: 5%;">
				<li>
					<div class="collapsible-header">Account</div>
					<div class="collapsible-body">
						<a href="user_profile" class="waves-effect "
							style="margin-left: 5%;">Profile</a>
					</div>
					<div class="collapsible-body">
						<a href="logout" class="waves-effect " style="margin-left: 5%;">Logout</a>
					</div> <!-- 					  <li><a href="logout" class="indigo-text">Logout</a></li> -->
				</li>
			</ul>
		</li>
	</ul>

     <div class="row">
         <div class="col s12 m6 l3 ">
            <div class="card amber lighten-5 z-depth-3 card-style">
               <div class="card-image waves-effect waves-block waves-light">
                  <img class="activator" src="images/mini_car.jpg">
               </div>
               <div class="card-content">
                  <span class="card-title activator grey-text text-darken-4">Mini Cars<i class="material-icons right">more_vert</i></span>
                  <p><a href="#" class="minicar">See all Mini cars</a></p>
               </div>
               <div class="card-reveal indigo lighten-3">
                  <span class="card-title grey-text text-darken-4 mininame">mini<i class="material-icons right">close</i></span>
                  <p>Affordable, distance and power in a mini package. Good for long distance travel purposes.</p>
               </div>
            </div>
         </div>
         <div class="col s12 m6 l3">
            <div class="card amber lighten-5 z-depth-3">
               <div class="card-image waves-effect waves-block waves-light">
                  <img class="activator" src="images/micro_car.jpg">
               </div>
               <div class="card-content">
                  <span class="card-title activator grey-text text-darken-4">Micro Cars<i class="material-icons right">more_vert</i></span>
                  <p><a href="#" class="microcar">See all Micro cars</a></p>
               </div>
               <div class="card-reveal indigo lighten-3">
                  <span class="card-title grey-text text-darken-4 microname">micro<i class="material-icons right">close</i></span>
                  <p>Affordable, distance with more power and more seats. Good for long distance travel purpose and extra comfortable.</p>
               </div>
            </div>
         </div>
         <div class="col s12 m6 l3">
            <div class="card amber lighten-5 z-depth-3">
               <div class="card-image waves-effect waves-block waves-light">
                  <img class="activator" src="images/deluxe_car.jpg">
               </div>
               <div class="card-content">
                  <span class="card-title activator grey-text text-darken-4">Deluxe Cars<i class="material-icons right">more_vert</i></span>
                  <p><a href="#" class="deluxecar">See all Deluxe cars</a></p>
               </div>
               <div class="card-reveal indigo lighten-3">
                  <span class="card-title grey-text text-darken-4 deluxename">deluxe<i class="material-icons right">close</i></span>
                  <p>Expensive, classy cars for those who prefer on looks. Good for short distance rides.</p>
               </div>
            </div>
         </div>
         <div class="col s12 m6 l3">
            <div class="card amber lighten-5 z-depth-3">
               <div class="card-image waves-effect waves-block waves-light">
                  <img class="activator" src="images/suv_car.jpg">
               </div>
               <div class="card-content">
                  <span class="card-title activator grey-text text-darken-4">SUV Cars<i class="material-icons right">more_vert</i></span>
                  <p><a href="#" class="suvcar">See all SUV cars</a></p>
               </div>
               <div class="card-reveal indigo lighten-3">
                  <span class="card-title grey-text text-darken-4 " id="suv">suv<i class="material-icons right">close</i></span>
                  <p>For those who likes to ride power. When you need space, power and comfort at one place.</p>
               </div>
            </div>
         </div>
      </div>
      
      
     
      
      
      
      <div class="row" id="dynamicrow">
      
      
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
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
          	
         		 //sidenav collapsible initialization
         		 $('#collapsibleBooking').collapsible();
         		 $('#collapsibleAccount').collapsible();
         		 
         		
         		
         		
         		
         	<!-- Author Dheeraj Joshi-->
         	
         		 $(".minicar").click(function(e){
         	          e.preventDefault();
         	         $('#dynamicrow').empty();
         	        var carhead=$('<h4>Mini Cars</h4>');    	          
         	       $('#dynamicrow').append(carhead);
         	        $.ajax({type: "POST",
         	                url: "getcar",
         	               dataType: 'json',
         	                data: { carname: "mini"},
         	                success:function(result){ $.each(result, function(index, element) {
     console.log("got it");
         	          
     
     
         	                
         	                		  var newcar=   $('<div class="col s12 m6 l3"><div class="card amber lighten-5 z-depth-3 card-style"><div class="card-image waves-effect waves-block waves-light"><img class="activator" src='+element.img_path+'></div><div class="card-content"><span class="card-title activator grey-text text-darken-4">'+element.name+'<form action="Booking.jsp" method="post"><input type="hidden" name="carid" class="right sendid" value="'+element.id+'"><input type="submit" style="background:none;border:none;color:blue;" value="Book"></form></span></div><div class="card-reveal indigo lighten-3"><span class="card-title grey-text text-darken-4">'+element.name+'<i class="material-icons right">close</i></span><p>'+element.description+'<br><br>Cost:'+element.cost+'Rs'+'<br>Milegae:'+element.mileage+'<br>Seaters:'+element.seats+'</p></div></div></div>');
         	                		
         	                		  $('#dynamicrow').append(newcar); 
         	                
         	                })}});
         	                 	      });
         	                 	
         	                
         	
         		 

         		 $(".microcar").click(function(e){
         	          e.preventDefault();
         	         $('#dynamicrow').empty();
         	        var carhead=$('<h4>Micro Cars</h4>');    	          
          	       $('#dynamicrow').append(carhead);
         	          
         	        $.ajax({type: "POST",
         	                url: "getcar",
         	               dataType: 'json',
         	                data: { carname:"micro"},
         	                success:function(result){ $.each(result, function(index, element) {
     console.log("got it");
         	          
         	                
         	                		  var newcar=   $('<div class="col s12 m6 l3"><div class="card amber lighten-5 z-depth-3 card-style"><div class="card-image waves-effect waves-block waves-light"><img class="activator" src='+element.img_path+'></div><div class="card-content"><span class="card-title activator grey-text text-darken-4">'+element.name+'<form action="Booking.jsp" method="post"><input type="hidden" name="carid" class="right sendid" value="'+element.id+'"><input type="submit" style="background:none;border:none;color:blue;" value="Book"></form></span></div><div class="card-reveal indigo lighten-3"><span class="card-title grey-text text-darken-4">'+element.name+'<i class="material-icons right">close</i></span><p>'+element.description+'<br><br>Cost:'+element.cost+'Rs'+'<br>Mileage'+element.mileage+'<br>Seaters:'+element.seats+'</p></div></div></div>');
         	                		 $('#dynamicrow').append(newcar); 
         	                
         	                })}});
         	                 	      });

    		 $(".deluxecar").click(function(e){
    	          e.preventDefault();
    	          $('#dynamicrow').empty();
    	          var carhead=$('<h4>Deluxe Cars</h4>');    	          
        	       $('#dynamicrow').append(carhead);
    	        $.ajax({type: "POST",
    	                url: "getcar",
    	               dataType: 'json',
    	                data: { carname: "deluxe"},
    	                success:function(result){ $.each(result, function(index, element) {
console.log("got it");
    	          
    	                
    	                		  var newcar=   $('<div class="col s12 m6 l3"><div class="card amber lighten-5 z-depth-3 card-style"><div class="card-image waves-effect waves-block waves-light"><img class="activator" src='+element.img_path+'></div><div class="card-content"><div class="card-title activator grey-text text-darken-4">'+element.name+'<form action="Booking.jsp" method="post"><input type="hidden" name="carid" class="right sendid" value="'+element.id+'"><input type="submit" style="background:none;border:none;color:blue;" value="Book"></form></div></div><div class="card-reveal indigo lighten-3"><span class="card-title grey-text text-darken-4">'+element.name+'<i class="material-icons right">close</i></span><p>'+element.description+'<br><br>Cost:'+element.cost+'Rs'+'<br>Mileage:'+element.mileage+'<br>Seaters:'+element.seats+'</p></div></div></div>');
    	                		 $('#dynamicrow').append(newcar); 
    	                
    	                })}});
    	                 	      });
    	                 	
         	
		

     		 $(".suvcar").click(function(e){
     	          e.preventDefault();
     	         $('#dynamicrow').empty();
     	        var carhead=$('<h4>Suv Cars</h4>');    	          
      	       $('#dynamicrow').append(carhead);
     	        $.ajax({type: "POST",
     	                url: "getcar",
     	               dataType: 'json',
     	                data: { carname: "suv"},
     	                success:function(result){ $.each(result, function(index, element) {
 console.log("got it");
     	                
     	                		  var newcar=   $('<div class="col s12 m6 l3"><div class="card amber lighten-5 z-depth-3 card-style"><div class="card-image waves-effect waves-block waves-light"><img class="activator" src='+element.img_path+'></div><div class="card-content"><span class="card-title activator grey-text text-darken-4">'+element.name+'<form action="Booking.jsp" method="post"><input type="hidden" name="carid" class="right sendid" value="'+element.id+'"><input type="submit" style="background:none;border:none;color:blue;" value="Book"></form></div><div class="card-reveal indigo lighten-3"><span class="card-title grey-text text-darken-4">'+element.name+'<i class="material-icons right">close</i></span><p>'+element.description+'<br><br>Cost:'+element.cost+'Rs'+'<br>Mileage:'+element.mileage+'<br>Seaters:'+element.seats+'</p></div></div></div>');
     	                		 $('#dynamicrow').append(newcar); 
     	                
     	                })}});
     	                 	      });
     		 
     		
     		 
     	
     		
     		
     		
//      		$(document).on("click",".sendid", function (e) {
// sessionStorage.setItem("carid",$('.sendid').attr("id"));
// window.location.replace("Booking.jsp");
// console.log($('.sendid').attr("id"));
//      		});
     		
     		
     		
         	
         	} );
      </script>

	<%
		} else {
			response.sendRedirect("Index.jsp");
		}
	%>
</body>
</html>