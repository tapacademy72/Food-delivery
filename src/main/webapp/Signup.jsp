<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sign Up</title>
<link rel="stylesheet" href="sign.css">
</head>
<body>

  <form action="SignUp" method="get">
   <h1>SIGN UP</h1>
    <div class="input-text">
   <input type="text" name="username" placeholder="username">
   </div>
    
    <div class="input-text">
   <input type="password"  name="password" placeholder="password">
   </div>
   
   <div class="input-text">
   <input type="email"  name="email" placeholder="sai@gmail.com">
   </div>
   
   <div class="input-text">
   <input type="number"  name="number" placeholder="enter mobile number">
   </div>

   <div class="input-text">
  <label>Role</label>
 <select name="role">

<option value="Customer">customer</option>
<option value="RestaurantAdmin">RestaurantAdmin</option>
<option value="SystemAdmin">SystemAdmin</option>
</select>

   </div>
   
    <div class="input">
    
   
   <input class="submit" type="submit">
   </div>
  
   
 
</form>


</body>
</html>