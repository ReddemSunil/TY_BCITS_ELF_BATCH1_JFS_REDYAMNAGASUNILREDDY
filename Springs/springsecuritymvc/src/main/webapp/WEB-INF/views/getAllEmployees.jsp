<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%List<EmpInfoBean> list=(List<EmpInfoBean>)request.getAttribute("list"); %>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<%if(list!=null && !list.isEmpty()){ %>
	<table style="width: 70%">
		<thead>
			<tr style="color: white;background: navy">
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Password</th>
				<th>Role</th>
			</tr>
		</thead>
		<tbody>
		<%for(EmpInfoBean infoBean:list){ %>
			<tr>
				<td><%=infoBean.getEmpId() %></td>
				<td><%=infoBean.getName() %></td>
				<td><%=infoBean.getPassword() %></td>
				<td><%=infoBean.getRole() %></td>
			</tr>
		<%} %>
		</tbody>
	</table>
<%}else{%>
	<h3 style="color: red; ">No Records To Display!!!</h3>
	
<%} %>
	</div>
</body>
</html>