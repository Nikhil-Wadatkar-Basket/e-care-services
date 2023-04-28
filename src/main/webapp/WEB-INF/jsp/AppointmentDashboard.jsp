<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>E-Care App</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
		<div class="row justify-content-center">	
			<h1>APPOINTMENT Dashboard</h1>

			User ID: ${user_id}<br></br>
		</div><br></br>
		<div class="container">
			<div class="row">
				<div class="col-sm-4" id="app_show_flag">
					<div class="card text-center" >
						<div class="card-body">
							<h5 class="card-title">Appointments List</h5>
							<p class="card-text">Click below to see All Appointments</p>
							<a class="btn btn-info btn-light" href="/getAppointmentsList">All
								Appointments</a>
						</div>
					</div>
				</div>
				<div class="col-sm-4" id="app_create_flag">
					<div class="card text-center" >
						<div class="card-body">
							<h5 class="card-title">Add New Appointment</h5>
							<p class="card-text">Click below to add new appointments</p>
							<a class="btn btn-info btn-light" href="/loadNewAppointmentPage">Create
								Appointments</a>
						</div>
					</div>
				</div>
				<div class="col-sm-4"  id="app_delete_flag">
					<div class="card text-center" >
						<div class="card-body">
							<h5 class="card-title">Delete/Cancel Appointment</h5>
							<p class="card-text">Click below to delete appointments</p>
							<a class="btn btn-info btn-light" href="/DeleteAppointmentsPage">Delete
								Appointments</a>
						</div>
					</div>
				</div>
			</div></div>


			</br>
			<br></br>
			<div class="container  text-center">
				<button type="button" class="btn btn-primary"
					data-dismiss="modal" onClick="location.href='/Dashboard'">Go
					to Dashboard middle</button>
				
			</div>
			<br></br>



			<!-- <div class="row">
		<div class="col-6 col-md-4"></div>
		<div class="col-6 col-md-4">
			<button type="button" class="btn btn-secondary" data-dismiss="modal"
				onClick="location.href='/Dashboard'">Go to Dashboard</button>
		</div>
		<div class="col-6 col-md-4"></div>
	</div> -->
			<br></br> <br></br>



			<jsp:include page="FooterPage.jsp" />

			<script src="https://code.jquery.com/jquery-2.2.4.min.js"
				type="text/javascript"></script>
			<script>
     var myReq={
    app_create_flag:'',
    app_show_flag:'',
    app_delete_flag:'',
    app_update_flag:''
  }
$(document).ready(function(){

  //on page load, take values from mav and set to request
  myReq.app_create_flag='${app_create_flag}';
  myReq.app_show_flag='${app_show_flag}';
  myReq.app_delete_flag='${app_delete_flag}';
  myReq.app_update_flag='${app_update_flag}';
 
if(myReq.app_create_flag=='Y'){
 $("#app_create_flag").show();
}else{
 $("#app_create_flag").hide();
}

if(myReq.app_delete_flag=='Y'){
 $("#app_delete_flag").show();
}else{
 $("#app_delete_flag").hide();
}

if(myReq.app_show_flag=='Y'){
 $("#app_show_flag").show();
}else{
 $("#app_show_flag").hide();
}

if(myReq.app_update_flag=='Y'){
 $("#app_update_flag").show();
}else{
 $("#app_update_flag").hide();
}

});

</script>
</body>
</html>