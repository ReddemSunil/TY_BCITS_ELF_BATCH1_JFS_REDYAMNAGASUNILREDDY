<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String errMsg=(String)request.getAttribute("errMsg"); %>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->

<link rel="stylesheet" href="${css}/billPaymentPage.css">
</head>
<body class="body">
    <div class="border" style="margin-left: 32%;margin-top: 4%;">
        <h3 style="text-align: center;color:purple;font-size:xx-large;">Payment Details</h3>
            <div class='row'>
                <div class=''>
                   
                  <form method="post" action="./paymentSuccessfullPage" >
                     
                    <div class='form-row'>
                      <div class='col-xs-12 form-group '>
                        <label class='control-label lable1'>Name on Card</label>
                        <input class='form-control' size='50' type='text'required>
                      </div>
                    </div>
                    <div class='form-row'>
                      <div class='col-xs-12 form-group required'>
                        <label class='control-label lable1'>Card Number</label>
                        <input class='form-control card-number' size='50' type='text'required>
                      </div>
                    </div>
                    <div class='form-row'>
                      <div class='col-xs-12 form-group required'>
                        <label class='control-label lable1'>Amount</label>
                        <input class='form-control' size='50' type='text'required name="amountPaid">
                      </div>
                    </div>
                    <div class='form-row'>
                      <div class='col-xs-4 form-group cvc required'>
                        <label class='control-label lable1'>CVC</label>
                        <input class='form-control card-cvc' placeholder='ex. 311' size='5' type='text'required>
                      </div>
                      <div class='col-xs-4 form-group expiration required'>
                        <label class='control-label lable1'>Expiration</label>
                        <input class='form-control card-expiry-month' placeholder='MM' size='2' type='text'required>
                      </div>
                      <div class='col-xs-4 form-group expiration required'>
                        <label class='control-label'> </label>
                        <input class='form-control card-expiry-year'style="margin-top: 13%" placeholder='YYYY' size='5' type='text'required>
                      </div>
                    </div>
                    <div class='form-row'>
                      <div class='col-md-12 form-group'>
                        <button class='form-control  btn-primary' type='submit'>Pay »</button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class='col-md-4'></div>
            </div>
        </div>
        <%if(errMsg!=null && !errMsg.isEmpty()) {%>
        	<h3 style="color: red;text-align: center;"><%=errMsg %></h3>
        <%} %>
<script src="${js}/jquery-3.4.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>
</body>
</html>