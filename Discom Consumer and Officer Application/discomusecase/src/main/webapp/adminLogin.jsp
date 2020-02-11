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

	<div class="container">
		<div class="row ">
			<div class="mx-auto d-block lineborder ">
				<br>
				<h1 style="color: rgb(255, 233, 105);">Admin Login Page</h1>
				<form name="myform" method="post" action="../admin/adminLogin">
					<div class="form-group">
						<label for="" class="color" id="empId" name="empId">AdminID</label>
						<input type="number" class="form-control" id="empId" required name="adminId">

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