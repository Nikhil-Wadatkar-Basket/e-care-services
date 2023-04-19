<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>E-Care App</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
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
</head>

<body 
style="
        background-image: url('https://thumbs.dreamstime.com/b/medicine-doctor-holding-red-heart-shape-hand-medical-icon-network-connection-modern-virtual-screen-interface-service-mind-99681240.jpg');
      ">
	
<div
      class="bg-image p-5 text-center shadow-1-strong rounded mb-5 text-white"
     
    >
      <h1 class="mb-3 h2">E-Care Health Application</h1>

      <p>Add You content.</p>
    </div>
	<div class="container">
		<div class="row">
			<div class="col table-bordered">
<h4 class="text-center">Login</h4>

<form:form action="/authenticate" method="post" modelAttribute="userDetails">
					<div class="form-group ">
						<label for="exampleInputEmail1"> <b>Username:</b></label>
						<form:input path="userName" class="form-control"
							aria-describedby="emailHelp" placeholder="Enter username" />
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1"><b>Password</b></label>
						<form:input path="password"  type="password" class="form-control" placeholder="Password" />
					</div>
					
					
					
				
				<div class="d-flex justify-content-center ">
  <button class="btn btn-primary">Login</button>
</div>

				</form:form>

			</br>
				
				<div class="d-flex justify-content-center ">
  <button type="submit" class="btn btn-success " onClick="location.href='/loadNewUserPage'">Register</button>
</div>
			<p>Register yourself if you are a new user!!</p>

</div>
<div class="col">

</div>
<div class="col">

</div><div class="col">

</div>
				</div>
			</div>
		
			
	

	




<!-- Footer Code-->

    <footer class="text-center text-lg-start text-muted fixed-bottom">
      <!-- Section: Social media -->
      <!--  -->
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
    <!-- Footer -->
</body>
</html>