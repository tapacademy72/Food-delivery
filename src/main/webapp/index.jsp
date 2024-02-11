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


   <h1>Welcome to Tap food delivery app</h1>
        <div class="map">
        <a href="home">Home</a>
        <a href="LoginPage.jsp">Login</a>
        <a href="Signup.jsp">SignUp</a>
        </div>
        
   
<%
  
    List<Restaurant> all = (List<Restaurant>) request.getAttribute("restaurant");
    
           for( Restaurant rest:all){
    
        %>
       <div class="items">
        <div class="item">
            <img src="pictures/<%=rest.getImagePath()%>" alt="Image of <%=rest.getRestaurantName()%>"  height="300" width="320"  >
            <h1><%=rest.getRestaurantName()%></h1>
            <h2><%=rest.getRating()%></h2>
            <h2><%=rest.getCuisineType()%></h2>
            
            <a href="Menu?restaurantID=<%=rest.getRestaurantID()%>">view menu</a>
        </div>
        </div>
        
  <%} %>

</body>
</html>