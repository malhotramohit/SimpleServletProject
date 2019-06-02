<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyApp</title>
</head>
<body>


	<h1>Login Successful</h1>
	<br>
	<h2>
		Hello
		<%=request.getSession().getAttribute("username")%>
	</h2>
	<br>
	<i>Password is</i>
	<br>
	<%=request.getAttribute("password")%>

	<form method="post" action="home">
		Username : <input name="uname" type="text"> <br> Password
		: <input name="pswd" type="text"> <br> <br> <input
			type="submit">
	</form>
</body>
</html>


