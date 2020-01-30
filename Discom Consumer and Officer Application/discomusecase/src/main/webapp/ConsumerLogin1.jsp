<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String) request.getAttribute("invalid"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="./Bootstrap/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/consumerlogin.css">
<body>
	<body class="backgroundimg">
 
    <div class="row ">
      <div class="head">
        <div><h1>Discom Consumer</h1></div>
      </div>
        <div class="mx-auto d-block lineborder ">
          
            <h1 style="color: hotpink;">Login Page</h1>
            <form name="myform" method="post" action="./loginservletofuser">
              <div class="form-group">
                <label for="" class="color" id="MeterNo" name="MeterNo" >MeterNo</label>
                <input type="number" class="form-control" id="meterno" name="meterNumber" required>
               
              </div>
                <div class="form-group">
                  <label for="exampleInputPassword1" class="color" id="password" name="name" >Password</label>
                  <input type="password" class="form-control" id="exampleInputPassword1"required name="password">
                 
                </div>
                <div class="form-group form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1" style="color: gold;">Check me out</label>
                </div>
<!--                 <button style="background-color: green;" type="submit"formaction="/frontend/html/Home.html">Login</button>
 -->                <input type="submit" value="login">
                <p style="color: gold;">you don't have an account Please Register? <span><a href="./consumersignin.html">SignUp</a></span> </p>
              </form>

        </div>

    </div>
   <script src="./Bootstrap/bootstap jquery/jquery-3.4.1.js"></script>
  <script src="./Bootstrap/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
	<%if(msg!=null && !msg.isEmpty()){ %>
		<h3 style="color:navy;"> <%=msg %></h3>
	<%} %>
</body>
</html>