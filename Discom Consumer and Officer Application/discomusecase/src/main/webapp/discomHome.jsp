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
<link rel="stylesheet" href="${css}/Discomhome.css">
</head>
<!-- <link rel="stylesheet" href="./Bootstrap/bootstrap-4.4.1-dist/css/bootstrap.min.css"> -->

<body class="bgimg">
	<div class="row header">
		<div class="col-2" style="display: inline;">
			<img src="${images}/electricity1.png"
				style="width: 50%; height:100%;">
		</div>
		<div class="col-5">
			<h1 style="text-align: center; color: rgb(18, 80, 143);">Discom
				Electricity portal</h1>
			<h3 style="text-align: center; color: rgb(18, 80, 143);">Banglore</h3>
		</div>
		<div class="col-1">
			<a href="./admin/adminPage"><button type="submit"
				class="button" style="margin-top: 46%">admin</button></a>
		</div>
		<div class="col-2">
			<a href="./consumer/consumerLoginPage"><button type="submit"
					class="button">Consumer logIn</button></a>
		</div>

		<div class="col-2">
			<a href="./employee/employeeLoginPage"><button type="submit"
					class="button">Employee logIn</button></a>
		</div>
	</div>

	<div class="row">
		<marquee behavior="scroll" direction="">
			<h1 style="color: aqua;">Welcome To Discom Electricity Portal</h1>
			<img src="${images }/bcits.png" width="50%" alt=""height="30%">
		</marquee>
	</div>

	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>

</html>