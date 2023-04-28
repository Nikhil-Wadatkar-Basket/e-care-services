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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<!-- glyph -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>

<!-- ajax -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

</head>
<body>

	<jsp:include page="JumboTrane.jsp" />

	<!-- Jumbotron  code end -->
	<!-- navbar code start -->
 <jsp:include page="Navbar.jsp" />

	User ID: ${user_id}
	<div class="container">
		<h4>Admin Console</h4><br></br>
	
	
	</div>

<div class="container text-center"><h3>Role Based Access List</h3>
<table class="table table-bordered">
        <thead>

				private String userID;
	private String userName;
	private String password;
	private String role;
	private String name;
	private String email;
	private String city;
	private String status;

          <tr class="text-white" style="background-color: rgb(239, 149, 85)">
            <th>ID</th>
            <th class="col-xs-1">Name</th>
            <th class="col-xs-1">Role</th>
            <th class="col-xs-1">City</th>
            <th class="col-xs-1">Email</th>
            <th class="col-xs-1">Status</th>
            <th style="width: 10%">Username</th>
            <th style="width: 10%">Password</th>
           
            <th colspan="2" class="text-center">Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="emp" items="${empList}">
            <tr>
              <td style="background-color: rgb(166, 243, 119)">${emp.appID}</td>
              <td>${emp.name}</td>
              <td>${emp.role}</td>
              <td>${emp.city}</td>
              <td>${emp.email}</td>
              <td>${emp.status}</td>
              <td>${emp.userName}</td>
              <td>${emp.password}</td>
             
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

</div>
	



	<br></br>

	<script src="https://code.jquery.com/jquery-2.2.4.min.js"
		type="text/javascript"></script>
	<script>
     var myReq={
     userName:'',
     role:'',
     name:'',
     email:'',
     city:'',
     status:'',
     
     
    app_create_flag:'',
    app_show_flag:'',
    app_delete_flag:'',
    app_update_flag:'',
   
    pat_create_flag:'',
	pat_delete_flag:'',
	pat_update_flag:'',
	pat_show_flag:'',
	
	doc_create_flag:'',
	doc_delete_flag:'',
	doc_update_flag:'',
	doc_show_flag:'',
	
	med_create_flag:'',
	med_delete_flag:'',
	med_update_flag:'',
	med_show_flag:'',
	
	vDoc_create_flag:'',
	vDoc_delete_flag:'',
	vDoc_update_flag:'',
	vDoc_show_flag:'',
	
	icu_create_flag:'',
	icu_delete_flag:'',
	icu_update_flag:'',
	icu_show_flag:''
  }
