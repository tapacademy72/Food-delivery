<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> 

<link rel="stylesheet" href="check.css">
</head>
<body>
<h1>Provide Delivery Details:</h1>
<div class="check">
<form action="checkout" method="post">
<label>Delivery Address</label>
<input type="text"><br><br>
<label>Payment Method</label>
<select name="paymentMethod">

<option value="UPI">UPI</option>
<option value="Cash">Cash</option>
<option value="Credit card">Credit</option>
<option value="Debit Card">Debit</option>
</select><br><br>
<input class="order" type="submit" value="Place Order">

</form>
</div>

</body>
</html>