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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

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
  </head>

  <body>
    <!-- Jumbotron  code start-->
    <jsp:include page="JumboTrane.jsp" />

    <!-- Jumbotron  code end -->
    <!-- navbar code start -->
    <jsp:include page="Navbar.jsp" />
    <!-- navbar code end -->
    <div class="container">
      <h3 class="text-center">Appointments</h3>

      <!-- <div class="table-responsive"> -->
      <table class="table table-bordered">
        <thead>
          <tr class="text-white" style="background-color: rgb(239, 149, 85)">
            <th>ID</th>
            <th class="col-xs-1">Doctor Name</th>
            <th class="col-xs-1">Patient Name</th>
            <th class="col-xs-1">Date</th>
            <th class="col-xs-1">Time</th>
            <th class="col-xs-1">Time Status</th>
            <th style="width: 10%">Meeting type</th>
            <th style="width: 10%">Fees</th>
            <th style="width: 10%">City</th>
            <th style="width: 10%">Blood group</th>
            <th style="width: 10%">Age</th>
            <th style="width: 10%">Contact</th>
            <th colspan="2" class="text-center">Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="emp" items="${empList}">
            <tr>
              <td style="background-color: rgb(166, 243, 119)">${emp.appID}</td>
              <td>${emp.doctorName}</td>
              <td>${emp.patientName}</td>
              <td>${emp.appDate}</td>
              <td>${emp.appTime}</td>
              <td>${emp.appTimeStatue}</td>
              <td>${emp.meetingType}</td>
              <td>${emp.fees}</td>
              <td>${emp.city}</td>
              <td>${emp.bloodGroup}</td>
              <td>${emp.age}</td>
              <td>${emp.contact}</td>
              <td>
                <a
                  class="btn btn-primary"
                  href="/getAppointmentByTime/${emp.appTime}"
                  >Edit</a
                >
              </td>
              <td>
                <a
                  class="btn btn-danger"
                  href="/deleteAppointmentByTime/${emp.appTime}"
                  >Delete</a
                >
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <!-- </div> -->
    </div>

    <!-- Footer Code-->

    <footer class="text-center text-lg-start text-muted">
      <!-- Section: Social media -->
      <section
        class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom"
      >
        <!-- Left -->
        <!-- <div class="me-5 d-none d-lg-block">
				<span>Get connected with us on social networks:</span>
			</div> -->
        <!-- Left -->

        <!-- Right -->
        <div>
          <a href="" class="me-4 link-secondary">
            <i class="fab fa-facebook-f"></i>
          </a>
          <a href="" class="me-4 link-secondary">
            <i class="fab fa-twitter"></i>
          </a>
          <a href="" class="me-4 link-secondary">
            <i class="fab fa-google"></i>
          </a>
          <a href="" class="me-4 link-secondary">
            <i class="fab fa-instagram"></i>
          </a>
          <a href="" class="me-4 link-secondary">
            <i class="fab fa-linkedin"></i>
          </a>
          <a href="" class="me-4 link-secondary">
            <i class="fab fa-github"></i>
          </a>
        </div>
        <!-- Right -->
      </section>
      <!-- Section: Social media -->

      <!-- Section: Links  -->
      <section class="">
        <div class="container text-center text-md-start mt-5">
          <!-- Grid row -->
          <div class="row mt-3">
            <!-- Grid column -->

            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
              <!-- Links -->
              <h6 class="text-uppercase fw-bold mb-4">Services</h6>
              <p>
                <a href="#!" class="text-reset">Outer Patient Department</a>
              </p>
              <p>
                <a href="#!" class="text-reset">Intensive Care Unit</a>
              </p>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
              <!-- Links -->
              <h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
              <p>
                <a href="/contactUs" class="text-reset">Contact Us</a>
              </p>
              <p>
                <a href="/aboutUs" class="text-reset">About Us</a>
              </p>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
              <!-- Links -->
              <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
              <p>
                <i class="fas fa-home me-3 text-secondary"></i> Badnera,
                Amrawati
              </p>
              <p>
                <i class="fas fa-envelope me-3 text-secondary"></i>
                info@ecareapp.com
              </p>
              <p>
                <i class="fas fa-phone me-3 text-secondary"></i> +91 9876543210
              </p>
              <p>
                <i class="fas fa-print me-3 text-secondary"></i> +91 9876543213
              </p>
            </div>
            <!-- Grid column -->
          </div>
          <!-- Grid row -->
        </div>
      </section>
      <!-- Section: Links  -->

      <!-- Copyright -->
      <div
        class="text-center p-4"
        style="background-color: rgba(0, 0, 0, 0.025)"
      >
        � 2023 Copyright:
        <a class="text-reset fw-bold" href="#">e-careApplication.com</a>
      </div>
      <!-- Copyright -->
    </footer>
    <!-- Footer -->
  </body>
</html>
