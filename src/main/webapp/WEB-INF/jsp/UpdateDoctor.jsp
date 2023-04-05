<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>E-Care App</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>

	<%-- 
	<%@include file="Navbar.jsp" %>
	 --%>
	<jsp:include page="Navbar.jsp" />


	<div class="container">
		<h3>Update Doctor</h3>


		<form:form method="POST" action="/updateDoctor" modelAttribute="doc">
			<table>
				<tr>
					<td></td>
					<td><form:hidden path="docID" /></td>
				</tr>
				<tr>
					<td>Doctor Name :</td>
					<td><form:input path="docName" /></td>
				</tr>
				<tr>
					<td>Designation :</td>
					<td><form:input path="designation" /></td>
				</tr>
				<tr>
					<td>Contact :</td>
					<td><form:input path="docContact" /></td>
				</tr>


				<tr>
					<td></td>
					<td><input type="submit" value="Update" /></td>
				</tr>
			</table>
		</form:form>
	</div>
<jsp:include page="FooterPage.jsp" />
</body>

</html>