<%@page import="com.bcits.springmvc.beans.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%List<EmployeeInfoBean> list=(List<EmployeeInfoBean>)request.getAttribute("employeeInfoBean"); 
    String errMsg=(String)request.getAttribute("errMsg");
    %>
    <jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%if(errMsg!=null && !errMsg.isEmpty()) {%>
	
		<h2 style="color: red"><%=errMsg %></h2>
	<%} %>
	
	
	<%if(list!=null){ %>
	
		<table border="1"style="width: 70%">
			<tr style="background-color: navy;color: pink">
				<th>Employee Id</th>
				<th>name</th>
				<th>designation</th>
				<th>dob</th>
				<th>salary</th>
				<th>mobileno</th>
			</tr>
			<%for(EmployeeInfoBean employeeInfoBean:list){ %>
			<tr>
				<td><%=employeeInfoBean.getEmpId()%></td>
				<td><%=employeeInfoBean.getName() %></td>
				<td><%=employeeInfoBean.getDesignation() %></td>
				<td><%=employeeInfoBean.getDateOfBirth()%></td>
				<td><%=employeeInfoBean.getSalary() %></td>
				<td><%=employeeInfoBean.getMobileno()%></td>
			
			</tr>
			<%} %>
		</table>
	<%} %>
	<jsp:include page="footer.jsp"/>
</body>
</html>