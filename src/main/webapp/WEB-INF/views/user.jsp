<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Home Page </title>

    <!-- Bootstrap core CSS -->
    
    <link rel="stylesheet" type="text/css" href="resources/css/stanley/css/bootstrap.css"/>


    <!-- Custom styles for this template -->
    <link href="resources/css/stanley/css/main.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="resources/css/stanley/js/hover.zoom.js"></script>
    <script src="resources/css/stanley/hover.zoom.conf.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  <sec:authentication var="principal" property="principal" />

    <!-- Static navbar -->
    <div class="navbar navbar-inverse navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/endavainternship/">ConnectER</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/endavainternship/">Home</a></li>
            <li><a href="/endavainternship/user.html">Users</a></li>
            <li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    
   
    
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