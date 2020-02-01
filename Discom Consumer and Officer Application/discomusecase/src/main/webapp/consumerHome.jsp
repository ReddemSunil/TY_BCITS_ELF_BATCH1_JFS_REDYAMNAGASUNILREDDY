<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<%-- <link rel="stylesheet" href="${bootstrap}/bootstrap-4.4.1-dist/css/bootstrap.min.css"> --%>
<link rel="stylesheet" href="${css}/home.css">
</head>
<body class="image">
	<nav class="navbar navbar-expand-lg navbar-light head"> <img
		src="${images }/bcits.png" alt="" width="100px" height="100px">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse head" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Payment</a></li>
			<li class="nav-item"><a class="nav-link" href="#">History</a></li>
			<li class="nav-item"><a class="nav-link" href="#">AboutUs</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
		</ul>
	</div>
	</nav>
	<div class="row">
		<div class="col">
			<br>
			<br>
			<h1 style="color: brown; text-align: center;">Bill Detailes</h1>
			<div class="borderbody">
				<h3>
					<table>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Meter Number</td>
							<td class="td1">:</td>
							<td></td>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Initial Units</td>
							<td class="td1">:</td>
							<td></td>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Final Units</td>
							<td class="td1">:</td>
							<td></td>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Total Units Conumed</td>
							<td class="td1">:</td>
							<td></td>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Readings Taken On</td>
							<td class="td1">:</td>
							<td></td>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Amount</td>
							<td class="td1">:</td>
							<td></td>
						</tr>
						<tr>
							<td class="td">&nbsp;&nbsp;&nbsp;Due Date</td>
							<td class="td1">:</td>
							<td></td>
						</tr>
					</table>
				</h3>
			</div>
		</div>
	</div>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>