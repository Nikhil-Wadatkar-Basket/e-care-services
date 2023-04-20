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

<jsp:include page="JumboTrane.jsp" />
	<jsp:include page="Navbar.jsp" />

	<div class="container">
		<h3>Update Patient</h3>

		<form:form method="POST" action="/updatePatient"
			modelAttribute="patient">
			<table>
				<tr>
					<td></td>
					<td><form:hidden path="patientID" /></td>
				</tr>

				<tr>
					<td>Patient Name:</td>
					<td><form:input path="patientName" /></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><form:input path="patientAge" /></td>
				</tr>
				<tr>
					<td>Contact :</td>
					<td><form:input path="contact" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><form:input path="city" /></td>
				</tr>
				<tr>
					<td>Doctor Name :</td>
					<td><form:select path="doctorName">
							<%-- <form:option value="NONE" label="Select" /> --%>
							<form:options items="${doctorList}" />
						</form:select></td>
				</tr>
				<tr>
					<td>Date :</td>
					<td><form:input type="date" path="appDate" /></td>
				</tr>
				<tr>
					<td><form:label path="patientType">Patient Type</form:label></td>
					<td><form:radiobutton path="patientType" value="OPD"
							label="OPD" /> <form:radiobutton path="patientType" value="IPD"
							label="IPD" /> <form:radiobutton path="patientType" value="ICU"
							label="ICU" /></td>
				</tr>
				<tr>
					<td><form:label path="appTime">Time</form:label></td>
					<td><form:select path="appTime">
							<form:option value="NONE" label="Select" />
							<form:options items="${freeTimeSlots}" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="bloodGroup">Blood Group</form:label></td>
					<td><form:select path="bloodGroup">
							<form:option value="NONE" label="Select" />
							<form:options items="${bloodGroups}" />
						</form:select></td>

				</tr>
				<tr>
					<td>Weight :</td>
					<td><form:input path="weight" /></td>
				</tr>
				<tr>
					<td>Height :</td>
					<td><form:input path="height" /></td>
				</tr>
				<tr>
					<td>BP:</td>
					<td><form:input path="bp" /></td>
				</tr>
				<tr>
					<td>Sugar:</td>
					<td><form:input path="sugar" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update Patient" /></td>
				</tr>
			</table>
		</form:form>
	</div>
<jsp:include page="FooterPage.jsp" />
</body>

</html>