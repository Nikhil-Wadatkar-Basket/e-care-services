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
      <h3>REGISTER NEW USER</h3>

      <form:form method="POST" action="/createUser" modelAttribute="user">
        <table>
          <tr>
            <td></td>
            <td><form:hidden path="userID" /></td>
          </tr>

          <tr>
            <td>Name:</td>
            <td><form:input path="name" id="name" /></td>
            <td><span id="nameAlert"></span></td>
          </tr>
          <tr>
            <td>Email:</td>
            <td><form:input path="email" id="email" /></td>
            <td><span id="emailAlert"></span></td>
          </tr>
          <tr>
            <td>City:</td>
            <td><form:input path="city" id="city" /></td>
            <td><span id="cityAlert"></span></td>
          </tr>
          <tr>
            <td>Username:</td>
            <td><form:input path="userName" id="userName" /></td>
            <td><span id="userNameAlert"></span></td>
          </tr>
          <tr>
            <td>Password:</td>
            <td><form:input path="password" id="password" /></td>
            <td><span id="passwordAlert"></span></td>
          </tr>

          <tr>
            <td>Role:</td>
            <td>
              <form:select path="role" id="role">
                <form:option value="NONE" label="Select" />
                <form:options items="${rolesList}" />
              </form:select>
            </td>
          </tr>
          <tr>
            <td><form:label path="status" id="status">Status</form:label></td>
            <td>
              <form:radiobutton path="status" value="Active" label="Active" />
              <form:radiobutton
                path="status"
                value="Not Active"
                label="Not Active"
              />
            </td>
            <td><span id="statusAlert"></span></td>
          </tr>

          <tr>
            <td></td>
            <td><input type="submit" value="Update User" /></td>
          </tr>
        </table>
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
    </div>
    <jsp:include page="FooterPage.jsp" />
    <script>
      $(document).ready(function () {
        $("#nameAlert").hide();
        $("#emailAlert").hide();
        $("#cityAlert").hide();
        $("#userNameAlert").hide();

        $("#passwordAlert").hide();
        $("#roleAlert").hide();
        $("#statusAlert").hide();
        $("#userNameAlert").hide();

        $("#submit").prop("disabled", true);
        $("#validate").click(function () {
          var count = 0;
          var name = $("#name").val();
          var email = $("#email").val();
          var city = $("#city").val();
          var userName = $("#userName").val();
          var password = $("#password").val();
          var role = $("#role").val();
          var status = $("#status").val();

          if (name.length == 0) {
            $("#nameAlert").text("Please fill it.");
            $("#nameAlert").css("color", "red");
            $("#nameAlert").show();
            count = count + 1;
          } else if (!validateString(name)) {
            $("#nameAlert").text("Only alphabets.");
            $("#nameAlert").css("color", "red");
            $("#nameAlert").show();
            count = count + 1;
          } else {
            $("#nameAlert").text("Correct.");
            $("#nameAlert").css("color", "green");
            $("#nameAlert").show();
          }

          if (email.length == 0) {
            $("#emailAlert").text("Please fill it.");
            $("#emailAlert").css("color", "red");
            $("#emailAlert").show();
            count = count + 1;
          } else if (!validateString(email)) {
            $("#emailAlert").text("Only alphabets.");
            $("#emailAlert").css("color", "red");
            $("#emailAlert").show();
            count = count + 1;
          } else {
            $("#emailAlert").text("Correct.");
            $("#emailAlert").css("color", "green");
            $("#emailAlert").show();
          }

          if (city.length == 0) {
            $("#cityAlert").text("Please fill it.");
            $("#cityAlert").css("color", "red");
            $("#cityAlert").show();
            count = count + 1;
          } else if (!validateString(city)) {
            $("#cityAlert").text("Only alphabets.");
            $("#cityAlert").css("color", "red");
            $("#cityAlert").show();
            count = count + 1;
          } else {
            $("#cityAlert").text("Correct.");
            $("#cityAlert").css("color", "green");
            $("#cityAlert").show();
          }

          if (userName.length == 0) {
            $("#userNameAlert").text("Please fill it.");
            $("#userNameAlert").css("color", "red");
            $("#userNameAlert").show();
            count = count + 1;
          } else if (!validateString(userName)) {
            $("#userNameAlert").text("Only alphabets.");
            $("#userNameAlert").css("color", "red");
            $("#userNameAlert").show();
            count = count + 1;
          } else {
            $("#userNameAlert").text("Correct.");
            $("#userNameAlert").css("color", "green");
            $("#userNameAlert").show();
          }

          if (password.length == 0) {
            $("#passwordAlert").text("Please fill it.");
            $("#passwordAlert").css("color", "red");
            $("#passwordAlert").show();
            count = count + 1;
          } else if (!validateString(password)) {
            $("#passwordAlert").text("Only alphabets.");
            $("#passwordAlert").css("color", "red");
            $("#passwordAlert").show();
            count = count + 1;
          } else {
            $("#passwordAlert").text("Correct.");
            $("#passwordAlert").css("color", "green");
            $("#passwordAlert").show();
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
