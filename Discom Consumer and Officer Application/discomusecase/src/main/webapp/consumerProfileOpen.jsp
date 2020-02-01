<%@page import="com.bcits.discomusecase.bean.ConsumerInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%ConsumerInfo info=(ConsumerInfo)request.getAttribute("consumerInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="get">
		<fieldset>
			<legend style="color: green;">Your Profile</legend>
			<table>
				<tr>
					<td>RR Number</td>
					<td> : </td>
					<td><%=info.getRrNumber() %></td>
				</tr>
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
	
	
	
	</form>
</body>
</html>