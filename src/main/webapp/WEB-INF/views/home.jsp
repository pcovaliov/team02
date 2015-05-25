<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Home Page</title>

<!-- Bootstrap core CSS -->

<link rel="stylesheet" type="text/css"
	href="resources/css/stanley/css/bootstrap.css" />


<!-- Custom styles for this template -->

<link href="resources/css/stanley/css/main.css" rel="stylesheet">
<link href="resources/css/stanley/css/displayTweets.css"
	rel="stylesheet">
<link href="resources/css/stanley/css/iphone.css" rel="stylesheet">
<link href="resources/css/stanley/css/paginate.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="resources/css/stanley/js/hover.zoom.js"></script>
<script src="resources/css/stanley/js/hover.zoom.conf.js"></script>
<script src="resources/css/stanley/js/charCount.js"></script>
<script src="resources/css/stanley/js/jquery.paginate.js"></script>


<!-- Script for pagination -->

<script type="text/javascript">
	$(function() {
		var pageNumber = ${pageNumber};
		if(pageNumber == 0)
		{$('.discussion').html('<div class="alert-box notice"><span>notice: </span>No tweets avalaible.</div>')}
		else if(pageNumber == 1){}
		else
			$("#pagination").paginate(
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


<!-- Script for Characters Counter -->

<script type="text/javascript">
	$(document).ready(function() {
		$("#message").charCount({
			allowed : 140,
			warning : 20,
			counterText : 'Characters left : '
		});
	});
</script>
<style>
.bird{
width:180px;
}

</style>

</head>

<body>

	<sec:authentication var="principal" property="principal" />

	<!-- Static navbar -->

	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="container">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/endavainternship/">ConnectER</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/endavainternship/">Home</a></li>
					<li><a href="/endavainternship/user.html">Users</a></li>
					<li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>

				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
<br>
<br>
<br>
<div class="container">
	<!-- +++++ Welcome Section +++++ -->
	<div class="row">
		<div class="col-md-6 centered">
		<h1 align="center">User Profile</h1>
			 <img src="/images/${principal.imageName}" alt="Stanley" width="250" height="250" class="avatar">
					<h1>${principal.firstname} ${principal.lastname}</h1>
					<p>Hello everybody. I'm ${principal.firstname}
						${principal.lastname} , you can follow me !</p>

				<div class="tweet-form">
					<div>
						<h4 align="left">Tweet Editor :</h4>
						<div class="form-group">
							<form:form method="post" id="postSubmit"
								commandName="tweetObject">

								<form:textarea rows="6" cols="80" path="tweet" id="message"
									cssClass="form-control" placeholder="Tweet ..." />
								<form:errors path="tweet" cssClass="error" />

								<br>
								<input type="submit" value="Tweet" />
							</form:form>
						</div>
					</div>
				</div>
		</div>
        <div class="col-md-6">
          <h1 align="center">Tweets timeline</h1>
				<ol class="discussion">
					<div id="paginationdemo" class="demo">
						<c:forEach items="${tweetContainer}" var="item">
							<div id="p${item.key}" class="pagedemo <c:if test="${item.key == 1}">_current</c:if>" <c:if test="${item.key != 1}">style="display:none;"</c:if>>

								<c:forEach items="${item.value}" var="tweet">
									<div class="from-me">
									<a href="/endavainternship/delete-tweet/${tweet.getId()}"><span class="trash"><img src="resources/css/stanley/img/trash1.png" width="15px" height="15px"></span></a>
									<br>
										${tweet.getTweet()}
										
										
										 <br>
										     
										  <span class="datedisplay">Posted
											: <fmt:formatDate value="${tweet.getDate()}"
												pattern="yyyy-MM-dd HH:mm:ss" />
												
										</span>
									</div>
									
								</c:forEach>
							</div>
						</c:forEach>
					</div>
					<div class="messages">
					</div>
				<div id="pagination"></div>
				
				
				</ol>
		</div>
        
    </div>
					
					<!-- Styles for text area  -->
<style>
textarea {
	align: center;
	width:50%;
	resize: none;
}

label {
	display: block;
	font-size: 14px;
}

form .counter {
    width:100%;
	position: absolute;
	right: 0;
	top: 0;
	font-size: 20px;
	font-weight: bold;
	color: #600;
}

form .warning {
	color: #e00;
}

form .exceeded {
	color: #e00;
}

.counter {
	margin-top: 495px;
	margin-right: -170px;
}


</style>


</div>
<!-- /container -->

	<!-- +++++ Footer Section +++++ -->

	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h4>Central Office</h4>
					<p>
						Sfatul Tarii 17,<br /> +373 79815713, <br /> +373 78930254, <br />
						Moldova, Chisinau.
						
					</p>
				</div>
				<!-- /col-lg-4 -->

				<div class="col-lg-4">
					<img src="resources/css/stanley/img/bird.png"  class ="bird">
					
				</div>
				<!-- /col-lg-4 -->

				<div class="col-lg-4">
					<h4>About ConnectER</h4>
					<p>CONNECTER is a DEMO application. It should have TWITTER
						functionality , and it was developed by ENDAVA Interns</p>

				</div>
				<!-- /col-lg-4 -->

			</div>

		</div>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/css/stanley/js/bootstrap.min.js"></script>
</body>
</html>