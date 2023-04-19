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
		<jsp:include page="JumboTrane.jsp" />
	<jsp:include page="Navbar.jsp" />
	<div class="container">
		<h2 align="center">E-Care Medical Store</h2>
		<div class="form-group">
			<form name="add_name" id="add_name">
				<div></div>

				<div></div>

				<div class="row">
					<div class="col-md-4">
						PatientName: <input type="text" name="patientName"
							placeholder="Enter your Name" class="form-control name_list"
							required="" id="patientName"/>
							<span id="patientNameAlert"></span>
					</div>
					<div class="col-md-4">
						Doctors Name<input type="text" name="doctorName"
							placeholder="Enter Doctor Name" class="form-control name_list"
							required="" id="doctorName"/><span id="doctorNameAlert"></span>
					</div>
					<div class="col-md-4">
						Date: <input type="date" name="date" placeholder="Enter your date"
							class="form-control name_list" required="" id="date"/><span id="dateAlert"></span>
					</div>
				</div>
				<br></br>
				<div class="row">
					<div class="col-md-4">
						City: <input type="text" name="city" placeholder="Enter City"
							class="form-control name_list" required="" id="city"/><span id="cityAlert"></span>
					</div>
					<div class="col-md-4">
						Contact:<input type="text" name="contact"
							placeholder="Enter Contact" class="form-control name_list"
							required="" id="contact" maxlength="10"/><span id="contactAlert"></span>
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
							
							<td><input type="text" name="quantity"
								placeholder="Enter quantity" class="form-control name_list"
								required="" /></td>
							<td><button type="button" name="add" id="add"
									class="btn btn-success">Add More</button></td>
						</tr>
					</table>
					<input type="button" name="submit" id="submit" class="btn btn-info"
						value="Submit" />
				</div>
			</form>
			   <button id="validate" onclick="">Validate</button>
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
 <script>
      $(document).ready(function () {
        $("#doctorNameAlert").hide();
        $("#patientNameAlert").hide();
        $("#cityAlert").hide();       
        $("#dateAlert").hide();        
        $("#contactAlert").hide();

        $("#submit").prop("disabled", true);
        $("#validate").click(function () {
          var count = 0;
          var patientName = $("#patientName").val();
          var city = $("#city").val();
          var doctorName = $("#doctorName").val();
          var date = $("#date").val();
          var contact = $("#contact").val();

 if (doctorName.length == 0) {
            $("#doctorNameAlert").text("Please fill it.");
            $("#doctorNameAlert").css("color", "red");
            $("#doctorNameAlert").show();
            count = count + 1;
          } else if (!validateString(doctorName)) {
            $("#doctorNameAlert").text("Only alphabets.");
            $("#doctorNameAlert").css("color", "red");
            $("#doctorNameAlert").show();
            count = count + 1;
          } else {
            $("#doctorNameAlert").text("Correct.");
            $("#doctorNameAlert").css("color", "green");
            $("#doctorNameAlert").show();
          }


          if (patientName.length == 0) {
            $("#patientNameAlert").text("Please fill it.");
            $("#patientNameAlert").css("color", "red");
            $("#patientNameAlert").show();
            count = count + 1;
          } else if (!validateString(patientName)) {
            $("#patientNameAlert").text("Only alphabets.");
            $("#patientNameAlert").css("color", "red");
            $("#patientNameAlert").show();
            count = count + 1;
          } else {
            $("#patientNameAlert").text("Correct.");
            $("#patientNameAlert").css("color", "green");
            $("#patientNameAlert").show();
          }

          if (city.length == 0) {
            $("#cityAlert").text("Please fill it.");
            $("#cityAlert").css("color", "red");
            $("#cityAlert").show();
            count = count + 1;
          } else if (!validateString(city)) {
            $("#cityAlert").text("It should containalphabets.");
            $("#cityAlert").css("color", "red");
            $("#cityAlert").show();
            count = count + 1;
          } else {
            $("#cityAlert").text("Correct.");
            $("#cityAlert").css("color", "green");
            $("#cityAlert").show();
          }
          

           if(contact.length<10)
		 {
            $("#contactAlert").text("Incorrect");
            $("#contactAlert").css("color", "red");
            $("#contactAlert").show();
            count = count + 1;
          }else  if (validatePhone()) {
            $("#contactAlert").text("Correct");
            $("#contactAlert").css("color", "green");
            $("#contactAlert").show();
            // count = count + 1;
          }
		 else
		  {
            $("#contactAlert").text("Incorrect");
            $("#contactAlert").css("color", "red");
            $("#contactAlert").show();
            count = count + 1;
          }

          if (count == 0) {
            $("#submit").prop("disabled", false);
          }
        });
      });

      function validatePhone() {
        var contact = $("#contact").val();
        var filter =
          /^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$/;
        if (filter.test(contact)) {
          return true;
        } else {
          return false;
        }
      }

      function validateString(str) {
        var filter = /^[A-Za-z\s]*$/;
        if (filter.test(str)) {
          return true;
        } else {
          return false;
        }
      }
    </script>

</body>
</html>


<!-- 

'<tr id="row'+i+'" class="dynamic-added"><td><input type="text" name="name" placeholder="Enter Medicine Name" class="form-control name_list" required /></td><td> <input type="text" name="quantity" placeholder="Enter your Name" class="form-control name_list" required="" /><td><button type="button" name="remove" id="row'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>'
-->