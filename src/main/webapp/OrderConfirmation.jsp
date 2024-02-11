<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.food.servlets.Checkoutservlet,com.food.models.OrderTable" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="confirm.css">
</head>
<body>
<div class="head">
<img src="pictures/orderconfirmation.jpeg" width="400px" height="300px" alt="picture"></img>
<h1>Your Order confirmed!.</h1>
</div>

<% 
 OrderTable order=(OrderTable)session.getAttribute("order");
  
%>
<div class="order">
<p>Payment Mode: <%=order.getPaymentMode()%></p>
<p>Status: <%=order.getStatus()%></p>
<p>Total Amount: <%=order.getTotalAmount() %></p>
<p>OrderDate: <%=order.getOrderDate() %></p>
</div>

<h2 class="head">Thank you for the order</h2>

</body>
</html>