<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.food.models.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="res.css">
</head>
<body>

<h1 class="head" >Welcome to Tap Food Delivery app</h1>
<div class="map">
        
        <a href="home">Home</a>
        <a href="cart">Cart</a>
        <a href="LoginPage.jsp">Login</a>
        <a href="Signup.jsp">SignUp</a>
        
        </div>
        
<%
    

     
    List<Restaurant> all = (List<Restaurant>) request.getAttribute("restaurant");
    
    for (int i = 0; i < all.size(); i++) {
        Restaurant rest = all.get(i);
        
        // Check if it's the start of a new row
                
        
        if (i % 3 == 0) {
            %>
            <div class="items">
            <% 
        }
        %>
       
        <div class="item">
            <img src="pictures/<%=rest.getImagePath()%>" alt="Image of <%=rest.getRestaurantName()%>"  height="280" width="350"  >
            <h1><%=rest.getRestaurantName()%></h1>
            <h2><%=rest.getRating()%></h2>
            <h2><%=rest.getCuisineType()%></h2>
            
            <a href="Menu?restaurantID=<%=rest.getRestaurantID()%>">view menu</a>
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