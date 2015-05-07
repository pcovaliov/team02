<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<html>

<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="resources/css/navigation_menu.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"/>
</head>
<body>
<sec:authentication var="principal" property="principal" />

<div>
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
	</div>
	
	<br>
	<br>
	<br>
	<br>
	



<style>
textarea {
    resize: none;
    align : center;
    border: 3px double #CCCCCC;
	border: 2px solid #765942;
	border-radius: 10px;
	
	
}
</style>

<div  align = "center">
<h3 align = "center">Write your tweet buddy :</h3>
<br>
        <div class="col-lg-4">
          
            <div class="form-group">
              
           
                <form:form method="post"  commandName="tweetObject"> 
                
                 <form:textarea rows="8" cols="50" path="tweet"  cssClass="form-control" />  
                  <form:errors path="tweet" cssClass="error" />
                  
                  <br>
                  <input type="submit" value="Tweet" />
                  
                </form:form>
              
            </div> 
 		</div>
 	</div>
 	
 	<br>
 	<br>
 	<br>
 	<br>
 	
 	
 	
 	<div align = "center">
          <h2> Tweets Timeline </h2>
          <div class="table-responsive">
            <table  id="tweet-table" class="table table-striped">
              <thead>
                <tr>
                 
                  <th>Tweet</th>
                  <th>Date</th>
                </tr>
              </thead>
              <tbody>
	              <c:forEach items="${tweetList}" var="tweet">
							<tr>
								
								<td>${tweet.getTweet()}</td>
								<td><fmt:formatDate value="${tweet.getDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
				  </c:forEach>
				  
				    <tr>
				    	<td><a href="${prevTweetsLink}">Prev</a></td>
					    <td><a href="${nextTweetsLink}">Next</a></td>
					</tr>
              </tbody>
            </table>
        </div>
       </div>

    </div>
 	
 	

</body>
</html>
