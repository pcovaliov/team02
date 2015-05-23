<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>

<link rel="stylesheet" type="text/css" href="/endavainternship/resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="/endavainternship/resources/css/bootstrap.css">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Home Page </title>

    <!-- Bootstrap core CSS -->
    
    <link rel="stylesheet" type="text/css" href="/endavainternship/resources/css/stanley/css/bootstrap.css"/>


    <!-- Custom styles for this template -->
    <link href="/endavainternship/resources/css/stanley/css/main.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="/endavainternship/resources/css/stanley/js/hover.zoom.js"></script>
    <script src="/endavainternship/resources/css/stanley/hover.zoom.conf.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->


</head>
<body><!-- Static navbar -->
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
             </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

	

	<h1 class="register-title"">Management Zone</h1>
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
		
		<form:input type="hidden"  path="imageName" class="register-input" />
		
		<br>
		<button class="register-button" type="submit">Edit</button>

	</form:form>





</body>
</html>