$(document).ready(function(){
	// on page load , get all details with user_id
$.get("getUserInfo/${user_id}", function(data, status){
	console.log('inside ajax get');
	  myReq.userName=data.userName;
      myReq.role=data.role;
      myReq.name=data.name;
      myReq.email=data.email;
      myReq.city=data.city;
      myReq.status=data.status;
	
	
 myReq.app_create_flag=data.app_create_flag;
  myReq.app_show_flag=data.app_show_flag;
  myReq.app_delete_flag=data.app_delete_flag;
  myReq.app_update_flag=data.app_update_flag;

  myReq.pat_create_flag=data.pat_create_flag;
  myReq.pat_show_flag=data.pat_show_flag;
  myReq.pat_delete_flag=data.pat_delete_flag;
  myReq.pat_update_flag=data.pat_update_flag;
  
  myReq.doc_create_flag=data.doc_create_flag;
  myReq.doc_show_flag=data.doc_show_flag;
  myReq.doc_delete_flag=data.doc_delete_flag;
  myReq.doc_update_flag=data.doc_update_flag;
  
  myReq.icu_create_flag=data.icu_create_flag;
  myReq.icu_show_flag=data.icu_show_flag;
  myReq.icu_delete_flag=data.icu_delete_flag;
  myReq.icu_update_flag=data.icu_update_flag;
  
  myReq.med_create_flag=data.med_create_flag;
  myReq.med_show_flag=data.med_show_flag;
  myReq.med_delete_flag=data.med_delete_flag;
  myReq.med_update_flag=data.med_update_flag;
  
  myReq.vDoc_create_flag=data.vDoc_create_flag;
  myReq.vDoc_show_flag=data.vDoc_show_flag;
  myReq.vDoc_delete_flag=data.vDoc_delete_flag;
  myReq.vDoc_update_flag=data.vDoc_update_flag;
console.log('====================================');
console.log(myReq);
console.log('====================================');

if(myReq.app_create_flag=='Y'){
 $("#app_create_flag").attr("checked", "checked");
}else{
 $("#app_create_flag").removeAttr("checked", "checked");
}

if(myReq.app_delete_flag=='Y'){
 $("#app_delete_flag").attr("checked", "checked");
}else{
 $("#app_delete_flag").removeAttr("checked", "checked");
}

if(myReq.app_show_flag=='Y'){
 $("#app_show_flag").attr("checked", "checked");
}else{
 $("#app_show_flag").removeAttr("checked", "checked");
}

if(myReq.app_update_flag=='Y'){
 $("#app_update_flag").attr("checked", "checked");
}else{
 $("#app_update_flag").removeAttr("checked", "checked");
}
//============patient
if(myReq.pat_create_flag=='Y'){
 $("#pat_create_flag").attr("checked", "checked");
}else{
 $("#pat_create_flag").removeAttr("checked", "checked");
}

if(myReq.pat_delete_flag=='Y'){
 $("#pat_delete_flag").attr("checked", "checked");
}else{
 $("#pat_delete_flag").removeAttr("checked", "checked");
}

if(myReq.pat_show_flag=='Y'){
 $("#pat_show_flag").attr("checked", "checked");
}else{
 $("#pat_show_flag").removeAttr("checked", "checked");
}

if(myReq.pat_update_flag=='Y'){
 $("#pat_update_flag").attr("checked", "checked");
}else{
 $("#pat_update_flag").removeAttr("checked", "checked");
}
//=========doc
if(myReq.doc_create_flag=='Y'){
 $("#doc_create_flag").attr("checked", "checked");
}else{
 $("#doc_create_flag").removeAttr("checked", "checked");
}

if(myReq.doc_delete_flag=='Y'){
 $("#doc_delete_flag").attr("checked", "checked");
}else{
 $("#doc_delete_flag").removeAttr("checked", "checked");
}

if(myReq.doc_show_flag=='Y'){
 $("#doc_show_flag").attr("checked", "checked");
}else{
 $("#doc_show_flag").removeAttr("checked", "checked");
}

if(myReq.doc_update_flag=='Y'){
 $("#doc_update_flag").attr("checked", "checked");
}else{
 $("#doc_update_flag").removeAttr("checked", "checked");
}
//===med


  if(myReq.med_create_flag=='Y'){
 $("#med_create_flag").attr("checked", "checked");
}else{
 $("#med_create_flag").removeAttr("checked", "checked");
}

if(myReq.med_delete_flag=='Y'){
 $("#med_delete_flag").attr("checked", "checked");
}else{
 $("#med_delete_flag").removeAttr("checked", "checked");
}

if(myReq.med_show_flag=='Y'){
 $("#med_show_flag").attr("checked", "checked");
}else{
 $("#med_show_flag").removeAttr("checked", "checked");
}

if(myReq.med_update_flag=='Y'){
 $("#med_update_flag").attr("checked", "checked");
}else{
 $("#med_update_flag").removeAttr("checked", "checked");
}

//===vDoc 

  if(myReq.vDoc_create_flag=='Y'){
 $("#vDoc_create_flag").attr("checked", "checked");
}else{
 $("#vDoc_create_flag").removeAttr("checked", "checked");
}

if(myReq.vDoc_delete_flag=='Y'){
 $("#vDoc_delete_flag").attr("checked", "checked");
}else{
 $("#vDoc_delete_flag").removeAttr("checked", "checked");
}

if(myReq.vDoc_show_flag=='Y'){
 $("#vDoc_show_flag").attr("checked", "checked");
}else{
 $("#vDoc_show_flag").removeAttr("checked", "checked");
}

if(myReq.vDoc_update_flag=='Y'){
 $("#vDoc_update_flag").attr("checked", "checked");
}else{
 $("#vDoc_update_flag").removeAttr("checked", "checked");
}

//icu

  if(myReq.icu_create_flag=='Y'){
 $("#icu_create_flag").attr("checked", "checked");
}else{
 $("#icu_create_flag").removeAttr("checked", "checked");
}

if(myReq.icu_delete_flag=='Y'){
 $("#icu_delete_flag").attr("checked", "checked");
}else{
 $("#icu_delete_flag").removeAttr("checked", "checked");
}

if(myReq.icu_show_flag=='Y'){
 $("#icu_show_flag").attr("checked", "checked");
}else{
 $("#icu_show_flag").removeAttr("checked", "checked");
}

if(myReq.icu_update_flag=='Y'){
 $("#icu_update_flag").attr("checked", "checked");
}else{
 $("#icu_update_flag").removeAttr("checked", "checked");
}

console.log('inside ajax get end');
});

  //on page load, take values from mav and set to request
//   myReq.app_create_flag='${app_create_flag}';
//   myReq.app_show_flag='${app_show_flag}';
//   myReq.app_delete_flag='${app_delete_flag}';
//   myReq.app_update_flag='${app_update_flag}';
  
//   myReq.pat_create_flag='${pat_create_flag}';
//   myReq.pat_show_flag='${pat_show_flag}';
//   myReq.pat_delete_flag='${pat_delete_flag}';
//   myReq.pat_update_flag='${pat_update_flag}';
  
//  	 myReq.doc_create_flag='${doc_create_flag}';
//   myReq.doc_show_flag='${doc_show_flag}';
//   myReq.doc_delete_flag='${doc_delete_flag}';
//   myReq.doc_update_flag='${doc_update_flag}';
  
//   	 myReq.med_create_flag='${med_create_flag}';
//   myReq.med_show_flag='${med_show_flag}';
//   myReq.med_delete_flag='${med_delete_flag}';
//   myReq.med_update_flag='${med_update_flag}';
  
//   myReq.vDoc_create_flag='${vDoc_create_flag}';
//   myReq.vDoc_show_flag='${vDoc_show_flag}';
//   myReq.vDoc_delete_flag='${vDoc_delete_flag}';
//   myReq.vDoc_update_flag='${vDoc_update_flag}';
  
// 	 myReq.icu_create_flag='${icu_create_flag}';
//   myReq.icu_show_flag='${icu_show_flag}';
//   myReq.icu_delete_flag='${icu_delete_flag}';
//   myReq.icu_update_flag='${icu_update_flag}';
 
//------------on page load-----------
//========app
// if(myReq.app_create_flag=='Y'){
//  $("#app_create_flag").attr("checked", "checked");
// }else{
//  $("#app_create_flag").removeAttr("checked", "checked");
// }

// if(myReq.app_delete_flag=='Y'){
//  $("#app_delete_flag").attr("checked", "checked");
// }else{
//  $("#app_delete_flag").removeAttr("checked", "checked");
// }

// if(myReq.app_show_flag=='Y'){
//  $("#app_show_flag").attr("checked", "checked");
// }else{
//  $("#app_show_flag").removeAttr("checked", "checked");
// }

// if(myReq.app_update_flag=='Y'){
//  $("#app_update_flag").attr("checked", "checked");
// }else{
//  $("#app_update_flag").removeAttr("checked", "checked");
// }
// //============patient
// if(myReq.pat_create_flag=='Y'){
//  $("#pat_create_flag").attr("checked", "checked");
// }else{
//  $("#pat_create_flag").removeAttr("checked", "checked");
// }

// if(myReq.pat_delete_flag=='Y'){
//  $("#pat_delete_flag").attr("checked", "checked");
// }else{
//  $("#pat_delete_flag").removeAttr("checked", "checked");
// }

// if(myReq.pat_show_flag=='Y'){
//  $("#pat_show_flag").attr("checked", "checked");
// }else{
//  $("#pat_show_flag").removeAttr("checked", "checked");
// }

// if(myReq.pat_update_flag=='Y'){
//  $("#pat_update_flag").attr("checked", "checked");
// }else{
//  $("#pat_update_flag").removeAttr("checked", "checked");
// }
// //=========doc
// if(myReq.doc_create_flag=='Y'){
//  $("#doc_create_flag").attr("checked", "checked");
// }else{
//  $("#doc_create_flag").removeAttr("checked", "checked");
// }

// if(myReq.doc_delete_flag=='Y'){
//  $("#doc_delete_flag").attr("checked", "checked");
// }else{
//  $("#doc_delete_flag").removeAttr("checked", "checked");
// }

// if(myReq.doc_show_flag=='Y'){
//  $("#doc_show_flag").attr("checked", "checked");
// }else{
//  $("#doc_show_flag").removeAttr("checked", "checked");
// }

// if(myReq.doc_update_flag=='Y'){
//  $("#doc_update_flag").attr("checked", "checked");
// }else{
//  $("#doc_update_flag").removeAttr("checked", "checked");
// }
// //===med


//   if(myReq.med_create_flag=='Y'){
//  $("#med_create_flag").attr("checked", "checked");
// }else{
//  $("#med_create_flag").removeAttr("checked", "checked");
// }

// if(myReq.med_delete_flag=='Y'){
//  $("#med_delete_flag").attr("checked", "checked");
// }else{
//  $("#med_delete_flag").removeAttr("checked", "checked");
// }

// if(myReq.med_show_flag=='Y'){
//  $("#med_show_flag").attr("checked", "checked");
// }else{
//  $("#med_show_flag").removeAttr("checked", "checked");
// }

// if(myReq.med_update_flag=='Y'){
//  $("#med_update_flag").attr("checked", "checked");
// }else{
//  $("#med_update_flag").removeAttr("checked", "checked");
// }

// //===vDoc 

//   if(myReq.vDoc_create_flag=='Y'){
//  $("#vDoc_create_flag").attr("checked", "checked");
// }else{
//  $("#vDoc_create_flag").removeAttr("checked", "checked");
// }

// if(myReq.vDoc_delete_flag=='Y'){
//  $("#vDoc_delete_flag").attr("checked", "checked");
// }else{
//  $("#vDoc_delete_flag").removeAttr("checked", "checked");
// }

// if(myReq.vDoc_show_flag=='Y'){
//  $("#vDoc_show_flag").attr("checked", "checked");
// }else{
//  $("#vDoc_show_flag").removeAttr("checked", "checked");
// }

// if(myReq.vDoc_update_flag=='Y'){
//  $("#vDoc_update_flag").attr("checked", "checked");
// }else{
//  $("#vDoc_update_flag").removeAttr("checked", "checked");
// }

// //icu

//   if(myReq.icu_create_flag=='Y'){
//  $("#icu_create_flag").attr("checked", "checked");
// }else{
//  $("#icu_create_flag").removeAttr("checked", "checked");
// }

// if(myReq.icu_delete_flag=='Y'){
//  $("#icu_delete_flag").attr("checked", "checked");
// }else{
//  $("#icu_delete_flag").removeAttr("checked", "checked");
// }

// if(myReq.icu_show_flag=='Y'){
//  $("#icu_show_flag").attr("checked", "checked");
// }else{
//  $("#icu_show_flag").removeAttr("checked", "checked");
// }

// if(myReq.icu_update_flag=='Y'){
//  $("#icu_update_flag").attr("checked", "checked");
// }else{
//  $("#icu_update_flag").removeAttr("checked", "checked");
// }



//-----------------------------------------------------------------------------
//appointment
//update flag
$("#app_update_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.app_update_flag = 'Y';
    }
    else {
        myReq.app_update_flag = 'N';
    }
  }
)
//app_show_flag
$("#app_show_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.app_show_flag = 'Y';
    }
    else {
        myReq.app_show_flag = 'N';
    }
  }
)
//create flag
$("#app_create_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.app_create_flag = 'Y';
    }
    else {
        myReq.app_create_flag = 'N'; }
}
)

