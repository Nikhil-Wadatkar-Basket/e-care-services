<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>E-Care App Navbar</title>
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
</head>

<body>
	<!-- <div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">E-Care Application</h1>
			<p class="lead">This is a modified jumbotron that occupies the
				entire horizontal space of its parent.</p>
		</div>
	</div> -->
	<jsp:include page="JumboTrane.jsp" />
	<div class="container-fluid">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link" href="/Dashboard">Dashboard</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">APPOINTMENTS</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="/loadNewAppointmentPage">New
						Appointments</a> <a class="dropdown-item" href="/getAppointmentsList">All
						Appointments</a> <a class="dropdown-item"
						href="/DeleteAppointmentsPage">Delete Appointment</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">REPORTS</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="#">Monthly Reports</a> <a
						class="dropdown-item" href="#">Weekly Reports</a>


				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">DOCTORS</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="/loadNewDoctorPage">New Doctor</a> <a
						class="dropdown-item" href="/showDoctors">All Doctors</a> <a
						class="dropdown-item" href="/DeleteDoctorPage">Delete Doctor</a>

				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">Emergency</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="/getICUList">Load Free Beds</a> <a
						class="dropdown-item" href="/loadICUPage">Book a Bed</a> <a
						class="dropdown-item" href="/DeleteDoctorPage">Delete Doctor</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">PATIENTS</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="/loadNewPatientPage">New Patient</a>
					<a class="dropdown-item" href="/showPatients">All Patients</a> <a
						class="dropdown-item" href="/DeletePatientPage">Delete Patient</a>

				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">MEDICINES</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="/loadNewMedicinePage">New
						Medicine</a> <a class="dropdown-item" href="/showMedicines">All
						Medicines</a> <a class="dropdown-item" href="/DeleteMedicinePage">Delete
						Medicine</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/donateMedicine">Donate Medicine</a>
				</div></li>

			<li class="nav-item"><a class="nav-link" href="/showDoctors">Doctors</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>

			<li><span class="navbar-brand"></span> <a
				class="btn navbar-btn btn-danger navbar-right pull-right"
				role="button" href="/login">Logout</a></li>

		</ul>
	</div>

	<br></br>

</body>

</html>