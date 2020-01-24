<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Employee Login</legend>	
		<!-- <form action="./login1" method="post"> -->
		<!-- <form action="./login2" method="post"> -->
		<!-- <form action="./login3" method="post"> -->
		<form action="./login4" method="post">
			<table>
				<tr>
					<td>Employee Id</td>
					<td> : </td>
					<td><input type="text" name="empId"> </td>
				</tr>
				<tr>
					<td>password</td>
					<td> : </td>
					<td><input type="password" name="password"> </td>
				</tr>
				<tr>
					<td>name</td>
					<td> : </td>
					<td><input type="text" name="name"> </td>
				</tr>
				<tr>
					<td colspan="3"> <br>
					<input type="submit"> </td>
					
				</tr>
			</table>
		
		</form>
	</fieldset>
	
</body>
</html>