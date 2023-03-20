<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html lang="en">

<head>
<title>E-Care App</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>

	<%-- 
	<%@include file="Navbar.jsp" %>
	 --%>
	<jsp:include page="Navbar.jsp" />


	<div class="container">
		<h3>Update Appointment</h3>

		   
       <form:form method="POST" action="/updateAppointment" modelAttribute="app">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="appID" /></td>  
         </tr>   
         <tr>  
        <td></td>    
         <td><form:hidden  path="userID" /></td>  
         </tr> 
         <tr>  
        <td></td>    
         <td><form:hidden  path="doctorID" /></td>  
         </tr> 
         <tr>    
          <td>Patient Name : </td>   
          <td><form:input path="patientName"  /></td>  
         </tr>  
         <tr>    
          <td>Doctor Name : </td>   
          <td><form:input path="doctorName"  /></td>  
         </tr>   
         <tr>    
          <td>Date :</td>    
          <td><form:input type="date" path="appDate"  /></td>  
         </tr>   
           
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>   		
	</div>

</body>

</html>