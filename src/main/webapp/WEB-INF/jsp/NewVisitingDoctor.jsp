<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>E-Care App</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

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
    <jsp:include page="Navbar.jsp" />

    <div class="container">
      <h3>Add New Visiting Doctor's Details</h3>

      <form:form
        method="POST"
        action="/createVisitingDoctor"
        modelAttribute="doc"
      >
        <table>
          <tr>
            <td></td>
            <td><form:hidden path="docID" /></td>
            <td><span id=""></span></td>
          </tr>

          <tr>
            <td>Doctor Name:</td>
            <td><form:input path="docName" id="doctor" /></td>
            <td><span id="doctorAlert"></span></td>
          </tr>
          <tr>
            <td>Doctor Contact :</td>
            <td>
              <form:input path="docContact" id="contact" maxlength="10" />
            </td>
            <td><span id="contactAlert"></span></td>
          </tr>
          <tr>
            <td>Designation:</td>
            <td>
              <form:select path="designation" id="desg">
                <form:options items="${designationList}" />
              </form:select>
            </td>
            <td><span id="desgAlert"></span></td>
          </tr>
          <tr>
            <td>Visiting Date:</td>
            <td><form:input path="visitingDate" type="date" id="date" /></td>
            <td><span id="dateAlert"></span></td>
          </tr>
          <tr>
            <td></td>
            <td><input type="submit" value="Edit Save" /></td>
          </tr>
        </table>
      </form:form>
      <button id="validate" onclick="">Validate</button>
    </div>
    <jsp:include page="FooterPage.jsp" />

    <script>
      $(document).ready(function () {
        $("#doctorAlert").hide();
        $("#contactAlert").hide();
        $("#desgAlert").hide();
        $("#dateAlert").hide();

        $("#submit").prop("disabled", true);
        $("#validate").click(function () {
          var count = 0;
          var doctor = $("#doctor").val();
          var contact = $("#contact").val();
          var desg = $("#desg").val();
          var date = $("#date").val();

          if (doctor.length == 0) {
            $("#doctorAlert").text("Please fill it.");
            $("#doctorAlert").css("color", "red");
            $("#doctorAlert").show();
            count = count + 1;
          } else if (!validateString(doctor)) {
            $("#doctorAlert").text("Only alphabets.");
            $("#doctorAlert").css("color", "red");
            $("#doctorAlert").show();
            count = count + 1;
          } else {
            $("#doctorAlert").text("Correct.");
            $("#doctorAlert").css("color", "green");
            $("#doctorAlert").show();
          }

          if (desg.length == 0) {
            $("#desgAlert").text("Please fill it.");
            $("#desgAlert").css("color", "red");
            $("#desgAlert").show();
            count = count + 1;
          } else if (!validateString(desg)) {
            $("#desgAlert").text("Only alphabets.");
            $("#desgAlert").css("color", "red");
            $("#desgAlert").show();
            count = count + 1;
          } else {
            $("#desgAlert").text("Correct.");
            $("#desgAlert").css("color", "green");
            $("#desgAlert").show();
          }

          if (validatePhone()) {
            $("#contactAlert").text("Correct");
            $("#contactAlert").css("color", "green");
            $("#contactAlert").show();
            // count = count + 1;
          } else if (contact.length == 0) {
            $("#contactAlert").text("Please fill it.");
            $("#contactAlert").css("color", "red");
            $("#contactAlert").show();
            count = count + 1;
          } else {
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
