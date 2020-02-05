<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%String msg=(String)request.getAttribute("msg");
 	String errMsg=(String)request.getAttribute("errMsg");
 %>
<jsp:include page="employeeHeader.jsp"/>  
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
<link rel="stylesheet" href="${css}/employeeBillUpdatePage.css">
</head>
<body style="background-color: lightblue">
   <div class="container">
      <div class="row">
         <div class="col-md-4 mx-auto">
            <div class="myform form "><br><br>
               <form action="../employee/billUpdate" method="post">
               <h3 style="color: navy;text-align: center;">Update Bill Details</h3>
                  <div class="form-group">
                  <label>RR Number</label><br>
                     <input type="text" name="rrNumber"  class="form-control my-input" placeholder="Enter rr number">
                  </div>
                  <div class="form-group">
                  <label>Final Units</label><br>
                     <input type="number" name="finalUnits"  class="form-control my-input" id="email" placeholder="Enter Final Units">
                  </div>
                  <div class="form-group">
                  <label>Readings Taken On</label><br>
                     <input type="date"name="readingsTakenOn"  class="form-control my-input" placeholder="enter readings taken ">
                  </div>
                   <div class="form-group">
                  <label>Due Date</label><br>
                     <input type="date"name="dueDate"  class="form-control my-input" placeholder="enter due date">
                  </div>
                  <div class="text-center ">
                     <button type="submit" style="background-color: green;">Generate Bill</button>
                  </div>
						<%
							if(msg!=null && !msg.isEmpty()) {
						%>
						<h4 style="color: green;"><%=msg%></h4>
						<%
							}
						%>
						<%
							if (errMsg != null && !errMsg.isEmpty()) {
						%>
						<h4 style="color: red;"><%=errMsg%></h4>
						<%
							}
						%>
					</form>
            </div>
         </div>
      </div>
   </div>
   
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>