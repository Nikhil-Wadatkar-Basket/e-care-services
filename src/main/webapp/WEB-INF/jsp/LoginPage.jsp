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

<body>
	<jsp:include page="JumboTrane.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-8">

				<div class="container">
					<div class="row">
						<div class="col-md-3"></div>
						<div class="card text-white bg-primary mb-3"
							style="max-width: 18rem;">
							<div class="card-header">
								<h5>Register Yourself.</h5>
							</div>
							<div class="card-body">
								<p class="card-text">If you are facing any issues while
									login. Please register yourself.</p>
								<br> <a href="/loadNewUserPage" class="btn btn-info btn-light"
									role="button">Register Here</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-4 border border-primary">
				<br></br>
				<h4 class="text-center">Login</h4>
				
				<form:form action="/authenticate" method="post" modelAttribute="userDetails">
					<div class="form-group ">
						<label for="exampleInputEmail1">Username:</label>
						<form:input path="userName" class="form-control"
							aria-describedby="emailHelp" placeholder="Enter username" />
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label>
						<form:input path="password" class="form-control" placeholder="Password" />
					</div>
					
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
				<br></br>
			</div>
		</div>

	</div>

	<jsp:include page="FooterPage.jsp" />
</body>
</html>