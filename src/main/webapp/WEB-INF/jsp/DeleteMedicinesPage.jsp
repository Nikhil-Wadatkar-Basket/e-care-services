<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		<h3>Medicines</h3>
		<c:choose>

			<c:when test="${fn:length(empList) eq 0}">
					<div class="well well-lg">
					<div class="alert alert-danger" role="alert">
						<h4 class="alert-heading">Sorry!!! No Medicine in records!</h4>
						<p>We dont'have any medicine in our records. Please click on
							below to add a medicine</p>
						<hr>
						<p class="mb-0">
							<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onClick="location.href='/Dashboard'">Close</button>
							<a class="btn btn-info btn-light" href="/loadNewMedicinePage">Add
								Medicine</a>
						</p>
					</div>
				</div>
				
					

				<script>
					$(document).ready(function() {
						$("#exampleModalCenter").modal();
					});
				</script>


			</c:when>
			<c:otherwise>
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Medicine Name</th>
								<th>Stock</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="emp" items="${empList}">
								<tr>
									<td>${emp.medicineID}</td>
									<td>${emp.medicineName}</td>
									<td>${emp.stock}</td>
									<td><a href="getMedicineByID/${emp.medicineID}">Edit</a></td>
									<td><a href="deleteMedicine/${emp.medicineID}">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true" style="display: none">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><h3>Medicines List</h3></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">We dont'have any Medicine registered
					yet. Please click on below to register a mediciner</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onClick="location.href='/Dashboard'">Close</button>
					<a class="btn btn-info btn-light" href="/loadNewMedicinePage">Add
						Medicine</a>
					<!-- <button type="button" class="btn-primary">Save changes</button> -->
				</div>
			</div>
		</div>
	</div>
<jsp:include page="FooterPage.jsp" />
</body>

</html>