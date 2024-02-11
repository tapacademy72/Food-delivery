<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ page import="java.util.List,com.food.models.Menu" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="menu.css">
</head>
<body>
  <h2 class="head" >Welcome to Tap Food Delivery app</h2>
<div class="map">
        
        <a href="home">Home</a>
        <a href="cart">Cart</a>
        <a href="LoginPage.jsp">Login</a>
        <a href="Signup.jsp">SignUp</a>
        
        </div>
        
<%
    	 
 List<Menu> all =(List<Menu>)request.getAttribute("menus");

    for (int i = 0; i < all.size(); i++) {
    	
    	Menu  rest = all.get(i);
        
        // Check if it's the start of a new row
        
        if (i % 3 == 0) {
            %>
            <div class="items">
            <% 
        }
        %>
        
        <div class="item">

            <h1><%=rest.getItemName()%></h1>
            <h2><%=rest.getRating()%></h2>
            <h2><%=rest.getDescription()%></h2>
            <h2><%=rest.getPrice()%></h2>
           
            
            <form action="cart" method="post">
             
            Quantity:<input type="number" name="quantity" value="1" min="1" class="quantity-input"><br>
             <input type="submit"  value="Add to cart" class="add-to-card-btn">
             <input type="hidden" name="itemId"  value ="<%=rest.getMenuId()%>">
              <input type="hidden" name="action" value ="add">
            
            </form>
        </div>
        
        <% 
        // Check if it's the end of a row
        if ((i + 1) % 3 == 0 || i == all.size() - 1) {
            %>
            </div>
            <% 
        }
    }
%>
 



</body>
</html>