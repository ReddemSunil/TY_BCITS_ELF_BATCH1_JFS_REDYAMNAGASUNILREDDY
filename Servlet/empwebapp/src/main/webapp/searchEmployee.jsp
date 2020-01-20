<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%EmployeePrimaryInfo employeePrimaryInfo=(EmployeePrimaryInfo)request.getAttribute("empInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Search Employee</legend>
		
		<form action="./getEmp">
			<label>Employee ID:</label>
			<input type="text" name="empId" required>
			<br>
			<input type="submit" value="search">
		</form>
	</fieldset>
	<% if(employeePrimaryInfo!=null){ %><br>
	EmpId = <%=employeePrimaryInfo.getEmpId() %><br>
	Name = <%=employeePrimaryInfo.getName() %><br>
	Designation = <%=employeePrimaryInfo.getDesignation() %><br>
	<%}else { %>
	<h2 style="color: red;">Employee Id not Find!!</h2>
	<%} %>
</body>
</html>