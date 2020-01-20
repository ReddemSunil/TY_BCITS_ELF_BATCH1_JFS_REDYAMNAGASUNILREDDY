<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%String msg=(String)request.getAttribute("msg"); %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Employee Login</legend>
		<form action="./login2" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="number" name="empId" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Login"></td>

				</tr>
			</table>
		</form>
	</fieldset>
	<%if(msg!=null && !msg.isEmpty()){ %>
		<h3 style="color:navy;"> <%=msg %></h3>
	<%} %>
</body>
</html>