<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<%
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
		<form  action="./consumerSignin" method="post">
			<br>
			<h1 style="text-align: center;" class="text-warning">Discom
				Consumer Sign In Page</h1>
			<br>
			<div class="row">
				<div class="col">
					<label for="">First Name</label> <input type="text"
						class="form-control" placeholder="First name" name="firstName">
				</div>
				<div class="col">
					<label for="">Last Name</label> <input type="text"
						class="form-control" placeholder="Last name" name="lastName">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="">Meter No</label> <input type="text"
						class="form-control" name="meterNumber" placeholder="Meter number"
						required>
				</div>
			</div>
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
						aria-describedby="emailHelp" placeholder="email" required
						name="mail">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="">Password</label> <input type="password"
						class="form-control" placeholder="Password" required
						name="password">
				</div>
				<div class="col">
					<label for="">Confirm Password</label> <input type="password"
						class="form-control" placeholder="Password" name="cPassword">
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
					<label for="">Type of consumers</label><br> <select
						name="typeOfConsumer" id="" class="form-control">
						<option value="Select" selected disabled>Select</option>
						<option value="Residential consumers">Residential
							consumers</option>
						<option value="Commercial consumers">Commercial consumers</option>
						<option value="Industries">Industries</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="inputAddress">Address</label> <input type="text"
						class="form-control" id="inputAddress" placeholder="1234 Main St"
						name="address1">
				</div>
				<div class="col">
					<label for="inputAddress2">Address 2</label> <input type="text"
						class="form-control" id="inputAddress2"
						placeholder="Apartment or floor" name="address2">

				</div>
				<div class="col">
					<label for="inputZip">Pincode</label> <input type="text"
						class="form-control" id="inputZip" name="pincode">
				</div>
			</div>
			<br>
			<!-- <a href="/frontend/html/Home.html"> <input class="mx-auto d-block bg-warning" type="button" value="SignIn"></a> -->
			<button class="mx-auto d-block bg-warning" type="submit"
				>SignIn</button>
		</form>
	</div>

	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2 style="color: red;"><%=errMsg%></h2>
	<%
		}
	%>
	<script src="${js }/jquery-3.4.1.js"></script>
	<script src="${js }/js/bootstrap.min.js"></script>
</body>

</html>