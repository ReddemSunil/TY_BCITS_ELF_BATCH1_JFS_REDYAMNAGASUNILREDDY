<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomusecase.bean.ConsumerCurrentBill"%>
<%@page import="com.bcits.discomusecase.bean.ConsumerInfo"%>
<%@page import="com.bcits.discomusecase.bean.PaymentDetails"%>
<%@page import="com.bcits.discomusecase.bean.EmployeeInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%String errMsg=(String)request.getAttribute("errMsg");
  	List<ConsumerInfo> list=(List<ConsumerInfo>)request.getAttribute("list");
  	EmployeeInfo employeeInfo=(EmployeeInfo)request.getAttribute("employee");
  	List<ConsumerCurrentBill> billList=(List<ConsumerCurrentBill>)request.getAttribute("billList");
  	 SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
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
	<%if(list!=null&&!list.isEmpty()){ %>
	<h5>
		<table align="center" style="width: 80%;height: 50%;">
			<tr style="color:orange;">
				<th>RR Numbers</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Contact Number</th>
				<th>Mail</th>
				<th>Type Of Consumer</th>
				<th>Region</th>
			</tr>
		<%for(ConsumerInfo details:list){ %>
			<tr style="color:olive;">
				<td><%=details.getRrNumber() %></td>
				<td><%=details.getFirstName() %></td>
				<td><%=details.getLastName() %></td>
				<td><%=details.getContactNumber() %></td>
				<td><%=details.getMail() %></td>
				<td><%=details.getTypeOfConsumer() %></td>
				<td><%=details.getRegion() %></td>
		<%} %>
		</table>
		</h5>
	<%} %>

<%if(billList!=null&&!billList.isEmpty()){ %>
	<h5>
		<table align="center" style="width: 80%;height: 50%;">
			<tr style="color:orange;">
				<th>RR Numbers</th>
				<th>Initial Units</th>
				<th>Final Units</th>
				<th>Units Consumed</th>
				<th>Readings Taken On</th>
				<th>Due Date</th>
				<th>Amount</th>
			</tr>
		<%for(ConsumerCurrentBill bill:billList){ %>
			<tr style="color:olive;">
				<td><%=bill.getRrNumber() %></td>
				<td><%=bill.getInitialUnits() %></td>
				<td><%=bill.getFinalUnits() %></td>
				<td><%=bill.getUnitsConsumed() %></td>
				<td><%=format.format(bill.getReadingsTakenOn()) %></td>
				<td><%=format.format(bill.getDueDate()) %></td>
				<td><%=bill.getAmount() %></td>
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