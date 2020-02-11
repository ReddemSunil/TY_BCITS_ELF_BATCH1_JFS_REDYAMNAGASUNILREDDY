<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<%
String msg = (String) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>
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
<link rel="stylesheet" href="${css }/consumersigin.css">
</head>

<body class="body">
	<div class="container">
		<form action="../admin/employeeSignin" method="post" style="width: 60%;">
			<br>
			<h1 style="text-align: center;" class="text-warning">Discom
				Employee Sign In Page</h1>
			<br>
			<div class="row">
				<div class="col">
					<label for="">EmpId</label> <input type="number"
						class="form-control" placeholder="employee id" name="empId">
				</div>
				<div class="col">
					<label for="">Name</label> <input type="text" class="form-control"
						placeholder="full name" name="name">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="">Email</label> <input type="email"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="email" required
						name="email">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="">Password</label> <input type="password"
						class="form-control" placeholder="Password" required
						name="password">
				</div>
				<div class="col">
					<label for="">Design Nation</label> <input type="text"
						class="form-control" placeholder="designation" name="designation">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="">Region</label> <br> <select name="region" id=""
						class="form-control">
						<option value="" selected disabled>Select</option>
						<option value="Bangalore South">Bangalore South</option>
						<option value="Bangalore North">Bangalore North</option>
					</select>
				</div>
				<div class="col">
					<label for="inputZip">Admin Id</label> <input type="number"
						class="form-control" placeholder="admin id" name="adminId">
				</div>
			</div><br>
			<div class="row">
				<div class="col">
					<button style="background-color: green;" type="submit">SignIn</button>
				</div>
				<div class="col">
					<h5 style="color: red;">
						Admin Logout Button
						<button style="background-color: lime;">
							<a href="../admin/logout">Logout</a>
						</button>
					</h5>
				</div>
			</div>
	</form>
	</div>

	<!-- <a href="/frontend/html/Home.html"> <input class="mx-auto d-block bg-warning" type="button" value="SignIn"></a> -->


	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2 style="color: red;text-align: center;"><%=errMsg%></h2>
	<%
		}
	%>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h2 style="color: green;text-align: center;"><%=msg%></h2>
	<%
		}
	%>
	<script src="${js }/jquery-3.4.1.js"></script>
	<script src="${js }/js/bootstrap.min.js"></script>
</body>

</html>