<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>E-Care App</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
	
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>

<body>

	<jsp:include page="Navbar.jsp" />

	<div class="container">
		<h3>Appointments</h3>

		<!-- <div class="table-responsive"> -->
			<table class="table  table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th class="col-xs-1">Doctor Name</th>
						<th class="col-xs-1">Patient Name</th>
						<th class="col-xs-1">Date</th>
						<th class="col-xs-1">Time</th>
						<th class="col-xs-1">Time Status</th>
						<th style="width:10%">Meeting type</th>
						<th style="width:10%">Fees</th>
						<th style="width:10%">City</th>
						<th style="width:10%">Blood group</th>
						<th style="width:10%">Age</th>						
						<th style="width:10%">Contact</th>
						<th colspan="2" class="text-center" style="color:Tomato;">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${empList}">
						<tr>
							<td>${emp.appID}</td>
							<td>${emp.doctorName}</td>
							<td>${emp.patientName}</td>
							<td>${emp.appDate}</td>
							<td>${emp.appTime}</td>
							<td>${emp.appTimeStatue}</td>
							<td>${emp.meetingType}</td>
							<td>${emp.fees}</td>
							<td>${emp.city}</td>
							<td>${emp.bloodGroup}</td>
							<td>${emp.age}</td>							
							<td>${emp.contact}</td>
							<td><a href="/getAppointmentByTime/${emp.appTime}">Edit</a></td>
							<td><a href="/deleteAppointmentByTime/${emp.appTime}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<!-- </div> -->
	</div>
	</div>

<jsp:include page="FooterPage.jsp" />
</body>

</html>