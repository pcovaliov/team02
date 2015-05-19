<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/stanley/css/iphone.css" rel="stylesheet">

</head>
<body>

 <script type="text/javascript">
	$(document).ready(function(){
		
		    var parent = document.getElementById('test'); // div cu mesaje
			var sibling = parent.children.item(); //primu div in fata cui faci insert
			document.body.appendChild(div);                     //var text = document.createTextNode('new text'); //textul de insert
			parent.insertBefore(text, sibling); // insert action
	});
</script>



</body>
</html>