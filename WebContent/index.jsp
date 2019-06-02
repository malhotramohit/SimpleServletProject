<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyApp</title>
</head>
<body>
	<form method="post" action="login">
		Username : <input name="uname" type="text"> <br> Password
		: <input name="pswd" type="text"> <br> <br> <input
			type="submit">
	</form>
	<strong> <%
 	String errorMsg = null;
 	errorMsg = (String) request.getAttribute("errorString");
 	if (null != errorMsg) {
 %> <%=errorMsg%><%
 	}
 %>


	</strong>
</body>
</html>