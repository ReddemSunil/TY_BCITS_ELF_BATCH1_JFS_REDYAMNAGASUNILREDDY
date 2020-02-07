<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%String errMsg=(String)request.getAttribute("errMsg");
String msg=(String)request.getAttribute("msg");
%>
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
<link rel="stylesheet" href="${css}/employeelogin.css">
<link rel="stylesheet" href="${css}/Discomhome.css">
</head>


<body class="backgroundimg">
<div class="row header">
		<div class="col-2" style="display: inline;">
			<img src="${images}/electricity1.png"
				style="width: 50%; height:100%;">
		</div>
		<div class="col-6">
			<h1 style="text-align: center; color: rgb(18, 80, 143);">Discom
				Electricity portal</h1>
			<h3 style="text-align: center; color: rgb(18, 80, 143);">Banglore</h3>
		</div>
		<div class="col-2">
			<a href="../consumer/consumerLoginPage"><button type="submit"
					class="button">Consumer logIn</button></a>
		</div>

		<div class="col-2">
			<a href="../employee/employeeLoginPage"><button type="submit"
					class="button">Employee logIn</button></a>
		</div>
	</div>
	<div class="container">
		<div class="row ">
			<div class="mx-auto d-block lineborder ">
				<br>
				<h1 style="color: rgb(255, 233, 105);">Employee Login Page</h1>
				<form name="myform" method="post" action="../employee/employeeLoginPage">
					<div class="form-group">
						<label for="" class="color" id="empId" name="empId">EmpID</label>
						<input type="number" class="form-control" id="empId" required name="empId">

					</div>
					<div class="form-group">
						<label for="exampleInputPassword1" class="color" id="password"
							name="name">Password</label> <input type="password"
							class="form-control" id="exampleInputPassword1" required name="password">

					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1"
							style="color: darkmagenta;">Check me out</label>
					</div>
					<button class="mx-auto d-block" style="background-color: green;"
						type="submit">Login</button>
				</form>
				<%if(errMsg!=null&&!errMsg.isEmpty()){ %>
					<h4 style="color: red;"><%=errMsg %></h4>
				<%} %>
				<%if(msg!=null&&!msg.isEmpty()){ %>
					<h4 style="color: green;"><%=msg %></h4>
				<%} %>
			</div>
		</div>
	</div>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>

</html>