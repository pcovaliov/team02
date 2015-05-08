<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>

<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">

</head>
<body>

	<h1>Area for edit users</h1>

	<h1 class="register-title"">Welcome</h1>
	<form:form method="post" commandName="user" class="register">

		<form:label path="firstname">First Name</form:label>
		<form:input path="firstname" class="register-input" />
		<form:errors path="firstname" cssClass="error" />

		<form:label path="lastname">Last name</form:label>
		<form:input path="lastname" class="register-input" />
		<form:errors path="lastname" cssClass="error" />

		<form:label path="email">Email</form:label>
		<form:input path="email" class="register-input" />
		<form:errors path="email" cssClass="error" />
		<br>
		<button class="register-button" type="submit">Edit</button>

	</form:form>





</body>
</html>