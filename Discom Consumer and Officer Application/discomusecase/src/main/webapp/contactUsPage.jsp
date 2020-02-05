<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%String msg=(String)request.getAttribute("msg");
 	String errMsg=(String)request.getAttribute("errMsg");
 %>
<jsp:include page="header.jsp"/>
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
    
</style>
<link rel="stylesheet" href="${css}/contactUsPage.css">
</head>
<body>
	<form action="../consumer/contactUs" method="post">
		<div class="container contact">
			<div class="row">
				<div class="col-md-3">
					<div class="contact-info">
						<img src="https://image.ibb.co/kUASdV/contact-image.png"
							alt="image" />
						<h2>Contact Us</h2>
						<h4>We would love to hear from you !</h4>
					</div>
				</div>
				<div class="col-md-9">
					<div class="contact-form">
						<div class="form-group">
							<label class="control-label col-sm-2" for="fname">Name:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="fname"
									placeholder="Enter Name" name="name">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="email">Email:</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="mail"
									placeholder="Enter email" name="mail">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="comment">Comment:</label>
							<div class="col-sm-10">
								<textarea class="form-control" rows="7" id="comment" name="comments"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Submit</button>
							</div>
						</div>
						<%if(msg!=null&&!msg.isEmpty()){ %>
							<h4 style="color: green;"><%=msg %></h4>
						<%} %>
						<%if(errMsg!=null&&!errMsg.isEmpty()){ %>
							<h4 style="color: red;"><%=errMsg %></h4>
						<%} %>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>