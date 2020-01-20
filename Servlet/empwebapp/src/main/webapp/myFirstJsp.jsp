<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! private int a=10;
	public void setA(int a){
		this.a=a;
	}
	public int getA(){
		return a;                  /* declaration tag */
	}
	public String name="subbu";
	public String getName(){
		return name;
	}
	public String getName(String name){
		return name;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: fuchsia;"> welcome to jsp</h1>
	a=<%= a%><br>
	a=<%= getA()%><br> <!-- //for expression tag there is no semicolan -->
	<% setA(100); %>    <!-- //srciptlet tag -->
	a=<%= getA() %><br>

	name=<%=name %><br>
	name=<%=getName() %><br>  
	name=<%=getName("sunil") %><br><br>
	
	<% for(int i=0;i<5;i++){ %>
	<%= getName() %><br>
	<%} %>
</body>
</html>

<!-- directive tag -->
<%@include file="date.html" %>
<%-- <%@include file="/DynamicDate" %>
dynamic responce allowed
 --%>



<%-- <jsp:include page="/DynamicDate"/> --%>


<%-- <jsp:include page="/searchEmp">
	<jsp:param value="5241" name="empId"/>
</jsp:include> --%>


<%-- <jsp:forward page="./DynamicDate"/> --%>
<%-- <jsp:forward page="./searchEmp?empId=1012"/> --%>
<%-- <jsp:forward page="./searchEmp">
	<jsp:param value="5241" name="empId"/>
</jsp:forward> --%>


















