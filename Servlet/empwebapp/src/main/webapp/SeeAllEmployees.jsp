<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<EmployeePrimaryInfo> emList = (List<EmployeePrimaryInfo>) request.getAttribute("employeePrimaryInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (emList != null) {
	%>
	<table border="1" style="width: 80%; height: 50%">
		<thead style="background:navy; color:white;">
		<tr>
		<td>Employee Id</td>
		<td>Name</td>
		<td>Salary</td>
		<td>Designation</td>
		<td>DOB</td>
		<td>DOJ</td>
		<td>Mobile No</td>
		</tr>
		</thead>
		<tbody>
			<%for(EmployeePrimaryInfo emf:emList){ %>
			<tr>
				<td><%=emf.getEmpId() %></td>
				<td><%=emf.getName() %></td>
				<td><%=emf.getSalary() %></td>
				<td><%=emf.getDesignation()%></td>
				<td><%=emf.getDateOfBirth()%></td>
				<td><%=emf.getDateOfJoining()%></td>
				<td><%=emf.getMobileno()%></td>
			<%} %>
		</tbody>
	</table>
	<%
		} else {
	%>
	<h2 style="color:red;">No records to display</h2>
	<%
		}
	%>
</body>
</html>