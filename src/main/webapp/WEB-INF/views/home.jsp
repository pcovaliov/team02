<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


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
    <link href="resources/css/stanley/css/displayTweets.css" rel="stylesheet">
    <link href="resources/css/stanley/css/iphone.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="resources/css/stanley/js/hover.zoom.js"></script>
    <script src="resources/css/stanley/js/hover.zoom.conf.js"></script>
    <script src="resources/css/stanley/js/charCount.js"></script>
    
    <!-- Script for Characters Counter -->
    <script type="text/javascript">
	$(document).ready(function(){	
		$("#message").charCount({
			allowed: 147,		
			warning: 20,
			counterText: 'Characters left : '	
		});
	});
</script>

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

	<!-- +++++ Welcome Section +++++ -->
	<div id="ww">
	    <div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 centered" style='float: none'>
					<img src="resources/css/stanley/img/user.png" alt="Stanley">
					<h1> ${principal.firstname} ${principal.lastname}</h1>
					<p>Hello everybody. I'm ${principal.firstname} ${principal.lastname} , you can follow me !</p>
					
					
					
<style>
.brd {
    border: 4px solid #1abc9c;  
    padding: 10px; 
    border-radius : 20px;
   }
   </style>					
					
<style>
textarea {
    align : center;
}
label{
	display:block;
	font-size:14px;
	}
form .counter{
	position:absolute;
	right:0;
	top:0;
	font-size:20px;
	font-weight:bold;
	color:#600;
	}
form .warning{color:#e00;}	
form .exceeded{color:#e00;}	
.counter{
margin-top : 325px;
margin-right: 5%;


}
</style>

<div class = "brd">
<div>
<h4 align = "left">Tweet Editor :</h4>
        <div style='width="100%"'>
          
            <div class="form-group">
              
           
                <form:form method="post"  commandName="tweetObject"> 
                
                 <form:textarea rows="5" cols="50" path="tweet" id = "message" cssClass="form-control" placeholder = "Tweet ..." />  
                  <form:errors path="tweet" cssClass="error" />
                  
                  <br>
                  <input type="submit" value="Tweet" />
                  
                </form:form>
              
            </div> 
 		</div>
 	</div>
 	</div>
 			
				</div><!-- /col-lg-8 -->
				
				
				<!-- Display the tweets -->
				
				
<br>
<br>
<br>
  
  <header class="top-bar">
    
    <div >   
  <h1 align ="center">Tweets timeline</h1>
    </div>
    
  </header>
  
  <ol class="discussion">
       
      <div class="messages">
        
    

      <c:forEach items="${tweetList}" var="tweet">
		
		  <div class="from-me">								
		    ${tweet.getTweet()}
		    <br>
		    
			<span class="datedisplay">Posted : <fmt:formatDate value="${tweet.getDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
			</div>
					<br>
					<br>
					<br>
					<br>	
				  </c:forEach>
				 
				  </section>
				   
        
      </div>
    </li>
    
  </ol>
  


     
    
				
			</div><!-- /row -->
			
			
	    </div> <!-- /container -->
	</div><!-- /ww -->
	
	
	<!-- +++++ Projects Section +++++ -->

	
	
	
	<!-- +++++ Footer Section +++++ -->
	
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h4>Central Office</h4>
					<p>
						Sfatul Tarii 17,<br/>
						+373 79815713, <br/>
						+373 78930254, <br/>
						Moldova, Chisinau.
					</p>
				</div><!-- /col-lg-4 -->
				
				<div class="col-lg-4">
					<h4>My Links</h4>
					<p>
						<a href="#">Dribbble</a><br/>
						<a href="#">Twitter</a><br/>
						<a href="#">Facebook</a>
					</p>
				</div><!-- /col-lg-4 -->
				
				<div class="col-lg-4">
					<h4>About ConnectER</h4>
					<p> CONNECTER is a DEMO application. It should have TWITTER functionality , and it was developed by ENDAVA Interns </p>
					
				</div><!-- /col-lg-4 -->
			
			</div>
		
		</div>
	</div>
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="resources/css/stanley/js/bootstrap.min.js"></script>
  </body>
</html>
