<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>E-Care App</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />

	<!-- glyph -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>

<body  
 

>
	 <!-- Jumbotron  code start-->
    <jsp:include page="JumboTrane.jsp" />

    <!-- Jumbotron  code end -->
	<jsp:include page="Navbar.jsp" />

	 <!-- navbar code start -->
 
	 <!-- navbar code end -->



	

		
	

	<div class="container" style="background-color: white;">
		<div class="row justify-content-center">
    <h1>Dashboard</h1>
  </div>
		
		<div class="row">
			
			
			<div class="col-md-3">
				<div class="card text-white bg-primary mb-3"
					style="max-width: 18rem;">
					<div class="card-header"><i class='far fa-calendar-alt' style='font-size:36px'></i></div>
					<div class="card-body">
						<h5 class="card-title">APPOINTMENTS</h5>
						<p>Click to see Appointment related facilities</p>
						<a class="btn btn-info btn-light" href="/AppointmentDashboard">All
							Appointments</a>
					</div>
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="card bg-warning mb-3" style="max-width: 18rem;">
					<div class="card-header"><i class='fas fa-calendar-plus' style='font-size:36px'></i></div>
					<div class="card-body">
						<h5 class="card-title">Pharmacy</h5>
						<p>Click here to see Pharmacy related facilities</p>
						<a class="btn btn-info btn-light" href="/MedicineDashboard">Check</a>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card text-white bg-danger mb-3"
					style="max-width: 18rem;">
					<div class="card-header"><i class='fas fa-child' style='font-size:36px'></i></div>
					<div class="card-body">
						<h5 class="card-title">Doctors</h5>
						<p>Click to see Appointment related facilities</p>
						<a class="btn btn-info btn-light" href="/DoctorDashboard">Doctors
							Section</a>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
					<div class="card-header"><i class='fab fa-accessible-icon' style='font-size:36px'></i></div>
					<div class="card-body">
						<h5 class="card-title">PATIENTS</h5>
						<p>Click here to see Patients related facilities</p>
						<a class="btn btn-info btn-light" href="/PatientDashboard">Patient
							Section</a>
					</div>
				</div>
			</div>
		</div>

		<br></br> <br></br>

		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
						<div class="card-header">
							<i class='fas fa-clinic-medical' style='font-size:36px'></i>
						</div>
						<div class="card-body">
							<h5 class="card-title">MEDICINE COUNTER</h5>
							<p>Click here to see Medicine facilities</p>
							<a class="btn btn-info btn-light"
								href="/MedicineCounterDashboard">Medicine Counter</a>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card text-white bg-success mb-3"
						style="max-width: 18rem;">
						<div class="card-header"><i class='far fa-id-badge' style='font-size:36px'></i></div>
						<div class="card-body">
							<h5 class="card-title">Visiting Doctor's Club</h5>
							<p>Click here to see visiting doctors info</p>
							<a class="btn btn-info btn-light" href="/VisitorsDoctorDashboard">Click
								to see</a>
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="card text-white bg-warning mb-3"
						style="max-width: 18rem;">
						<div class="card-header"><i class='fas fa-clipboard' style='font-size:36px'></i></div>
						<div class="card-body">
							<h5 class="card-title">FEEDBACK</h5>
							<p>Click here to provide your valuable feedback.</p>
							<a class="btn btn-info btn-light" href="/newFeedbackPage">Give
								Feedback</a>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card bg-light mb-3" style="max-width: 18rem;">
						<div class="card-header"><i class='far fa-calendar-check' style='font-size:36px'></i></div>
						<div class="card-body">
							<h5 class="card-title">Show Feedbacks</h5>
							<p>Click here to see all provided feedbacks</p>
							<a class="btn btn-info btn-light" href="/feedbacks">Show
								Feedbacks</a>
						</div>
					</div>
				</div>

				
			</div>
		</div>

		<jsp:include page="FooterPage.jsp" />
</body>
</html>