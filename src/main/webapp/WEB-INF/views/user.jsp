<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Display</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/navigation_menu.css"/>

</head>
<body>
<sec:authentication var="principal" property="principal" />

<header>
	<nav role="navigation">
		<ul>
			<li>
				<a href="/endavainternship/">
					<div>
						Home
						<span>there's no place like it</span>
					</div>
				</a>
			</li>
			
			<li>
				<a href="/endavainternship/user.html">
					<div>
						Users
						<span>let's see the others users</span>
					</div>
				</a>
			</li>
			<li>
			<a href="<c:url value='/j_spring_security_logout'/>">
              
					<div>
					Logout
						<span>We wish you a good day ! </span>
						
					</div>
				</a>
			</li>
			
			<li>Hello,<br> ${principal.firstname} ${principal.lastname} <br> ${principal.role}</li>
			
			
			
			
		</ul>
	</nav>
</header>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	

	<div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Manage User</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.getId()}</td>
						<td>${user.getFirstname()}</td>
						<td>${user.getLastname()}</td>
						<td>${user.getEmail()}</td>
						<td>
								<a href="/endavainternship/delete-user/${user.getId()}">delete</a> /
									
								<a href="/endavainternship/edit-user/${user.getId()}">edit</a>
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>