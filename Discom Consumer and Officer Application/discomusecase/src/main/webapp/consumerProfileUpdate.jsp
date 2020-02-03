<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<%
	String errMsg = (String) request.getAttribute("errMsg");
	String msg = (String) request.getAttribute("msg");
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
		<form  action="./consumerProfileUpdate" method="post">
			<br>
			<h1 style="text-align: center;" class="text-warning">Discom
				Consumer Profile Update Page</h1>
			<br>

			<div class="row">
				<div class="col">
					<label for="">Contact NO</label> <input type="tel"
						class="form-control" placeholder="contact number"
						name="contactNumber">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="">Email</label> <input type="email"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="email"
						name="mail">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="">Password</label> <input type="password"
						class="form-control" placeholder="Password"
						name="password">
				</div>
				<div class="col">
					<label for="">Confirm Password</label> <input type="password"
						class="form-control" placeholder="Password" name="cPassword">
				</div>
			</div>
			
			<br>
			<!-- <a href="/frontend/html/Home.html"> <input class="mx-auto d-block bg-warning" type="button" value="SignIn"></a> -->
			<button class="mx-auto d-block bg-warning" type="submit"
				>Update</button>
		</form>
	</div>

	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2 style="color: red;"><%=errMsg%></h2>
	<%
		}
	%>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h2 style="color: green; text-align: center;"><%=msg%></h2>
	<%
		}
	%>
	<script src="${js }/jquery-3.4.1.js"></script>
	<script src="${js }/js/bootstrap.min.js"></script>
</body>
</html>