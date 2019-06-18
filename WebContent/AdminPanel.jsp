<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ 
	page
	import="
		com.rent.car.controller.UserController, 
		com.rent.car.controller.BookingController, 
		com.rent.car.controller.UserLogController,
		com.rent.car.controller.CarController,
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
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<title>RentoCar: Admin Panel</title>
</head>
	<%
		String id = (String) request.getSession().getAttribute("session_id");
		UserController user = (UserController) request.getSession().getAttribute("user_controller");

		if (id != null && !user.getFirstName(id).equals("")) {
			// Getting the necessary objects from session
			UserLogController userLog = (UserLogController) request.getSession().getAttribute("user_log_controller");
			BookingController booking = (BookingController) request.getSession().getAttribute("booking_controller");
			CarController car = (CarController) request.getSession().getAttribute("car_controller");

			// Using the necessary objects
			String userFirstName = user.getFirstName(id);
			String userEmail = user.getEmail(id);
	%>

   <body class="indigo lighten-5">
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

      <!-- tabs starting here-->
      <div class="row">
         <div class="col s12">
            <ul class="tabs blue accent-1">
               <li class="tab col s3 l4"><a class="active black-text" href="#test2">CAR ACTION</a></li>
               <li class="tab col s3 l4"><a href="#test3"class="black-text">Statistics</a></li>
               <li class="tab col s3 l4"><a href="#test4"class="black-text">TICKETS</a></li>
            </ul>
         </div>
         <!-- First Tab content -->
         <div id="test2" class="col s12">
            <!-- Card Panel [Author: Akash Chandra]-->
            <div class="row">
               <div class="col s12 m6 l4">
                  <div class="card-panel blue darken-3 z-depth-2 addcard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">add_box</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h4>Add Car</h4>
                              <p>There are currently <b>1004</b>Cars we have </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col s12 m6 l4">
                  <div class="card-panel blue darken-3 z-depth-3 updatecard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">edit</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h4>Update Car</h4>
                              <p>At the moment <b>5000</b> had rented our Car </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col s12 m6 l4">
                  <div class="card-panel blue darken-3 z-depth-3 deletecard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">delete</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h4>Delete Car</h4>
                              <p>There are currently  <b>4000</b>  </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <!-- ADD CAr Form  Author Dheeraj Joshi-->
            <div class="container addcarform " >
               <div class="card">
                  <div class="row">
                     <form class="col s12 ">
                        <div class="container">
                           <h3 class="indigo-text">ADD Car</h3>
                           <div class="row">
                              <div class="col s12">
                                 <div class="row">
                                    <div class="col s12 input-field">
                                       <i class="material-icons prefix">mode_edit</i>
                                       <input id="car_name" type="text" class="validate">
                                       <label for="car_name">Car Name</label>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="col s12 input-field">
                                       <i class="material-icons prefix">directions_car</i>
                                       <input id="car_no" type="text" class="validate">
                                       <label for="car_no">Enter Car Number</label>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="col s12 input-field">
                                       <i class="material-icons prefix">ev_station</i>
                                       <input id="mileage" type="text" class="validate">
                                       <label for="mileage">Mileage</label>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="input-field col s12">
                                       <select>
                                          <option value="" disabled selected>Choose your option</option>
                                          <option value="1">Micro</option>
                                          <option value="2">Mini</option>
                                          <option value="3">SUV</option>
                                          <option value="4">Deluxe</option>
                                       </select>
                                       <label>Select Car Type</label>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="col s12 input-field" style="margin-left:1%;">
                                       <!-- Dropdown Trigger -->
                                       <div class="file-field input-field">
                                          <div class="btn indigo">
                                             <span class="">File</span>
                                             <input type="file">
                                          </div>
                                          <div class="file-path-wrapper">
                                             <input class="file-path validate" type="text">
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <a class="waves-effect waves-light btn indigo">Add Car</a>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
            <!--  Update car form-->
            <div class="container updatecarform" style="display:none">
               <div class="card">
                  <div class="row">
                     <form class="col s12">
                        <div class="container">
                           <h3 class="indigo-text">update car</h3>
                           <div class="row">
                              <div class="col s12">
                                 <div class="row">
                                    <div class="col s12 input-field">
                                       <i class="material-icons prefix">mode_edit</i>
                                       <input id="car_name" type="text" class="validate">
                                       <label for="car_name">Car Name</label>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="col s12 input-field">
                                       <i class="material-icons prefix">directions_car</i>
                                       <input id="car_no" type="text" class="validate">
                                       <label for="car_no">Enter Car Number</label>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="col s12 input-field">
                                       <i class="material-icons prefix">ev_station</i>
                                       <input id="mileage" type="text" class="validate">
                                       <label for="mileage">Mileage</label>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="input-field col s12">
                                       <select>
                                          <option value="" disabled selected>Choose your option</option>
                                          <option value="1">Micro</option>
                                          <option value="2">Mini</option>
                                          <option value="3">SUV</option>
                                          <option value="4">Deluxe</option>
                                       </select>
                                       <label>Select Car Type</label>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="col s12 input-field" style="margin-left:1%;">
                                       <!-- Dropdown Trigger -->
                                       <div class="file-field input-field">
                                          <div class="btn indigo">
                                             <span>File</span>
                                             <input type="file">
                                          </div>
                                          <div class="file-path-wrapper">
                                             <input class="file-path validate" type="text">
                                          </div>
                                       </div>
                                    </div>
                                 </div>
								 <div class="row">
									<a class="waves-effect waves-light btn indigo">Update Car</a>
								 </div>
                              </div>
                           </div>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
            <!-- DELETE  car form -->
            <div class="container deletecarform" style="display:none">
               <div class="card">
                  <div class="row">
                     <form class="col s12">
                        <div class="container " >
                           <h3 class="indigo-text">Delete car</h3>
                           <div class="row ">
                              <div class="col s12 deleteinput">
                                 <div class="row">
                                    <div class="col s10 m10 l10 input-field " >
                                       <i class="material-icons prefix">directions_car</i>
                                       <input id="car_no" type="text" class="validate" style="margin-top:0px;">
                                       <label for="car_no">Enter Car Number</label>
                                    </div>
                                    <div class="col s2 l2 m2">
                                       <a class="btn-floating btn-small waves-effect waves-light red addbuttondeleteform"><i class="material-icons">add</i></a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
         <!-- Second Tab  Starts Here -->
         <div id="test3" class="col s12">
            <!-- Card Panel [Author: Akash Chandra]-->
            <div class="row">
               <div class="col s12 m6 l4">
                  <div class="card-panel blue darken-3 z-depth-2 userstatcard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">person</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h4>Total Users</h4>
                              <p>There are currently <b>100000 Users</b>using our app </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col s12 m6 l4">
                  <div class="card-panel blue darken-3 z-depth-3 rentedstatecard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">directions_car</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h4>Current Cars Booked</h4>
                              <p>At the moment <b>5000</b> had rented our Car </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col s12 m6 l4">
                  <div class="card-panel blue darken-3 z-depth-3 topcarstatcard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">vertical_align_top</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h4>Top Rented Cars</h4>
                              <p>These Cars are Rented  <b>Most</b> often </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div class="card" >
               <canvas id="myuserstatChart"></canvas>
            </div>
            <div class="card">
               <canvas id="myrentedcarstatChart" style="display:none"></canvas>
            </div>
            <div class="card">
               <canvas id="mytopcarChart" style="display:none"></canvas>
            </div>
         </div>
         <!-- Third Tab Starts here -->
         <div id="test4" class="col s12">
            <!-- Card Panel [Author: Akash Chandra]-->
            <div class="row">
               <div class="col s12 m6 l3">
                  <div class="card-panel blue darken-3 z-depth-2 paymentissuecard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">sync_problem</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h5>Payment Issue</h5>
                              <p>There are currently <b>100</b>payment related tickets generated </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col s12 m6 l3">
                  <div class="card-panel blue darken-3 z-depth-3 accidentissuecard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">warning</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h5>Accidental Issue</h5>
                              <p>At the moment there are currently <b>50</b> Accident issue reported </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col s12 m6 l3">
                  <div class="card-panel blue darken-3 z-depth-3 mechanicalissuecard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">settings</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h5> Mechanical Issue</h5>
                              <p>There are currently <b>100</b> Mechanical Issue's </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col s12 m6 l3">
                  <div class="card-panel blue darken-3 z-depth-3 cancellationissuecard">
                     <div class="row">
                        <div class="col s3">
                           <i class="material-icons medium right blue-text text-lighten-2" style="margin-top: 30%">cancel</i>
                        </div>
                        <div class="col s9">
                           <div class="card-content white-text">
                              <h5>Cancellation Issue</h5>
                              <p>There's currently<b>100</b> Cancellation Issue's </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- Payment Ticket collection for admin -->
               <div class="row paymentticket">
                  <div class="container">
                     <ul class="collection ">
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">sync_problem</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">sync_problem</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">sync_problem</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">sync_problem</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                     </ul>
                  </div>
               </div>
               <!-- Accidental Ticket collection for admin -->
               <div class="row accidentticket" style="display:none;">
                  <div class="container">
                     <ul class="collection paymentticket">
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">warning</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">warning</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">warning</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">warning</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                     </ul>
                  </div>
               </div>
               <!-- Mechanical Ticket collection for admin -->
               <div class="row mechanicalticket" style="display:none;">
                  <div class="container">
                     <ul class="collection mechanicalticket">
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">settings</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">settings</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">settings</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">settings</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                     </ul>
                  </div>
               </div>
               <!-- Accidental Ticket collection for admin -->
               <div class="row accidentticket" style="display:none;">
                  <div class="container">
                     <ul class="collection accidentticket">
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">warning</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">warning</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">warning</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">warning</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                     </ul>
                  </div>
               </div>
               <!-- Cancellation Ticket collection for admin -->
               <div class="row cancelticket" style="display:none;">
                  <div class="container">
                     <ul class="collection cancelticket">
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">cancel</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">cancel</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">cancel</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                        <li class="collection-item avatar">
                           <i class="material-icons circle red">cancel</i>
                           <span class="title">Title</span>
                           <p>Problem Statement <br>
                           </p>
                           <a class="btn-floating btn-medium waves-effect waves-light red addbuttondeleteform secondary-content"><i class="material-icons">delete</i></a>
                        </li>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <footer>
         <div class="footer-copyright indigo lighten-3" style="padding-top: 20px; padding-bottom: 1px;">
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
         					    $('.tabs').tabs();

         $('.dropdown-trigger').dropdown();
         $('.dropdown-trigger2').dropdown();
         		// Slider initialization and params setting
         		$('.slider').slider(
         			{
         				indicators: false,
         				height: 450,
         				interval: 3000
         			}
         		);

         // show add car form and hide the cards
         $(".addcard").click(function(){

         $(".addcarform").show("slow");

         $(".updatecarform").hide("slow");
         $(".deletecarform").hide("slow");
         });

         // show update car form and hide the other forms
         $(".updatecard").click(function(){

         $(".addcarform").hide("slow");
         $(".updatecarform").show("slow");
         $(".deletecarform").hide("slow");

         });
         // show delete car form and hide other forms
         $(".deletecard").click(function(){

         $(".addcarform").hide("slow");
         $(".updatecarform").hide("slow");
         $(".deletecarform").show("slow");

         });









         // show total user stats
         $(".userstatcard").click(function(){
         $('html, body').animate({
         scrollTop: $("#myuserstatChart").offset().top
         }, 1000);
         $("#myuserstatChart").show("slow");

         $("#myrentedcarstatChart").hide("slow");
         $("#mytopcarChart").hide("slow");

         });
         // show total car rented stats
         $(".rentedstatecard").click(function(){
         $('html, body').animate({
         scrollTop: $("#myrentedcarstatChart").offset().top
         }, 1000);
         $("#myuserstatChart").hide("slow");

         $("#myrentedcarstatChart").show("slow");
         $("#mytopcarChart").hide("slow");

         });
         // show top car rented stats
         $(".topcarstatcard").click(function(){
         $('html, body').animate({
         scrollTop: $("#mytopcarChart").offset().top
         }, 1000);
         $("#myuserstatChart").hide("slow");

         $("#myrentedcarstatChart").hide("slow");
         $("#mytopcarChart").show("slow");

         });


         // show payment issue collection
         $(".paymentissuecard").click(function(){

         $(".paymentticket").show("slow");

         $(".mechanicalticket").hide("slow");
         $(".accidentticket").hide("slow");
         $(".cancelticket").hide("slow");
         });

         // show accident issue collection
         $(".accidentissuecard").click(function(){

         $(".paymentticket").hide("slow");

         $(".cancelticket").hide("slow");
         $(".accidentticket").show("slow");
         $(".mechanicalticket").hide("slow");
         });

         // show mechanical issue collection
         $(".mechanicalissuecard").click(function(){

         $(".paymentticket").hide("slow");

         $(".accidentticket").hide("slow");

         $(".cancelticket").hide("slow");
         $(".mechanicalticket").show("slow");
         });


         // show cancellation issue collection
         			$(".cancellationissuecard").click(function(){

         				$(".paymentticket").hide("slow");

         				$(".accidentticket").hide("slow");

         			$(".cancelticket").show("slow");
         			$(".mechanicalticket").hide("slow");
         			});

         $(".deletecard").click(function(){
         $(".addcarform").hide("slow");
         $(".updatecarform").hide("slow");

         });
         		// Modal initialization
         		$('.modal').modal();

         		// Form initialization
         		$('select').formSelect();

         		// $('.datepicker').datepicker();
         		// $('.timepicker').timepicker();






         // 	$('.addbuttondeleteform').on('click',function(){
         // 		var inputfield = $('<div class="row"><div class="col s10 m10 l10 input-field"><i class="material-icons prefix ">directions_car</i><input id="car_no" type="text" class="validate"><label for="car_no">Enter Car Number</label></div><div class="col s2 l2 m2"><a class="btn-floating btn-small waves-effect waves-light red addbuttondeleteform"><i class="material-icons ">add</i></a><a class="btn-floating btn-small waves-effect waves-light red addbuttondeleteform"><i class="material-icons addbuttondeleteform">delete</i></a></div></div>');
         // 	$(".deleteinput").append(inputfield);

         // });
         var i=1;
         $(document).on('click',".addbuttondeleteform",function(){


         var inputfield = $('<div class="row delete_'+i+'"><div class="col s10 m10 l10 input-field"><i class="material-icons prefix ">directions_car</i><input id="car_no" type="text" class="validate"><label for="car_no">Enter Car Number</label></div><div class="col s2 l2 m2"><a class="btn-floating btn-small waves-effect waves-light red addbuttondeleteform" id=delete_'+i+' ><i class="material-icons ">add</i></a><a class="btn-floating btn-small waves-effect waves-light red deleteinputfield" id="delete_'+i+'"><i class="material-icons" id="delete_"'+i+'>delete</i></a></div></div>');
         $(".deleteinput").append(inputfield);
         i++;

         });

         $(document).on('click',".deleteinputfield",function(){
         var id = $(this).attr('id');

         $("."+id).remove();

         });
         }
         );
      </script>
      <script>
         // total users rented graph
         	  window.onload = function () {
         		  var ctx = document.getElementById('myuserstatChart').getContext('2d');
         	  var chart = new Chart(ctx, {
         	      // The type of chart we want to create
         	      type: 'line',

         	      // The data for our dataset
         	      data: {
         	          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July','Agust','September'],
         	          datasets: [{
         	              label: 'Car Rented Statistics',
         	              // backgroundColor: 'rgb(255, 99, 132)',
         	              borderColor: 'rgb(255, 99, 132)',
         	              data: [0, 10, 5, 2, 20, 30, 45,7,27]
         	          }]
         	      },

         	      // Configuration options go here
         	      options: {}
         	  });

         // total cars rented graph
         var ctx = document.getElementById('myrentedcarstatChart').getContext('2d');
         var chart = new Chart(ctx, {
         // The type of chart we want to create
         type: 'line',

         // The data for our dataset
         data: {
         	labels: ['Januray', 'February', 'March', 'April', 'May', 'June', 'July','Agust','September'],
         	datasets: [{
         		label: 'Booking Statistics',
         		// backgroundColor: 'rgb(255, 99, 132)',
         		borderColor: 'rgb(122, 99, 132)',
         		data: [0, 10, 5, 2, 20, 30, 45,7,27]
         	}]
         },

         // Configuration options go here
         options: {}
         });



         // Top Cars rented graph
         var ctx = document.getElementById('mytopcarChart').getContext('2d');
         var chart = new Chart(ctx, {
         // The type of chart we want to create
         type: 'line',

         // The data for our dataset
         data: {
         	labels: ['Audi', 'Bmw', 'Mercedes', 'Ferrari'],
         	datasets: [{
         		label: 'Top Cars Rented Graph',
         		// backgroundColor: 'rgb(255, 99, 132)',
         		borderColor: 'rgb(222, 129, 32)',
         		data: [20, 10, 15, 2]
         	}]
         },

         // Configuration options go here
         options: {}
         });



         }


      </script>
   </body>
   	<%
		} else {
			response.sendRedirect("Index.jsp");
		}
	%>
</html>
