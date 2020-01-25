<%@page import="com.bcits.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />

<%EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)request.getAttribute("employeeInfoBean");
	String errMsg=(String)request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<legend>Search Employee</legend>
	<form action="./search">
	EmployeeID:<input type="text" name="empId" required="required"><br>
	<input type="submit" value="search">
	</form>
	</fieldset>
	<%if(errMsg!=null && !errMsg.isEmpty()) {%>
	
		<h2 style="color: red"><%=errMsg %></h2>
	<%} %>
	
	
	<%if(employeeInfoBean!=null){ %>
	
		<table border="1"style="width: 70%">
			<tr style="background-color: navy;color: pink">
				<th>Employee Id</th>
				<th>name</th>
				<th>designation</th>
				<th>dob</th>
				<th>salary</th>
				<th>mobileno</th>
			</tr>
			<tr>
				<td><%=employeeInfoBean.getEmpId() %></td>
				<td><%=employeeInfoBean.getName() %></td>
				<td><%=employeeInfoBean.getDesignation() %></td>
				<td><%=employeeInfoBean.getDateOfBirth() %></td>
				<td><%=employeeInfoBean.getSalary() %></td>
				<td><%=employeeInfoBean.getMobileno() %></td>
			
			</tr>
		</table>
	<%} %>
</body>
</html>
<jsp:include page="footer.jsp" />