//delete flag
$("#app_delete_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.app_delete_flag = 'Y';
    }
    else {
        myReq.app_delete_flag = 'N';
    }
}
)
//patient------
//update flag
$("#pat_update_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.pat_update_flag = 'Y';
    }
    else {
        myReq.pat_update_flag = 'N';
    }
  }
)
//pat_show_flag
$("#pat_show_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.pat_show_flag = 'Y';
    }
    else {
        myReq.pat_show_flag = 'N';
    }
  }
)
//create flag
$("#pat_create_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.pat_create_flag = 'Y';
    }
    else {
        myReq.pat_create_flag = 'N'; }
}
)

//delete flag
$("#pat_delete_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.pat_delete_flag = 'Y';
    }
    else {
        myReq.pat_delete_flag = 'N';
    }
}
)

//-----doc
//update flag
$("#doc_update_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.doc_update_flag = 'Y';
    }
    else {
        myReq.doc_update_flag = 'N';
    }
  }
)
//doc_show_flag
$("#doc_show_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.doc_show_flag = 'Y';
    }
    else {
        myReq.doc_show_flag = 'N';
    }
  }
)
//create flag
$("#doc_create_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.doc_create_flag = 'Y';
    }
    else {
        myReq.doc_create_flag = 'N'; }
}
)

