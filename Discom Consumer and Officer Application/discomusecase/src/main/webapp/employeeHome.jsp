<%@page import="com.bcits.discomusecase.bean.EmployeeInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%String errMsg=(String)request.getAttribute("errMsg");
  	List<String> list=(List<String>)request.getAttribute("list");
  	EmployeeInfo employeeInfo=(EmployeeInfo)request.getAttribute("employee");
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
<link rel="stylesheet" href="${css}/dropdown.css">
</head>
<body style="background-color: lightgreen;"><br><br>
	<h3 style="color: navy;text-align: center;">
	  Employee Name   : <%=employeeInfo.getName() %><br>
	  Employee Id     : <%=employeeInfo.getEmpId() %><br>
	  Employee Region : <%=employeeInfo.getRegion()%><br>
	
	</h3><br>
	<%if(list!=null&&!list.isEmpty()){ %>
	<h5>
		<table align="center" border="1" style="width: 80%;height: 50%;">
			<tr style="background-color: lightblue;">
				<th>RR Numbers</th>
				<th>Updation</th>
			</tr>
		<%for(String string:list){ %>
			<tr style="background-color:lime;">
				<td><%=string %></td>
				<td><a><button style="background-color: green;">Update Bill</button></a></td>
		<%} %>
		</table>
		</h5>
	<%} %>



<%if(errMsg!=null&&!errMsg.isEmpty()) {%>
		<h2 style="color: red; text-align: center;"><%=errMsg %></h2>
	<%} %>
<script src="${js}/jquery-3.4.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>
</body>
</html>