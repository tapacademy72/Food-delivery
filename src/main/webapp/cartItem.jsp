<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.food.models.CartItem,com.food.models.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CartItem</title>
<link rel="stylesheet" href="CardItems.css">
</head>
<body>
 <h1><i>Your Shopping Cart</i></h1>
 <%
 
   Cart cart = (Cart)session.getAttribute("cart");
 
    if(cart!= null && !cart.getItems().isEmpty())
    {

    for(CartItem item : cart.getItems().values()){
 %>
 
<div class="items">

<h3><%= item.getName() %></h3>
<p><%=item.getPrice() %>


<form action="cart" method="post">
<input type="hidden" name="itemId" value="<%=item.getItemID() %>">

<label><b>Quantity:</b> <input type="number" name="quantity" min="1" value="<%=item.getQuantity() %>"></label>

<input type="submit" name="action" value="update" class="update-btn">

<input type="submit" name="action" value="remove" class="remove-btn">
<hr>
</form>

</div>

<%
}
    }
    else{
    	%>
    	<p>Your cart is Empty</p>
    	
    	<% 
    }

%>


 <a class="red" href="Menu?restaurantID=<%= session.getAttribute("restaurantId")%>" class="btn2">AddMoreItems</a>
  //proceed to checkout button<br>
 <a class="Home" href="home">Go Back to Home Page</a>
 

 <%
 if(session.getAttribute("cart") != null){
 %>
 
<form action="checkout.jsp" method="post">
<input type="submit" value="proceedtocheckout"
 class="btn">
 
</form>


<%} %>
</body>
</html>