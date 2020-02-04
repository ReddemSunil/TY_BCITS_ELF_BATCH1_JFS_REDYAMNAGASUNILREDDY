<%@page import="com.bcits.discomusecase.bean.MonthlyConsumtion"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%String errMsg=(String)request.getAttribute("errMsg");
 	List<MonthlyConsumtion> list=(List<MonthlyConsumtion>)request.getAttribute("list");
	SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
	String rrNumber=(String)request.getAttribute("rrNumber");
%>
<jsp:include page="header.jsp"/>
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
<body style="background-color: lightgreen;"><br><br>
	<h3 style="color: navy;text-align: center;">History Of RR Number : <%=rrNumber %></h3><br>
	<%if(list!=null&&!list.isEmpty()){ %>
	<h5>
		<table align="center" border="1" style="width: 80%;height: 50%;">
			<tr style="background-color: lightblue;">
				<th>Readings Taken On</th>
				<th>Units Consumed</th>
				<th>Initial Units</th>
				<th>Final Units</th>
				<th>Due Date</th>
				<th>Amount</th>
			</tr>
		<%for(MonthlyConsumtion consumtion:list){ %>
			<tr style="background-color:lime;">
				<td><%=format.format(consumtion.getMoPk().getReadingsTakenOn()) %></td>
				<td><%=consumtion.getUnitsConsumed() %></td>
				<td><%=consumtion.getInitialUnits() %></td>
				<td><%=consumtion.getFinalUnits() %></td>
				<td><%=format.format(consumtion.getDueDate()) %></td>
				<td><%=consumtion.getAmount() %></td>
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