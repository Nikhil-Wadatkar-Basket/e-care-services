<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Spring Boot Session Example</title>
</head>
<body>
	<div>

		<h1>Session management Demo</h1>

		<form action="/persistMessage" method="post">

			<textarea name="msg" cols="40" rows="2"></textarea>
			<br> <input type="submit" value="Save Message" />
		</form>

	</div>
	<div>
		<h2>Messages</h2>
		<%-- <ul>
			<li>${sessionMessages}</li>
		</ul> --%>
		<%-- <ul>
			<c:forEach var="emp" items="${sessionMessages}">
				<li>${emp}</li>
			</c:forEach>
		</ul> --%>
		${sessionMessages}

	</div>
	<div>
		<form action="/destroy" method="post">


			<br> <input type="submit" value="Destroy Session" />
		</form>
	</div>
</body>
</html>