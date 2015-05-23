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
    
          <!-- Custom styles for pagination -->
    <link href="resources/css/stanley/css/paginate.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="resources/css/stanley/js/hover.zoom.js"></script>
    <script src="resources/css/stanley/hover.zoom.conf.js"></script>
    <script src="resources/css/stanley/js/jquery.paginate.js"></script>
    
    
    <!-- Script for display user -->
    
    <script type="text/javascript">
	$(function() {
		var pageNumber = ${pageNumber};
		if(pageNumber == 0)
		{$('.discussion').html('post a tweet buddy')}
		else
			$("#demo3").paginate(
				{
					count : pageNumber,
					start : 1,
					display : 10,
					border : true,
					border_color : '#BEF8B8',
					text_color : '#fff',
					background_color : '#0B93F6',
					border_hover_color : '#68BA64',
					text_hover_color : 'black',
					background_hover_color : '#fff',
					rotate : false,
					images : false,
					mouse : 'press',
					onChange : function(page) {
						$('._current', '#paginationdemo').removeClass(
								'_current').hide();
						$('#p' + page).addClass('_current').show();
					}
				});

	});
</script>

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
    
   <div class="row" style ="margin-left: 140px;">
       <div class="col-md-10 col-md-offset-1 centered" id="paginationdemo">
	      <c:forEach items="${userContainer}" var="item">
	          <div id="p${item.key}" class="pagedemo <c:if test="${item.key == 1}">_current</c:if>" <c:if test="${item.key != 1}">style="display:none;"</c:if>>
	              <c:forEach items="${item.value}" var="user">
	                 <div class="userDisplay">
	                   <p class="userNameDisplay"> ${user.getFirstname()}  ${user.getLastname()}</p>
	                   <p class="userEmailDisplay">${user.getEmail()}</p>
	                     <br>
	                     <br>
	                     <a href="/endavainternship/home/${user.getId()}"><img src="/images/${user.getImageName()}" alt="Stanley" width="155" height="155" class="userDisplayList"/></a>
	                        <c:if test="${principal.role == 'ROLE_ADMIN'}">
	                     <a href="/endavainternship/admin/delete-user/${user.getId()}" >delete</a> /
						 <a href="/endavainternship/admin/edit-user/${user.getId()}">edit</a>
						    </c:if>
	                  </div>
	               </c:forEach>
	           </div>
	       </c:forEach>
      </div> <!-- closing col-md-2 col-md-offset-1 div -->
    </div> <!-- closing row div -->
    <br>
    <br>
	<br>
	<br>
						
    
  <div class="col-md-10 col-md-offset-1 " style = "margin-left: -20px;">
      <div class="row">
           <div class="col-md-2 col-md-offset-5"> 
                <div id="demo3">
                </div>
           </div>
     </div>
</div>
   
</body>
</html>