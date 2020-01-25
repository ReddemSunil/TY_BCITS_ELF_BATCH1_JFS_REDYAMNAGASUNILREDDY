<%@page import="org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg=(String) request.getAttribute("msg"); 
    String errMsg=(String) request.getAttribute("errMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./createCookie">Click Here</a> To Create Cookie.<br>
	<a href="./readCookie">Click Here</a> To Read Cookie.
	
	<%if(msg!=null && !msg.isEmpty()){ %>
	<h3 style="color: green"><%=msg %></h3>
	<%} %>
	
	<%if(errMsg!=null && !errMsg.isEmpty()){ %>
	<h3 style="color: red"><%=errMsg %></h3>
	<%} %>
</body>
</html>