//delete flag
$("#doc_delete_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.doc_delete_flag = 'Y';
    }
    else {
        myReq.doc_delete_flag = 'N';
    }
}
)

//-------medicine

//update flag
$("#med_update_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.med_update_flag = 'Y';
    }
    else {
        myReq.med_update_flag = 'N';
    }
  }
)
//med_show_flag
$("#med_show_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.med_show_flag = 'Y';
    }
    else {
        myReq.med_show_flag = 'N';
    }
  }
)
//create flag
$("#med_create_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.med_create_flag = 'Y';
    }
    else {
        myReq.med_create_flag = 'N'; }
}
)

//delete flag
$("#med_delete_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.med_delete_flag = 'Y';
    }
    else {
        myReq.med_delete_flag = 'N';
    }
}
)
//---vDoc
//update flag
$("#vDoc_update_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.vDoc_update_flag = 'Y';
    }
    else {
        myReq.vDoc_update_flag = 'N';
    }
  }
)
//vDoc_show_flag
$("#vDoc_show_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.vDoc_show_flag = 'Y';
    }
    else {
        myReq.vDoc_show_flag = 'N';
    }
  }
)
//create flag
$("#vDoc_create_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.vDoc_create_flag = 'Y';
    }
    else {
        myReq.vDoc_create_flag = 'N'; }
}
)

//delete flag
$("#vDoc_delete_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.vDoc_delete_flag = 'Y';
    }
    else {
        myReq.vDoc_delete_flag = 'N';
    }
}
)
//icu
//update flag
$("#icu_update_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.icu_update_flag = 'Y';
    }
    else {
        myReq.icu_update_flag = 'N';
    }
  }
)
//icu_show_flag
$("#icu_show_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.icu_show_flag = 'Y';
    }
    else {
        myReq.icu_show_flag = 'N';
    }
  }
)
//create flag
$("#icu_create_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.icu_create_flag = 'Y';
    }
    else {
        myReq.icu_create_flag = 'N'; }
}
)

//delete flag
$("#icu_delete_flag").on('change', function() {
    if ($(this).is(':checked')) {
        myReq.icu_delete_flag = 'Y';
    }
    else {
        myReq.icu_delete_flag = 'N';
    }
}
)

//----------------------ajax call
 $("#submitData").click(function(){
    $.post("saveStatus",
    myReq,
    function(data,status){
      window.location="/Dashboard";
    });
  });

});


</script>
</body>
</html>
