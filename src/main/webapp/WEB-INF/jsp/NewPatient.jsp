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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head> -->

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

	<%--  
	
	<%@include file="Navbar.jsp" %>
	--%>
	<jsp:include page="Navbar.jsp" />

	<div class="container">


		<form:form method="POST" action="/createPatient"
			modelAttribute="patient">

			<div class="container">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<h3>New Patient</h3>

						<div class="form-group">
							<label for="exampleFormControlInput1">Patient Name:</label>
							<form:input class="form-control" path="patientName" />
						</div>
						<div class="form-group">
							<label>Age:</label>
							<form:input class="form-control" path="patientAge" />
						</div>
						<div class="form-group">
							<label>Contact:</label>
							<form:input class="form-control" path="contact" />
						</div>
						<div class="form-group">
							<label>city:</label>
							<form:input class="form-control" path="city" />
						</div>
						<div class="form-group">
							<label>Date:</label>
							<form:input class="form-control" type="date" path="appDate" />
						</div>
						<div class="form-group">
							<label>Weight:</label>
							<form:input class="form-control" path="weight" />
						</div>
						<div class="form-group">
							<label>Height:</label>
							<form:input class="form-control" path="height" />
						</div>
						<div class="form-group">
							<label>Bp:</label>
							<form:input class="form-control" path="bp" />
						</div>
						<div class="form-group">
							<label>Sugar:</label>
							<form:input class="form-control" path="sugar" />
						</div>

						<div class="form-group ">
							<form:label path="patientType">Patient Type</form:label>
							<form:radiobutton path="patientType" value="OPD" label="OPD" />
							<form:radiobutton path="patientType" value="IPD" label="IPD" />
							<form:radiobutton path="patientType" value="ICU" label="ICU" />


						</div>

						<div class="form-group">
							<label>Blood Group:</label>
							<form:select class="form-control" path="bloodGroup">
								<form:option value="NONE" label="Select" />
								<form:options items="${bloodGroups}" />
							</form:select>
						</div>

						<div class="form-group">
							<label>Time:</label>
							<form:select class="form-control" path="appTime">
								<form:option value="NONE" label="Select" />
								<form:options items="${freeTimeSlots}" />
							</form:select>
						</div>

						<div class="form-group">
							<label>Doctor:</label>
							<form:select class="form-control" path="doctorName">
								<form:option value="NONE" label="Select" />
								<form:options items="${doctorList}" />
							</form:select>
						</div>

						<div class="form-group">
							<label><input type="submit" value="Create New Patient" /></label>

						</div>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>


			<%-- <table>
				<tr>
					<td></td>
					<td><form:hidden path="patientID" /></td>
				</tr>

				<tr>
					<td><label>Patient Name:</label></td>
					<td><form:input class="form-control" path="patientName" /></td>
				</tr>
				<tr>
					<td><label>Age:</label></td>
					<td><form:input class="form-control" path="patientAge" /></td>
				</tr>
				<tr>
					<td><label>Contact :</td>
					<td><form:input class="form-control" path="contact" /></td>
				</tr>
				<tr>
					<td><label>City:</td>
					<td><form:input class="form-control" path="city" /></td>
				</tr>
				<tr>
					<td><label>Doctor Name :</td>
					<td><form:select class="form-control" path="doctorName">
							<form:option value="NONE" label="Select" />
							<form:options items="${doctorList}" />
						</form:select></td>
				</tr>
				<tr>
					<td><label>Date :</td>
					<td><form:input class="form-control" type="date"
							path="appDate" /></td>
				</tr>
				<tr>
					<td><form:label path="patientType">Patient Type</form:label></td>
					<td><form:radiobutton class="form-control" path="patientType"
							value="OPD" label="OPD" /> <form:radiobutton path="patientType"
							value="IPD" label="IPD" /> <form:radiobutton path="patientType"
							value="ICU" label="ICU" /></td>
				</tr>
				<tr>
					<td><form:label path="appTime">
							<label>Time</label>
						</form:label></td>
					<td><form:select class="form-control" path="appTime">
							<form:option value="NONE" label="Select" />
							<form:options items="${freeTimeSlots}" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="bloodGroup">
							<label><label>Blood Group</label>
						</form:label></td>
					<td><form:select class="form-control" path="bloodGroup">
							<form:option value="NONE" label="Select" />
							<form:options items="${bloodGroups}" />
						</form:select></td>

				</tr>
				<tr>
					<td><label>Weight :</label></td>
					<td><form:input class="form-control" path="weight" /></td>
				</tr>
				<tr>
					<td><label>Height :</label></td>
					<td><form:input class="form-control" path="height" /></td>
				</tr>
				<tr>
					<td><label>BP:</label></td>
					<td><form:input class="form-control" path="bp" /></td>
				</tr>
				<tr>
					<td><label>Sugar:</label></td>
					<td><form:input class="form-control" path="sugar" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create New Patient" /></td>
				</tr>
			</table> --%>
		</form:form>
	</div>
<jsp:include page="FooterPage.jsp" />
</body>

</html>