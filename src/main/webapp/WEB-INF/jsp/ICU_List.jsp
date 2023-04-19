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


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
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
<jsp:include page="JumboTrane.jsp" />
	<jsp:include page="Navbar.jsp" />

	<div class="container">
		<h3 class="text-center">ICU Details</h3>


		<table class="table table-hover">
			<thead>
				<tr class="text-white" style="background-color: rgb(239, 149, 85);">
					<th>ID</th>
					<th>Doctor Name</th>
					<th>Patient Name</th>
					<th>Date</th>
					<th>Bed Number</th>
					<th>Bed Status</th>
					<th>Discharge type</th>
					<th>Fees</th>
					<th>City</th>
					<th>Contact</th>
					<th colspan="3" class="text-center" style="color:Tomato;">Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td style="background-color: rgb(166, 243, 119);">${emp.icuID}</td>
						<td>${emp.doctorName}</td>
						<td>${emp.patientName}</td>
						<td>${emp.appDate}</td>
						<td>${emp.bedNumber}</td>
						<td>${emp.icuBedStatus}</td>
						<td>${emp.dischargeStatus}</td>
						<td>${emp.fees}</td>
						<td>${emp.city}</td>
						
						<td>${emp.contact}</td>
						<td><a href="/freeBed/${emp.bedNumber}">Free It</a></td>
						<td><a href="/upddateByBedNumber/${emp.bedNumber}">Update Info</a></td>
						<%-- <td><a href="/dischargeByBedNumber/${emp.bedNumber}">Discharge a patient</a></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
<jsp:include page="FooterPage.jsp" />
</body>

</html>