<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%EmpInfoBean infoBean=(EmpInfoBean)request.getAttribute("empInfoBean");

%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="./getEmployee">
			<fieldset style="width: 60%">
				<legend>Search Employee</legend>
				Employee Id : <input type="number" name="empId" required="required"><br>
				<input type="submit" name="Search">
			</fieldset>
		
		
		</form>
	<%if(infoBean!=null){ %>
	<table>
		<thead>
			<tr style="color: white;background: navy">
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Password</th>
				<th>Role</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=infoBean.getEmpId() %></td>
				<td><%=infoBean.getName() %></td>
				<td><%=infoBean.getPassword() %></td>
				<td><%=infoBean.getRole() %></td>
			</tr>
		</tbody>
	</table>
<%}else{%>
	<h3 style="color: red; ">Employee Id Not Found!!!</h3>
	
<%} %>
	</div>
</body>
</html>
