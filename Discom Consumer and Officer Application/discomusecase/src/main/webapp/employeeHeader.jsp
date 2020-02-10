<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h3>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="../employee/employeHome">Home<!--  <span class="sr-only">(current)</span> -->
				</a></li>
				<li class="nav-item"><a class="nav-link" href="../employee/searchPage">Search</a></li>
				<li class="nav-item"><a class="nav-link" href="../employee/billUpdatePage">UpdateBill</a></li>
				<li class="nav-item"><a class="nav-link" href="../employee/getComments">Comments</a></li>
					<li class="nav-item nav-link">
					<div class="dropdown">
						<!-- <button class="dropbtn">Profile</button> -->
						<label>Consumer</label>
						<div class="dropdown-content">
							<h5>
							<a href="../employee/getAllConsumerInfo">All Info</a> <a href="../employee/getAllCurrentBills">All Bills</a>
							</h5>
						</div>
					</div>

				</li>
				<li class="nav-item"><a class="nav-link" href="./logout"><button style="background-color: green;margin-left: 600%">LogOut</button></a></li>
			</ul>
		</h3>
	</div>
	</nav>
	
	
<script src="${js}/jquery-3.4.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>
</body>
</html>