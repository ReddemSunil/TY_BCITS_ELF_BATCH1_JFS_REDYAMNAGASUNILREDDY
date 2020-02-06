<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./login" method="post">
		<label>UserName</label><br>
		<input type="text" name="username" required="required"><br>
		<label>Password</label><br>
		<input type="password" name="password" required="required"><br>
		<input type="submit" value="Login">
	
	</form>
</body>
</html>