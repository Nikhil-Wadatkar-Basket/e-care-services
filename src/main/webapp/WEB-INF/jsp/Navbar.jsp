<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>E-Care App Navbar</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
</head>

<body>
	<div class="container-fluid">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link" href="#">Active</a>
			</li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">APPOINTMENTS</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="/loadNewAppointmentPage">New
						Appointments</a> <a class="dropdown-item" href="/getAppointmentsList">All
						Appointments</a> <a class="dropdown-item"
						href="/DeleteAppointmentsPage">Delete Appointment</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Separated link</a>
				</div></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">REPORTS</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="#">Monthly Reports</a> 
					<a class="dropdown-item" href="#">Weekly Reports</a> 
					
					
				</div></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">DOCTORS</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="/loadNewDoctorPage">New Doctor</a> 
					<a class="dropdown-item" href="/showDoctors">All
						Doctors</a> <a class="dropdown-item"
						href="/DeleteDoctorPage">Delete Doctor</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Separated link</a>
				</div></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">PATIENTS</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="/loadNewPatientPage">New Patient</a> 
					<a class="dropdown-item" href="/showPatients">All
						Patients</a> <a class="dropdown-item"
						href="/DeletePatientPage">Delete Patient</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Separated link</a>
				</div></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">MEDICINES</a>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="/loadNewMedicinePage">New Medicine</a> 
					<a class="dropdown-item" href="/showMedicines">All
						Medicines</a> <a class="dropdown-item"
						href="/DeleteMedicinePage">Delete Medicine</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Separated link</a>
				</div></li>
			
			<li class="nav-item"><a class="nav-link" href="/showDoctors">Doctors</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>
		</ul>
	</div>


</body>

</html>