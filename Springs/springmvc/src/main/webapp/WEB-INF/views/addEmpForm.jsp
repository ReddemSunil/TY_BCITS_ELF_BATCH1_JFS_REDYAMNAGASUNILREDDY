<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>
<<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>

	<h3 style="color: green"><%=msg%></h3>

	<%
		}
	%>

	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>

	<h3 style="color: red"><%=errMsg%></h3>

	<%
		}
	%>
	<fieldset>
		<legend>Add Employee</legend>

		<form action="addEmployee" method="post">
			<table>
				<tr>
					<td>Employee Id</td>
					<td>:</td>
					<td><input type="text" name="empId"></td>
				</tr>
				<tr>
					<td>name</td>
					<td>:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Mobile NO</td>
					<td>:</td>
					<td><input type="number" name="mobileno"></td>
				</tr>

				<tr>
					<td>OfficialMail</td>
					<td>:</td>
					<td><input type="email" name="officialMail"></td>
				</tr>
				<tr>
					<td>DateOfBirth</td>
					<td>:</td>
					<td><input type="date" name="dateOfBirth"></td>
				</tr>
				<tr>
					<td>dateOfJoining</td>
					<td>:</td>
					<td><input type="date" name="dateOfJoining"></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td>:</td>
					<td><input type="text" name="designation"></td>
				</tr>
				<tr>
					<td>salary</td>
					<td>:</td>
					<td><input type="number" name="salary"></td>
				</tr>
				<tr>
					<td>deptid</td>
					<td>:</td>
					<td><input type="number" name="deptid"></td>
				</tr>
				<tr>
					<td>managerId</td>
					<td>:</td>
					<td><input type="number" name="managerId"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="3"><br> <input type="submit" value="add">
					</td>

				</tr>


			</table>

		</form>
	</fieldset>

</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>