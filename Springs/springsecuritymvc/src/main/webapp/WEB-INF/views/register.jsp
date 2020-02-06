<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%String msg=(String) request.getAttribute("msg");
 String errMsg=(String) request.getAttribute("errMsg");
 %>
<jsp:include page="index.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Register</legend>
		<form action="./register" method="post">
			<table>
				<tr>
					<td>Employee Id</td>
					<td> : </td>
					<td><input type="number" name="empId" required="required"> </td>
				</tr>
				<tr>
					<td>Password</td>
					<td> : </td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td> : </td>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<td>Role</td>
					<td> : </td>
					<td><input type="radio" name="role" value="ROLE_USER">User</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="radio" name="role" value="ROLE_ADMIN">Admin</td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit" value="Register" ></td>
				</tr>
			</table>
		</form>
	</fieldset>
	
	<div align="center">
		<%if(errMsg!=null && !errMsg.isEmpty()){ %>
			<h3 style="color: red;"><%=errMsg %></h3>
		<%} %>
		<%if(msg!=null && !msg.isEmpty()){ %>
			<h3 style="color: green;"><%=msg %></h3>
		<%} %>
	</div>
</body>
</html>