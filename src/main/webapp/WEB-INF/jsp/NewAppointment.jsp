<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>E-Care App</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
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
	crossorigin="anonymous" />
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
</head>

<body>
<jsp:include page="JumboTrane.jsp" />
	<jsp:include page="Navbar.jsp" />

	<div class="container">
		<h3>New Appointment</h3>

		<div class="container">

			<form:form method="POST" action="/createNewAppointment" modelAttribute="app">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label for="exampleFormControlInput1">Patient Name:</label>
							<form:input path="patientName" id="patientName"
								class="form-control" />
							<span id="patientNameAlert"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>City:</label>
							<form:input path="city" id="city" class="form-control" />
							<span id="cityAlert"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Age</label>
							<form:input path="age" id="age" class="form-control" />
							<span id="ageAlert"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Doctor Name: </label>
							<form:select path="doctorName" id="doctorName"
								class="form-control">
								<form:options items="${doctorList}" />
							</form:select>
							<span id="doctorAlert"></span>

						</div>
					</div>
				</div>
				</br>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">

							<label>Date:</label>
							<form:input type="date" path="appDate" class="form-control" />
							<span id="dateAlert"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Meeting Type</label>
							<div class="form-check">
								<form:radiobutton path="meetingType" value="New" label="New"
									id="meetingType" class="form-check-input" />
							</div>
							<div class="form-check">
								<form:radiobutton path="meetingType" value="Old" label="Old"
									id="meetingType" class="form-check-input" />
							</div>
							<span id="meetingTypeAlert"></span>

						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Patient Type</label>
							<div class="form-check">
								<form:radiobutton path="patientType" value="IPD" label="IPD"
									id="patientType" class="form-check-input" />
							</div>
							<div class="form-check">
								<form:radiobutton path="patientType" value="OPD" label="OPD"
									id="patientType" class="form-check-input" />
							</div>

							<span id="patientTypeAlert"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>BP:</label>
							<form:input path="bp" id="bp" class="form-control" />
							<span id="bpAlert"></span>

						</div>
					</div>
				</div>
				</br>
				<div class="row">
					<div class="col-md-3">
						<label>Time</label>
						<form:select path="appTime" class="form-control">
							<form:option value="NONE" label="Select" />
							<form:options items="${freeTimeSlots}" />
						</form:select>
						<span id="appTimeAlert"></span>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Blood Group</label>
							<form:select path="bloodGroup" class="form-control">
								<form:option value="NONE" label="Select" />
								<form:options items="${bloodGroups}" class="form-control" />
							</form:select>
							<span id="bloodGroupAlert"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Weight</label>
							<form:input path="weight" id="weight" class="form-control" />
							<span id="weightAlert"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Height</label>
							<form:input path="height" id="height" class="form-control" />
							<span id="heightAlert"></span>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label>Sugar</label>
							<form:input path="sugar" id="sugar" class="form-control" />
							<span id="sugarAlert"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Contact :</label>
							<form:input path="contact" id="contact" maxlength="10"
								class="form-control" />
							<span id="contactAlert"></span>
						</div>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-3"></div>
				</div>
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-3">
						<a href="#" class="btn btn-success" id="validate">Validate</a>
					</div>
					<div class="col-md-3">
						<input type="submit" id="submit" value="Submit" />
					</div>
					<div class="col-md-3"></div>
				</div>
			</form:form>
			</
		</div>
		<jsp:include page="FooterPage.jsp" />

		<script>
      $(document).ready(function () {
        $("#patientNameAlert").hide();
        $("#cityAlert").hide();
        $("#ageAlert").hide();
        $("#doctorAlert").hide();
        $("#dateAlert").hide();
        $("#meetingTypeAlert").hide();
        $("#patientTypeAlert").hide();
        $("#appTimeAlert").hide();
        $("#bloodGroupAlert").hide();
        $("#weightAlert").hide();
        $("#heightAlert").hide();
        $("#bpAlert").hide();
        $("#sugarAlert").hide();
        $("#contactAlert").hide();

        $(':input[type="submit"]').prop("disabled", true);
        $("#validate").click(function () {
          var count = 0;
          var patientName = $("#patientName").val();
          var city = $("#city").val();
          var age = $("#age").val();
          var weight = $("#weight").val();
          var height = $("#height").val();
          var bp = $("#bp").val();
          var sugar = $("#sugar").val();
          var contact = $("#contact").val();

          if (patientName.length == 0 ) {
            $("#patientNameAlert").text("Please fill it.");
            $("#patientNameAlert").css("color", "red");
            $("#patientNameAlert").show();
            count = count + 1;
          }else if(!validateString(patientName)){
             $("#patientNameAlert").text("Only alphabets.");
            $("#patientNameAlert").css("color", "red");
            $("#patientNameAlert").show();
            count = count + 1;
          
          }else{
            $("#patientNameAlert").text("Correct.");
            $("#patientNameAlert").css("color", "green");
            $("#patientNameAlert").show();
          }

          if (city.length == 0) {
            $("#cityAlert").text("Please fill it.");
            $("#cityAlert").css("color", "red");
            $("#cityAlert").show();
            count = count + 1;
          }else if(!validateString(city)){
           $("#cityAlert").text("It should containalphabets.");
            $("#cityAlert").css("color", "red");
            $("#cityAlert").show();
            count = count + 1;
          }
          else{
            $("#cityAlert").text("Correct.");
            $("#cityAlert").css("color", "green");
            $("#cityAlert").show();
          }
          if (age.length == 0) {
            $("#ageAlert").text("Please fill it.");
            $("#ageAlert").css("color", "red");
            $("#ageAlert").show();
            count = count + 1;
          }else if($.isNumeric(age)){
            $("#ageAlert").text("Correct.");
            $("#ageAlert").css("color", "green");
            $("#ageAlert").show();
          }else{
            $("#ageAlert").text("It should be number.");
            $("#ageAlert").css("color", "red");
            $("#ageAlert").show();
             count = count + 1;
          }


if (bp.length == 0) {
            $("#bpAlert").text("Please fill it.");
             $("#bpAlert").css("color", "red");
            $("#bpAlert").show();
            count = count + 1;
          }else if($.isNumeric(bp)){
            $("#bpAlert").text("Correct.");
            $("#bpAlert").css("color", "green");
            $("#bpAlert").show();
          }else if(!$.isNumeric(bp)){
            $("#bpAlert").text("It should be number only.");
            $("#bpAlert").css("color", "red");
            $("#bpAlert").show();
          }
          
          if (weight.length == 0) {
            $("#weightAlert").text("Please fill it.");
             $("#weightAlert").css("color", "red");
            $("#weightAlert").show();
            count = count + 1;
          }else if($.isNumeric(weight)){
            $("#weightAlert").text("Correct.");
            $("#weightAlert").css("color", "green");
            $("#weightAlert").show();
          }else if(!$.isNumeric(weight)){
            $("#weightAlert").text("It should be number only.");
            $("#weightAlert").css("color", "red");
            $("#weightAlert").show();
          }
          
          
          if (height.length == 0) {
            $("#heightAlert").text("Please fill it.");
             $("#heightAlert").css("color", "red");
            $("#heightAlert").show();
            count = count + 1;
          }else if($.isNumeric(height)){
            $("#heightAlert").text("Correct.");
            $("#heightAlert").css("color", "green");
            $("#heightAlert").show();
          }else if(!$.isNumeric(height)){
            $("#heightAlert").text("It should be number only.");
            $("#heightAlert").css("color", "red");
            $("#heightAlert").show();
          }
          
          if (bp.length == 0) {
            $("#bpAlert").text("Please fill it.");
            $("#bpAlert").css("color", "red");
            $("#bpAlert").show();
            count = count + 1;
          }else if($.isNumeric(bp)){
            $("#bpAlert").text("Correct. Numberic");
            $("#bpAlert").css("color", "green");
            $("#bpAlert").show();
          }


          if (sugar.length == 0) {
            $("#sugarAlert").text("Please fill it.");
            $("#sugarAlert").css("color", "red");
            $("#sugarAlert").show();
            count = count + 1;
          }else if($.isNumeric(sugar)){
            $("#sugarAlert").text("correct.");
            $("#sugarAlert").css("color", "green");
            $("#sugarAlert").show();
          }else if(!$.isNumeric(sugar)){
            $("#sugarAlert").text("It should be number only.");
            $("#sugarAlert").css("color", "red");
            $("#sugarAlert").show();
          }


if(contact.length<10){

            $("#contactAlert").text("Length should be of 10 digits.");
            $("#contactAlert").css("color", "red");
            $("#contactAlert").show();
            count = count + 1;

}else if (validatePhone("txtPhone")) {
            $("#contactAlert").text("Correct");
            $("#contactAlert").css("color", "green");
            $("#contactAlert").show();
            // count = count + 1;
          } else {
            $("#contactAlert").text("Incorrect");
            $("#contactAlert").css("color", "red");
            $("#contactAlert").show();
            count = count + 1;
          }

          if (count == 0) {
            $(':input[type="submit"]').prop("disabled", false);
          }
        });
      });

      function validatePhone(txtPhone) {
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
        var filter=/^[A-Za-z\s]*$/;
if (filter.test(str)) {
          return true;
        } else {
          return false;
        }

  
}
    </script>
</body>
</html>
