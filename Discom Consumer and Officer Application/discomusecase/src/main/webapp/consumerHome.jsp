<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomusecase.bean.ConsumerCurrentBill"%>
<%@page import="com.bcits.discomusecase.bean.ConsumerInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%ConsumerCurrentBill cBill=(ConsumerCurrentBill)request.getAttribute("consumerCurrentBill"); 
	String errMsg=(String)request.getAttribute("errMsg");
	SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
%>
<jsp:include page="header.jsp"/>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<style type="text/css">
    <%@include file="./Bootstrap/bootstrap-4.4.1-dist/css/bootstrap.min.css" %>
    
</style>
<link rel="stylesheet" href="${css}/home.css">

</head>
<body class="image">

	<div class="row border">
		<div class="col">
			<br> <br>
			<h1 style="color: brown; text-align: center;">Bill Detailes</h1>
			<form action="./billPaymentPage" method="get">
				<h3>
					<table align="center">
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;RR Number</td>
							<td class="td1">:</td>
							<%if(cBill!=null){ %>
							<td class="td2"><%=cBill.getRrNumber() %></td>
							<%} %>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Initial Units</td>
							<td class="td1">:</td>
							<%if(cBill!=null){ %>
							<td class="td2"><%=cBill.getInitialUnits() %></td>
							<%} %>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Final Units</td>
							<td class="td1">:</td>
							<%if(cBill!=null){ %>
							<td class="td2"><%=cBill.getFinalUnits() %></td>
							<%} %>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Total Units Conumed</td>
							<td class="td1">:</td>
							<%if(cBill!=null){ %>
							<td class="td2"><%=cBill.getUnitsConsumed()%></td>
							<%} %>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Readings Taken On</td>
							<td class="td1">:</td>
							<%if(cBill!=null){ 
								
							%>
							<td class="td2"><%=format.format(cBill.getReadingsTakenOn()) %></td>
							<%} %>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Amount</td>
							<td class="td1">:</td>
							<%if(cBill!=null){ %>
							<td class="td2"><%=cBill.getAmount() %><span> /-</span> </td>
							<%} %>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Due Date</td>
							<td class="td1">:</td>
							<%if(cBill!=null){ %>
							<td class="td2"><%=format.format(cBill.getDueDate()) %></td>
							<%} %>
						</tr>
					</table><br>
				</h3>
				<div style="text-align: center;">
					<h3><input type="submit" value="PayBill" style="background-color:green;"></h3>
				</div>
			</form>
			<h5 style="color: red;">Remember : In a Month Only Once You Can Pay the Bill</h5>
		</div>
	</div>
	<%if(errMsg!=null&&!errMsg.isEmpty()) {%>
		<h4 style="color: red; text-align: center;"><%=errMsg %></h4>
	<%} %>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>