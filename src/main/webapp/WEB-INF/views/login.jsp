<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<html>
	<head>
		<title>Login Page</title>
		<link rel="stylesheet" type="text/css" href="/endavainternship/resources/css/signup.css" />
	<!-- <link rel="stylesheet" type="text/css" href="/endavainternship/resources/css/background.css" /> -->	
		<script type="text/javascript" src="/endavainternship/resources/js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="/endavainternship/resources/js/signup.js"></script>
	</head>

	<body>
	
	<div id="background-wrap">
    <div class="x1">
        <div class="cloud"></div>
    </div>

    <div class="x2">
        <div class="cloud"></div>
    </div>

    <div class="x3">
        <div class="cloud"></div>
    </div>

    <div class="x4">
        <div class="cloud"></div>
    </div>

    <div class="x5">
        <div class="cloud"></div>
    </div>
</div>
	
	<!-- Related javascript - focus on menu tab -->
	<script>
	$(function() {
		if(location.search.split('error=').length == 2 )
			{
			$("#redirect_login_link").click();
			}
	});

	</script>
		
	<div class="form" style="margin-top:100px">
      <ul class="tab-group">
        <li class="tab active" id="sign-up-tab"><a href="#signup">Sign Up</a></li>
        <li class="tab " id="login-tab"><a href="#login" id="redirect_login_link">Log In</a></li>
      </ul>
      <div class="tab-content">
   <div id="signup"> 

         <h1>Sign Up for Free</h1>
          
          <form:form method="post" action="/endavainternship/register" commandName="user" enctype="multipart/form-data">
	     <div class="top-row">
	            <div class="field-wrap">
	              <label>
	                First Name<span class="req">*</span>
	              </label>
	              <form:input type="text" path="firstname" autocomplete="off"/>
	              <form:errors path="firstname"  />
	            </div>
	        
	            <div class="field-wrap">
	              <label>
	                Last Name<span class="req">*</span>
	              </label>
	              <form:input type="text" path="lastname" autocomplete="off"/>
	              <form:errors path="lastname"  />
	            </div>
	          </div>
	
	          <div class="field-wrap">
	            <label>
	              Email Address<span class="req">*</span>
	            </label>
	            <form:input type="text" path="email"  autocomplete="off" />
	              <form:errors path="email"  />
	          </div>
	          <div class="field-wrap">
	          	Image:
	          <input type="file" name="image">
	          </div>
	          
	          <button type="submit" class="button button-block"/>Get Started</button>
          </form:form>

        </div>
			
	        
	        
	        
	        
	        
	        
	        
	        
	        <div id="login">   
	          <h1>Welcome !</h1>
	          
	          <form action="<c:url value='j_spring_security_check' />" name='loginForm' method="post">
	          
	            <div class="field-wrap">
	            <label>
	              Email Address<span class="req">*</span>
	            </label>
	            <input name="email" type="email"required autocomplete="off"/>
	          </div> 
	          <p class="forgot"><a href="#">Forgot Password?</a></p>
	          
	          <button  type="submit" class="button button-block" />Log In</button>
	          
	          </form>
	
	        </div>
	        
	      </div><!-- tab-content -->
	      
	</div> <!-- /form -->
	</body>
</html>