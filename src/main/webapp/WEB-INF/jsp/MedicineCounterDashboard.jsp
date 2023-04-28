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

		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2 className="text-center"> Medicine Counter Dashboard</h2>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	</br>

	<div class="container">
		<div class="card-deck">
			<div class="card text-center " style="width: 18rem;"  id="pharm_show_flag">
				<div class="card-body">
					<h5 class="card-title">Medicine List</h5>
					<p class="card-text">Click below to see All Available Medicines</p>
					<a class="btn btn-info btn-light" href="/showMedicines">Show Medicine</a>
				</div>
			</div>
			<div class="card text-center" id="pharm_create_flag">
				<div class="card-body">
					<h5 class="card-title">Medicine Store</h5>
					<p class="card-text">Click below to add new medicines for Patients</p>
					<a class="btn btn-info btn-light" href="/donateMedicine">Give Medicine</a>
				</div>
			</div>
			<div class="card text-center"  style="width: 18rem;"id="phar">
				<div class="card-body">
					<h5 class="card-title">Total Medical Sale</h5>
					<p class="card-text">Click below to delete Doctors</p>
					<a class="btn btn-info btn-light" href="/MedicinePatientsList">Click Here</a>
				</div>
			</div>
		</div>
	</div>
	<br></br>
	<br></br>
		<div class="container">
		<div class="card-deck">
			<div class="card-body"></div>
			<div class="card-body">
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					onClick="location.href='/Dashboard'">Go to Dashboard</button>
			</div>
			<div class="card-body"></div>
		</div>
	</div>



	<jsp:include page="FooterPage.jsp" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
		type="text/javascript"></script>
	<script>
     var myReq={
    pharm_create_flag:'',
    pharm_show_flag:'',
    pharm_delete_flag:'',
    pharm_update_flag:''
  }
$(document).ready(function(){

  //on page load, take values from mav and set to request
  myReq.pharm_create_flag='${pharm_create_flag}';
  myReq.pharm_show_flag='${pharm_show_flag}';
  myReq.pharm_delete_flag='${pharm_delete_flag}';
  myReq.pharm_update_flag='${pharm_update_flag}';
 
if(myReq.pharm_create_flag=='Y'){
 $("#pharm_create_flag").show();
}else{
 $("#pharm_create_flag").hide();
}

if(myReq.pharm_delete_flag=='Y'){
 $("#pharm_delete_flag").show();
}else{
 $("#pharm_delete_flag").hide();
}

if(myReq.pharm_show_flag=='Y'){
 $("#pharm_show_flag").show();
}else{
 $("#pharm_show_flag").hide();
}

if(myReq.pharm_update_flag=='Y'){
 $("#pharm_update_flag").show();
}else{
 $("#pharm_update_flag").hide();
}

});

</script>
</body>
</html>