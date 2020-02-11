<%@page import="com.bcits.discomusecase.bean.PaymentDetails"%>
<%@page import="com.bcits.discomusecase.bean.EmployeeInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%String errMsg=(String)request.getAttribute("errMsg");
  	List<PaymentDetails> list=(List<PaymentDetails>)request.getAttribute("list");
  	EmployeeInfo employeeInfo=(EmployeeInfo)request.getAttribute("employee");
  	PaymentDetails paymentDetails=(PaymentDetails)request.getAttribute("paymentDetails"); 
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
</head>
<body style="background-color: lightblue;"><br><br>
	<h3 style="color: navy;text-align: center;">
	  Employee Name   : <%=employeeInfo.getName() %><br>
	  Employee Id     : <%=employeeInfo.getEmpId() %><br>
	  Employee Region : <%=employeeInfo.getRegion()%><br>
	
	</h3><br>
	<%if(paymentDetails!=null){ %>
	<h3 style="text-align: center;color: navy;">Monthly Revenue</h3>
	<h5>Total Amount   :<%=paymentDetails.getAmount() %><br>
		Received Amount:<%=paymentDetails.getAmountPaid() %><br>
		Due Amount     :<%=paymentDetails.getRemainingAmount() %>
	</h5>
	<%} %>
	<%if(list!=null&&!list.isEmpty()){ %>
	<h5>
		<table align="center" style="width: 80%;height: 50%;">
			<tr style="color:orange;">
				<th>RR Numbers</th>
				<th>Bill Amount</th>
				<th>Amount Paid</th>
				<th>Remaining Amount</th>
			</tr>
		<%for(PaymentDetails details:list){ %>
			<tr style="color:olive;">
				<td><%=details.getRrNumber() %></td>
				<td><%=details.getAmount() %></td>
				<td><%=details.getAmountPaid() %></td>
				<td><%=details.getRemainingAmount() %></td>
		<%} %>
		</table>
		</h5>
	<%} %>
	



<%if(errMsg!=null&&!errMsg.isEmpty()) {%>
		<h2 style="color: red; text-align: center;"><%=errMsg %></h2>
	<%} %>
<script src="${js}/jquery-3.4.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>
</body>
</html>