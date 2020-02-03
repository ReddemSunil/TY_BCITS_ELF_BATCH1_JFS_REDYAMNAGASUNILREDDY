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
    .head{
	background-color:activeborder;
}
</style>
<link rel="stylesheet" href="${css}/dropdown.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light head"> <img
		src="${images }/bcits.png" alt="" width="100px" height="100px">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div class="collapse navbar-collapse head" id="navbarNavDropdown">
		<h3 style="color: blue;">
			<ul class="navbar-nav">
				<li class="nav-item nav-link">
					<div class="dropdown">
						<!-- <button class="dropbtn">Profile</button> -->
						<label>Profile</label>
						<div class="dropdown-content">

							<a href="./consumerProfileOpen">Open</a> <a href="./consumerProfileUpdatePage">Update</a>

						</div>
					</div>

				</li>
				<li class="nav-item active"><a class="nav-link"
					href="../consumer/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Payment</a></li>
				<li class="nav-item"><a class="nav-link" href="#">History</a></li>
				<li class="nav-item"><a class="nav-link" href="#">AboutUs</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
				<li class="nav-item"><a class="nav-link" href="#">LogOut</a></li>
			</ul>
		</h3>
	</div>
	</nav>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>