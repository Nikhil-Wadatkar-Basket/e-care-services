<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
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

    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
  </head>

  <body>
    <div
      class="bg-image p-5 text-center shadow-1-strong rounded mb-5 text-dark"

       style="
      background-image: url('https://drprem.com/globalhealthcare/wp-content/uploads/sites/17/2014/08/Hospital-Management-System-1280x720-1.jpg');
      background-size: cover;
    "

    >
      <a class="btn btn-danger btn-lg float-right rounded-pill" href="/login"
        >Logout</a
      >
      <h1 class="mb-3 h2">E-Care Health Application</h1>

      <p>Add You content.</p>
    </div>
    <jsp:include page="Navbar.jsp" />

    <div class="container">
      <div class="row">
        <div class="col-sm-5">
          <h2 class="text-center">New Appointment</h2>
<form:form
        method="POST"
        action="/createNewAppointment"
        modelAttribute="app"
        id="signupForm"
      >
        <table>
          <tr>
            <td></td>
            <td><form:hidden path="appID" /></td>
          </tr>
          <tr>
            <td></td>
            <td><form:hidden path="userID" /></td>
          </tr>

          <tr>
            <td>Patient Name :</td>
            <td><form:input path="patientName" id="patientName" /></td>
            <td ><span  id="patientNameAlert"></span></td>
          </tr>
          <tr>
            <td>City:</td>
            <td><form:input path="city" id="city" /></td>
            <td ><span  id="cityAlert"></span></td>
          </tr>
          <tr>
            <td>Age :</td>
            <td><form:input path="age" id="age" /></td>
            <td ><span  id="ageAlert"></span></td>
          </tr>
          <tr>
            <td>Doctor Name :</td>
            <td>
              <form:select path="doctorName" id="doctorName">
                <form:options items="${doctorList}" />
              </form:select>
            </td>
            <td ><span  id="doctorAlert"></span></td>
          </tr>
          <tr>
            <td>Date :</td>
            <td><form:input type="date" path="appDate" /></td>
            <td ><span  id="dateAlert"></td>
          </tr>

          <tr>
            <td>
              <form:label path="meetingType" id="meetingType"
                >Meeting Type</form:label
              >
            </td>
            <td>
              <form:radiobutton path="meetingType" value="New" label="New" />
              <form:radiobutton path="meetingType" value="Old" label="Old" />
            </td>
            <td ><span  id="meetingTypeAlert"></span></td>
          </tr>

          <tr>
            <td>
              <form:label path="patientType" id="patientType"
                >Patient Type</form:label
              >
            </td>
            <td>
              <form:radiobutton path="patientType" value="OPD" label="OPD" />
              <form:radiobutton path="patientType" value="IPD" label="IPD" />
              <form:radiobutton path="patientType" value="ICU" label="ICU" />
            </td>
            <td ><span  id="patientTypeAlert"></span></td>
          </tr>

          <tr>
            <td><form:label path="appTime" id="appTime">Time</form:label></td>
            <td>
              <form:select path="appTime">
                <form:option value="NONE" label="Select" />
                <form:options items="${freeTimeSlots}" />
              </form:select>
            </td>
            <td ><span  id="appTimeAlert"></span></td>
          </tr>
          <tr>
            <td>
              <form:label path="bloodGroup" id="bloodGroup"
                >Blood Group</form:label
              >
            </td>
            <td>
              <form:select path="bloodGroup">
                <form:option value="NONE" label="Select" />
                <form:options items="${bloodGroups}" />
              </form:select>
            </td>
            <td ><span  id="bloodGroupAlert"></span></td>
          </tr>
          <tr>
            <td>Weight :</td>
            <td><form:input path="weight" id="weight" /></td>
            <td ><span  id="weightAlert"></span></td>
          </tr>
          <tr>
            <td>Height :</td>
            <td><form:input path="height" id="height" /></td>
            <td ><span  id="heightAlert"></span></td>
          </tr>
          <tr>
            <td>BP:</td>
            <td><form:input path="bp" id="bp" /></td>
            <td ><span  id="bpAlert"></span></td>
          </tr>
          <tr>
            <td>Sugar:</td>
            <td><form:input path="sugar" id="sugar" /></td>
            <td ><span  id="sugarAlert"></span></td>
          </tr>
          <tr>
            <td>Contact :</td>
            <td><form:input path="contact" id="contact" maxlength="10"/></td>
            <td><span id="contactAlert"></span></td>
          </tr>
          <tr>
            <td></td>
            <td>
              <input type="submit" id="submit" value="Create An Appointment" />
            </td>
          </tr>
        </table>
      </form:form>

      <button id="validate" onclick="">Validate</button>

        </div>
        <div class="col-sm-7">
          <div id="accordion">
            <div class="card">
              <div class="card-header" id="headingOne">
                <h5 class="mb-0">
                  <button
                    class="btn btn-link"
                    data-toggle="collapse"
                    data-target="#collapseOne"
                    aria-expanded="true"
                    aria-controls="collapseOne"
                  >
                    Collapsible Group Item #1
                  </button>
                </h5>
              </div>

              <div
                id="collapseOne"
                class="collapse show"
                aria-labelledby="headingOne"
                data-parent="#accordion"
              >
                <div class="card-body">
                  Anim pariatur cliche reprehenderit, enim eiusmod high life
                  accusamus terry richardson ad squid. 3 wolf moon officia aute,
                  non cupidatat skateboard dolor brunch. Food truck quinoa
                  nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                  aliqua put a bird on it squid single-origin coffee nulla
                  assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft
                  beer labore wes anderson cred nesciunt sapiente ea proident.
                  Ad vegan excepteur butcher vice lomo. Leggings occaecat craft
                  beer farm-to-table, raw denim aesthetic synth nesciunt you
                  probably haven't heard of them accusamus labore sustainable
                  VHS.
                </div>
              </div>
            </div>
            <div class="card">
              <div class="card-header" id="headingTwo">
                <h5 class="mb-0">
                  <button
                    class="btn btn-link collapsed"
                    data-toggle="collapse"
                    data-target="#collapseTwo"
                    aria-expanded="false"
                    aria-controls="collapseTwo"
                  >
                    Collapsible Group Item #2
                  </button>
                </h5>
              </div>
              <div
                id="collapseTwo"
                class="collapse"
                aria-labelledby="headingTwo"
                data-parent="#accordion"
              >
                <div class="card-body">
                  Anim pariatur cliche reprehenderit, enim eiusmod high life
                  accusamus terry richardson ad squid. 3 wolf moon officia aute,
                  non cupidatat skateboard dolor brunch. Food truck quinoa
                  nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                  aliqua put a bird on it squid single-origin coffee nulla
                  assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft
                  beer labore wes anderson cred nesciunt sapiente ea proident.
                  Ad vegan excepteur butcher vice lomo. Leggings occaecat craft
                  beer farm-to-table, raw denim aesthetic synth nesciunt you
                  probably haven't heard of them accusamus labore sustainable
                  VHS.
                </div>
              </div>
            </div>
            <div class="card">
              <div class="card-header" id="headingThree">
                <h5 class="mb-0">
                  <button
                    class="btn btn-link collapsed"
                    data-toggle="collapse"
                    data-target="#collapseThree"
                    aria-expanded="false"
                    aria-controls="collapseThree"
                  >
                    Collapsible Group Item #3
                  </button>
                </h5>
              </div>
              <div
                id="collapseThree"
                class="collapse"
                aria-labelledby="headingThree"
                data-parent="#accordion"
              >
                <div class="card-body">
                  Anim pariatur cliche reprehenderit, enim eiusmod high life
                  accusamus terry richardson ad squid. 3 wolf moon officia aute,
                  non cupidatat skateboard dolor brunch. Food truck quinoa
                  nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                  aliqua put a bird on it squid single-origin coffee nulla
                  assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft
                  beer labore wes anderson cred nesciunt sapiente ea proident.
                  Ad vegan excepteur butcher vice lomo. Leggings occaecat craft
                  beer farm-to-table, raw denim aesthetic synth nesciunt you
                  probably haven't heard of them accusamus labore sustainable
                  VHS.
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
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
          if (age.length == 0) {
            $("#ageAlert").text("Please fill it.");
            $("#ageAlert").css("color", "red");
            $("#ageAlert").show();
            count = count + 1;
          } else if ($.isNumeric(age)) {
            $("#ageAlert").text("Correct.");
            $("#ageAlert").css("color", "green");
            $("#ageAlert").show();
          } else {
            $("#ageAlert").text("It should be number.");
            $("#ageAlert").css("color", "red");
            $("#ageAlert").show();
            count = count + 1;
          }

          if (weight.length == 0) {
            $("#weightAlert").text("Please fill it.");
            $("#weightAlert").css("color", "red");
            $("#weightAlert").show();
            count = count + 1;
          } else if ($.isNumeric(weight)) {
            $("#weightAlert").text("Correct.");
            $("#weightAlert").css("color", "green");
            $("#weightAlert").show();
          }
          if (height.length == 0) {
            $("#heightAlert").text("Please fill it.");
            $("#heightAlert").css("color", "red");
            $("#heightAlert").show();
            count = count + 1;
          } else if ($.isNumeric(height)) {
            $("#heightAlert").text("Correct.");
            $("#heightAlert").css("color", "green");
            $("#heightAlert").show();
          }
          if (bp.length == 0) {
            $("#bpAlert").text("Please fill it.");
            $("#bpAlert").css("color", "red");
            $("#bpAlert").show();
            count = count + 1;
          } else if ($.isNumeric(bp)) {
            $("#bpAlert").text("Correct. Numberic");
            $("#bpAlert").css("color", "green");
            $("#bpAlert").show();
          }

          if (sugar.length == 0) {
            $("#sugarAlert").text("Please fill it.");
            $("#sugarAlert").css("color", "red");
            $("#sugarAlert").show();
            count = count + 1;
          } else if ($.isNumeric(sugar)) {
            $("#sugarAlert").text("correct.");
            $("#sugarAlert").css("color", "green");
            $("#sugarAlert").show();
          }

          if (validatePhone("txtPhone")) {
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
