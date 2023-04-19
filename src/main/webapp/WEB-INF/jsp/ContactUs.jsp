<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>E-Care App</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />


    <!-- glyph -->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
      integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
      crossorigin="anonymous"
      
    /><link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  </head>

  <body>
    <jsp:include page="JumboTrane.jsp" />

    <div class="container">
      <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
          <h2 className="text-center">Contact Us</h2>
        </div>
        <div class="col-md-4"></div>
      </div>
    </div>

       <div class="container">
          <div class="row">
            <div class="col">
                 

                 <i class='fas fa-address-card' style='font-size:48px;color:black'></i><h2>Customer Care</h2>
              <p>You can call to below number for any query relaed to appointment.</p>
               
             <i class="material-icons" style="font-size:36px">call</i> +91-909 909 8989
             <br></br>
              <i class="material-icons" style="font-size:48px;color:black">person_outline</i><h2>Appointment Contact</h2>

              <p>Call on below mobile <br>number to fix your appointment.</p>
             <i class="material-icons" style="font-size:36px">call</i> +91-909 909 8989
            </div>
            <div class="col">
            
              <i class="material-icons" style="font-size:48px;color:black">phone_android</i> <h2>Emergency Contact</h2>
              <p> Reach out to us in case of any emergency.</p>
               <i class="material-icons" style="font-size:36px">call</i> +91-909 909 8989
               
              </p>
              <br></br>
              <i class='fas fa-tablets' style='font-size:48px;color:red'></i><h2>Medical Store</h2>
              <p>Call on +91-988 987 9898 to get any medicine</p>
            </div>
          </div>
        </div>

    <!-- footer code start -->
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
        @ 2023 Copyright:
        <a class="text-reset fw-bold" href="#">e-careApplication.com</a>
      </div>
      <!-- Copyright -->
    </footer>

    <!-- footer code end -->
  </body>
</html>
