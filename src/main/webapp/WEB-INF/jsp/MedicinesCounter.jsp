<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
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


<!-- ajax related -->
<!-- <script src="https://code.jquery.com/jquery-3.3.1.min.js"
	
	
    integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script> 
    src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
<body>
	<jsp:include page="Navbar.jsp" />
	<div class="container">
		<h2 align="center">E-Care Medicine Counter</h2>
		<div class="form-group">
			<form name="add_name" id="add_name">
				<div></div>

				<div></div>

				<div class="row">
					<div class="col-md-4">
						PatientName: <input type="text" name="patientName"
							placeholder="Enter your Name" class="form-control name_list"
							required="" />
					</div>
					<div class="col-md-4">
						Doctors Name<input type="text" name="doctorName"
							placeholder="Enter your Name" class="form-control name_list"
							required="" />
					</div>
					<div class="col-md-4">
						Date: <input type="date" name="date" placeholder="Enter your Name"
							class="form-control name_list" required="" />
					</div>
				</div>
				<br></br>
				<div class="row">
					<div class="col-md-4">
						City: <input type="text" name="city" placeholder="Enter City"
							class="form-control name_list" required="" />
					</div>
					<div class="col-md-4">
						Contact:<input type="text" name="contact"
							placeholder="Enter Contact" class="form-control name_list"
							required="" />
					</div>
					<div class="col-md-4"></div>
				</div>
				<br></br>

				<div class="table-responsive">
					<h3>Please add Medicines below:</h3>
					<table class="table table-bordered" id="dynamic_field">
						<tr>
							<td><select name="name" placeholder="Enter your Name"
								class="form-control name_list" required="" id="pet-select">
									<option value="">--Please choose an option--</option>
									<c:forEach var="emp" items="${empList}">
										<option value="${emp}">${emp}</option>
									</c:forEach>
							</select></td>
							<!-- 							<td><input type="text" name="name"
								placeholder="Enter your Name" class="form-control name_list"
								required="" /></td> -->
							<td><input type="text" name="quantity"
								placeholder="Enter your Name" class="form-control name_list"
								required="" /></td>
							<td><button type="button" name="add" id="add"
									class="btn btn-success">Add More</button></td>
						</tr>
					</table>
					<input type="button" name="submit" id="submit" class="btn btn-info"
						value="Submit" />
				</div>



				<%-- <select name="pets" id="pet-select">
					<option value="">--Please choose an option888--</option>
					<c:forEach var="emp" items="${empList}">
						<option value="${emp}">${emp}</option>
					</c:forEach>
				</select> --%>


			</form>
		</div>
	</div>
	<jsp:include page="FooterPage.jsp" />
	<script src="https://code.jquery.com/jquery-2.2.4.min.js"
		type="text/javascript"></script>
	<script>
		$(document)
				.ready(
						function() {
							var postURL = "/addMemedicine";
							var i = 1;

							$('#add')
									.click(
											function() {
												i++;
												$('#dynamic_field')
														.append(
																'<tr id="row'+i+'" class="dynamic-added"><td><select name="name" placeholder="Enter your Name" class="form-control name_list" required="" ><option value="">--Please choose an option--</option><c:forEach var="emp" items="${empList}"><option value="${emp}">${emp}</option></c:forEach></select></td><td> <input type="text" name="quantity" placeholder="Enter your Name" class="form-control name_list" required="" /><td><button type="button" name="remove" id="'+i+'"class="btn btn-danger btn_remove">X</button></td></tr>');
											});

							$(document).on('click', '.btn_remove', function() {
								var button_id = $(this).attr("id");
								$('#row' + button_id + '').remove();
							});

							$('#submit')
									.click(
											function() {
												var body = $('#add_name')
														.serialize();
												var data = JSON.stringify($(
														'#add_name')
														.serialize());
												var formData = JSON
														.parse(JSON
																.stringify($(
																		'#add_name')
																		.serializeArray()))
												console.log("formData:",
														formData);

												$
														.ajax({
															url : postURL,
															method : "POST",
															data : body,
															type : 'json',
															success : function(
																	data) {
																i = 1;
																$(
																		'.dynamic-added')
																		.remove();
																$('#add_name')[0]
																		.reset();
																alert('Record Inserted Successfully.');
															}
														});
											});

						});
	</script>
</body>
</html>


<!-- 

'<tr id="row'+i+'" class="dynamic-added"><td><input type="text" name="name" placeholder="Enter Medicine Name" class="form-control name_list" required /></td><td> <input type="text" name="quantity" placeholder="Enter your Name" class="form-control name_list" required="" /><td><button type="button" name="remove" id="row'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>'
-->