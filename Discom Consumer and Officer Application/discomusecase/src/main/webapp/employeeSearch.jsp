<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.bean.MonthlyConsumtion"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomusecase.bean.ConsumerCurrentBill"%>
<%@page import="com.bcits.discomusecase.bean.PaymentDetails"%>
<%@page import="com.bcits.discomusecase.bean.ConsumerInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%String errMsg=(String)request.getAttribute("errMsg"); 
	String rrNumber=(String)request.getAttribute("rrNumber");
    ConsumerInfo info=(ConsumerInfo)request.getAttribute("consumerInfo");
    PaymentDetails details=(PaymentDetails)request.getAttribute("paymentDetails");
    ConsumerCurrentBill bill=(ConsumerCurrentBill)request.getAttribute("currentBill");
    List<MonthlyConsumtion> list=(List<MonthlyConsumtion>)request.getAttribute("monthlyConsumtion");
    SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");

%>

 <jsp:include page="employeeHeader.jsp"/>  
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
    <%@include file="./Bootstrap/bootstrap-4.4.1-dist/css/bootstrap.min.css" %>
    
</style>
</head>
<body style="background-color: lightblue;"><br>
	<div class="container">
      <div class="row">
         <div class="col-md-4 mx-auto">
            <div class="myform form "><br><br>
               <form action="../employee/displayLinks" method="post">
               <h3 style="color: navy;text-align: center;">Search Page </h3>
                  <div class="form-group">
                  <label>RR Number</label><br>
                     <input type="text" name="rrNumber"  class="form-control my-input" placeholder="Enter rr number">
                  </div>
                  <div class="text-center ">
                     <button type="submit" style="background-color: green;">Search</button>
                  </div>
                  <%if(rrNumber!=null && !rrNumber.isEmpty()){ %>
             
                  	<h5>RR Number Is : <%=rrNumber %><br>
                  	Search For<a href="../employee/searchConsumerDetails"> ConsumerDetails </a><br>
                  		Search For<a href=""> CurrentBillConsumption </a><br>
                  		Search For<a href=""> MonthlyBillConsumption </a><br>
                  		Search For<a href=""> PaymentDetails </a><br>
                  	</h5>
                  <%} %>
                  </form>
			</div>
		</div>
	</div>
</div>
<div align="center">
	<%if(info!=null){ %>
		<fieldset>
			<legend style="color: navy;">ConsumerDetails</legend>
			<table style="font-size: 20px">
				<tr>
					<td>First Name</td>
					<td> : </td>
					<td><%=info.getFirstName() %></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td> : </td>
					<td><%=info.getLastName() %></td>
				</tr>
				<tr>
					<td>Contact Number</td>
					<td> : </td>
					<td><%=info.getContactNumber() %></td>
				</tr>
				<tr>
					<td>Email</td>
					<td> : </td>
					<td><%=info.getMail() %></td>
				</tr>
				<tr>
					<td>Region</td>
					<td> : </td>
					<td><%=info.getRegion() %></td>
				</tr>
				<tr>
					<td>Type Of Consumer</td>
					<td> : </td>
					<td><%=info.getTypeOfConsumer() %></td>
				</tr>
				<tr>
					<td>Address Line1</td>
					<td> : </td>
					<td><%=info.getAddress1() %></td>
				</tr>
				<tr>
					<td>Address Line2</td>
					<td> : </td>
					<td><%=info.getAddress2() %></td>
				</tr>
				<tr>
					<td>Pincode</td>
					<td> : </td>
					<td><%=info.getPincode() %></td>
				</tr>
				
			</table>
		
		</fieldset>
		
		
	<%} %>
	
	<%if(details!=null){ %>
		<fieldset>
			<legend style="color: navy;">Consumer Payment Details</legend>
			<table style="font-size: 20px">
				<tr>
					<td>RR Number</td>
					<td> : </td>
					<td><%=details.getRrNumber() %></td>
				</tr>
				<tr>
					<td>Totol Amount</td>
					<td> : </td>
					<td><%=details.getAmount() %></td>
				</tr>
				<tr>
					<td>AmountPaid</td>
					<td> : </td>
					<td><%=details.getAmountPaid() %></td>
				</tr>
				<tr>
					<td>RemainingAmount</td>
					<td> : </td>
					<td><%=details.getRemainingAmount() %></td>
				</tr>
			</table>
		
		</fieldset>
		<%} %>
		<%if(bill!=null){ %>
		<fieldset>
			<legend style="color: navy;">Consumer Bill Details</legend>
			<table style="font-size: 20px">
				<tr>
					<td>RR Number</td>
					<td> : </td>
					<td><%=bill.getRrNumber() %></td>
				</tr>
				<tr>
					<td>Totol Amount</td>
					<td> : </td>
					<td><%=bill.getAmount() %></td>
				</tr>
				<tr>
					<td>Initial Units</td>
					<td> : </td>
					<td><%=bill.getInitialUnits() %></td>
				</tr>
				<tr>
					<td>Final Units</td>
					<td> : </td>
					<td><%=bill.getFinalUnits() %></td>
				</tr>
				<tr>
					<td>Units Consumed</td>
					<td> : </td>
					<td><%=bill.getUnitsConsumed() %></td>
				</tr>
				<tr>
					<td>Readings Taken</td>
					<td> : </td>
					<td><%=format.format(bill.getReadingsTakenOn()) %></td>
				</tr>
				<tr>
					<td>Due Date</td>
					<td> : </td>
					<td><%=format.format(bill.getDueDate()) %></td>
				</tr>
			</table>
		
		</fieldset>
		
		
	<%} %>
	
	<%if(list!=null&&!list.isEmpty()){ %>
	<fieldset>
			<legend style="color: navy;">Monthly Consumtion Details</legend>
	<h5>
		<table align="center" style="width: 80%;height: 50%;">
			<tr style="color:orange;">
				<th>RR Numbers</th>
				<th>Bill Amount</th>
				<th>Initial Units</th>
				<th>Final Units</th>
				<th>Units Consumed</th>
				<th>Readings Taken</th>
				<th>Due Date</th>
			</tr>
		<%for(MonthlyConsumtion monthlyConsumtion:list){ %>
			<tr style="color:lime;">
				<td><%=monthlyConsumtion.getMoPk().getRrNumber() %></td>
				<td><%=monthlyConsumtion.getAmount() %></td>
				<td><%=monthlyConsumtion.getInitialUnits() %></td>
				<td><%=monthlyConsumtion.getFinalUnits() %></td>
				<td><%=monthlyConsumtion.getUnitsConsumed()%></td>
				<td><%=monthlyConsumtion.getMoPk().getReadingsTakenOn()%></td>
				<td><%=monthlyConsumtion.getDueDate() %></td>
		<%} %>
		</table>
		</h5>
		</fieldset>
	<%} %>

</div>
	



<%if(errMsg!=null&&!errMsg.isEmpty()) {%>
		<h2 style="color: red; text-align: center;"><%=errMsg %></h2>
		<% }%>
<script src="${js}/jquery-3.4.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>
</body>
</html>