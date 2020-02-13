<%@page import="java.util.ArrayList"%>
<%@page import="com.bcits.discomusecase.bean.PaymentDetails"%>
<%@page import="com.bcits.discomusecase.bean.EmployeeInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%String errMsg=(String)request.getAttribute("errMsg");
  	EmployeeInfo employeeInfo=(EmployeeInfo)request.getAttribute("employee");
	List<Object[]> list=(List<Object[]>)request.getAttribute("list");
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
	<h3 style="color: navy;text-align: center;">
	  Employee Name   : <%=employeeInfo.getName() %><br>
	  Employee Id     : <%=employeeInfo.getEmpId() %><br>
	  Employee Region : <%=employeeInfo.getRegion()%><br>
	
	</h3><br>
	<%if(list!=null&&!list.isEmpty()){ %>
	<h5 align="center">
		<table align="center" style="width: 60%;height: 50%;">
			<tr style="color:orange;">
				<th>Date</th>
				<th>Amount</th>
				<th>Amount Collected</th>
			</tr>
		<%for(Object[] obj:list){ %>
			<tr style="color:purple;">
				<td><%=obj[0]%></td>
				<td><%=obj[1]%></td>
				<td><%=obj[2]%></td>
			</tr>
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