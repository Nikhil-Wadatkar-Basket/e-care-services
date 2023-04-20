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
  </head>

  <body>
    <jsp:include page="JumboTrane.jsp" />
    <jsp:include page="Navbar.jsp" />

    <!-- <div class="container">
      <h3>New Doctor</h3>

      <form:form method="POST" action="/createDoctor" modelAttribute="doc">
        <table>
          <tr>
            <td></td>
            <td><form:hidden path="docID" /></td>
          </tr>

          <tr>
            <td>Doctor Name:</td>
            <td><form:input path="docName" /></td>
          </tr>
          <tr>
            <td>Doctor Contact :</td>
            <td><form:input path="docContact" /></td>
          </tr>
          <tr>
            <td>Designation:</td>
            <td>
              <form:select path="designation">
                <%--
                <form:option value="NONE" label="Select" />
                --%>
                <form:options items="${designationList}" />
              </form:select>
            </td>
          </tr>

          <tr>
            <td></td>
            <td><input type="submit" value="Edit Save" /></td>
          </tr>
        </table>
      </form:form>
    </div> -->

    <div class="container">
      <div class="text-center">
        <h2>New Doctor</h2><br></br>
		<h4>Add Doctor Details below</h4>
      </div>
    </div>

    <form:form method="POST" action="/createDoctor" modelAttribute="doc">
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="form-group">
              <label for="exampleFormControlInput1"><b>Doctor Name:</b></label>
              <form:input path="docName" class="form-control" id="docName"/>
            </div>
			<span id="nameAlert" class=""></span>
          </div>
          <div class="col-md-4">
            <div class="form-group">
              <label for="exampleFormControlInput1"><b>Contact:</b></label>
              <form:input path="docContact" class="form-control" id="contact" maxlength="10"/>
            </div>
			<span id="contactAlert" class=""></span>
          </div>
          <div class="col-md-4">
            <div class="form-group">
              <label for="exampleFormControlInput1"><b>Designation:</b></label>
              <form:select path="designation" class="form-control" id="desg">
                <form:options items="${designationList}" />
              </form:select>
            </div>
			<span id="" class=""></span>
          </div>
        </div>

        <div class="row">
          <div class="col-md-4"></div>
          <div class="col-md-4"></div>
          <div class="col-md-4"></div>
        </div>
      </div>

      <div class="container">
        <div class="text-center">
          <label
            ><input type="submit" value="Create New Patient middle"
          /></label>
        </div>
      </div>
    </form:form>
    <div class="container">
      <div class="text-center">
        <label
          ><button id="validate" class="btn btn-primary">
            Validate First
          </button></label
        >
      </div>
    </div>

    <jsp:include page="FooterPage.jsp" />
 

  <script>
      $(document).ready(function () {
        $("#nameAlert").hide();
		$("#contactAlert").hide();
        $("#desgAlert").hide();
        
		
        

        $(':input[type="submit"]').prop("disabled", true);
        $("#validate").click(function () {
          var count = 0;
          var docName = $("#docName").val();
          var desg = $("#desg").val();
		 var contact = $("#contact").val();


          
          if (docName.length == 0) {
            $("#nameAlert").text("Please fill it.");
            $("#nameAlert").css("color", "red");
            $("#nameAlert").show();
            count = count + 1;
          } else if (!validateString(docName)) {
            $("#nameAlert").text("Only alphabets.");
            $("#nameAlert").css("color", "red");
            $("#nameAlert").show();
            count = count + 1;
          } else {
            $("#nameAlert").text("Correct.");
            $("#nameAlert").css("color", "green");
            $("#nameAlert").show();
          }

		  if (validatePhone("contact")) {
            $("#contactAlert").text("Correct");
            $("#contactAlert").css("color", "green");
            $("#contactAlert").show();
            // count = count + 1;
          }
		  else if (!validatePhone("contact")) {
            $("#contactAlert").text("It should contain only digits. Length 10 digits");
            $("#contactAlert").css("color", "red");
            $("#contactAlert").show();
            count = count + 1;
          } 
		  
		 


          if (count == 0) {
            $(':input[type="submit"]').prop("disabled", false);
          }
        });
      });function validatePhone(txtPhone) {
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
