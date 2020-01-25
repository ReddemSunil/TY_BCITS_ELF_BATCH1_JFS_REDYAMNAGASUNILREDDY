<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp" />
   <% String msg=(String) request.getAttribute("msg");
   String errMsg=(String) request.getAttribute("errMsg");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee portal</title>
</head>
<body>
	<fieldset>
	<legend>Delete Employee</legend>
	<form action="./delete">
	EmployeeID:<input type="text" name="empId" required="required"><br>
	<input type="submit" value="delete">
	</form>
	</fieldset>
	
	<%if(msg!=null && !msg.isEmpty()){ %>
	
		<h3 style="color: green"><%=msg %></h3>
		
	<%} %>
	
	<%if(errMsg!=null && !errMsg.isEmpty()){ %>
	
		<h3 style="color: red"><%=errMsg %></h3>
		
	<%} %>
	<jsp:include page="footer.jsp" />
</body>
</html>