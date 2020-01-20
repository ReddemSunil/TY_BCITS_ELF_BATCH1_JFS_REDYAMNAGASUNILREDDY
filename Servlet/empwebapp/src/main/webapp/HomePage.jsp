<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% EmployeePrimaryInfo emInfo=(EmployeePrimaryInfo) session.getAttribute("loggedInfo");%>
    
<<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> welcome <%=emInfo.getName() %>...</h1>
</body>
</html>