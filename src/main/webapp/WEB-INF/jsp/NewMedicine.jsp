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
    <jsp:include page="JumboTrane.jsp" />
    <jsp:include page="Navbar.jsp" />

    <div class="container">
      <h3>New Medicine</h3>

      <form:form
        method="POST"
        action="/createMedicine"
        modelAttribute="medicine"
      >
        <table>
          <tr>
            <td></td>
            <td><form:hidden path="medicineID" /></td>
            <td><span id=""></span></td>
          </tr>

          <tr>
            <td>Medicine Name:</td>
            <td><form:input path="medicineName" id="medicineName" /></td>
            <td><span id="medNameAlert"></span></td>
          </tr>
          <tr>
            <td>Stock:</td>
            <td><form:input path="stock" id="stock" /></td>
            <td><span id="stockAlert"></span></td>
          </tr>
          <tr>
            <td>Price:</td>
            <td><form:input path="price" id="price" /></td>
            <td><span id="priceAlert"></span></td>
          </tr>
          <tr>
            <td>Exp. Date :</td>
            <td><form:input type="date" path="expDate" id="date" /></td>
            <td><span id="dateAlert"></span></td>
          </tr>

          <tr>
            <td></td>
            <td>
              <input type="submit" value="Create New Medicine" id="submit" />
            </td>
          </tr>
        </table>
      </form:form>
      <button id="validate" onclick="">Validate</button>
    </div>
    <jsp:include page="FooterPage.jsp" />
    <script>
      $(document).ready(function () {
        $("#medNameAlert").hide();
        $("#stockAlert").hide();
        $("#priceAlert").hide();
        $("#dateAlert").hide();

        $("#submit").prop("disabled", true);
        $("#validate").click(function () {
          var count = 0;
          var medicineName = $("#medicineName").val();
          var stock = $("#stock").val();
          var price = $("#price").val();
          var date = $("#date").val();

          if (medicineName.length == 0) {
            $("#medNameAlert").text("Please fill it.");
            $("#medNameAlert").css("color", "red");
            $("#medNameAlert").show();
            count = count + 1;
          } else if (!validateString(medicineName)) {
            $("#medNameAlert").text("Only alphabets.");
            $("#medNameAlert").css("color", "red");
            $("#medNameAlert").show();
            count = count + 1;
          } else {
            $("#medNameAlert").text("Correct.");
            $("#medNameAlert").css("color", "green");
            $("#medNameAlert").show();
          }

          if (stock.length == 0) {
            $("#stockAlert").text("Please fill it.");
            $("#stockAlert").css("color", "red");
            $("#stockAlert").show();
            count = count + 1;
          } else if ($.isNumeric(stock)) {
            $("#stockAlert").text("Correct.");
            $("#stockAlert").css("color", "green");
            $("#stockAlert").show();
          } else {
            $("#stockAlert").text("It should be number.");
            $("#stockAlert").css("color", "red");
            $("#stockAlert").show();
            count = count + 1;
          }

          if (price.length == 0) {
            $("#priceAlert").text("Please fill it.");
            $("#priceAlert").css("color", "red");
            $("#priceAlert").show();
            count = count + 1;
          } else if ($.isNumeric(price)) {
            $("#priceAlert").text("Correct.");
            $("#priceAlert").css("color", "green");
            $("#priceAlert").show();
          } else {
            $("#priceAlert").text("It should be Number only.");
            $("#priceAlert").css("color", "red");
            $("#priceAlert").show();
          }

          if (count == 0) {
            $("#submit").prop("disabled", false);
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
