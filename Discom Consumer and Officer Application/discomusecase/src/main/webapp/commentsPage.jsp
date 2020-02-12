<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.bean.ContactUsInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%String errMsg=(String)request.getAttribute("errMsg");
     String msg=(String)request.getAttribute("msg");
		List<ContactUsInfo> list=(List<ContactUsInfo>)request.getAttribute("list");
     %>
 <jsp:include page="employeeHeader.jsp"/>  
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
    <%@include file="./Bootstrap/bootstrap-4.4.1-dist/css/bootstrap.min.css" %>
    
</style>
</head>
<body style="background-color: lightblue;"><br><br>
<h3 style="color:maroon; text-align:center;">Consumer Needs You Help</h3><br>

	<%if(list!=null&&!list.isEmpty()){ %>
	<h5>
		<table align="center" style="width: 80%;height: 50%;">
			<tr style="color:orange;">
				<th>RR Numbers</th>
				<th>Name</th>
				<th>Mail</th>
				<th>comments</th>
				<th>Response</th>
			</tr>
		<%for(ContactUsInfo details:list){ %>
			<tr style="color:navy;">
				<td><%=details.getRrNumber() %></td>
				<td><%=details.getName() %></td>
				<td><%=details.getMail()%></td>
				<td><%=details.getComments() %></td>
				<td><a href="../employee/responsePage?rrNumber=<%=details.getRrNumber()%>">Replay</a></td>
		<%} %>
		</table>
		</h5>
	<%} %>



<%if(errMsg!=null&&!errMsg.isEmpty()) {%>
		<h2 style="color: red; text-align: center;"><%=errMsg %></h2>
	<%} %>
	<%if(msg!=null&&!msg.isEmpty()) {%>
		<h2 style="color: green; text-align: center;"><%=msg %></h2>
	<%} %>
<script src="${js}/jquery-3.4.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>
</body>
</html>