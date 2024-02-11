package com.food.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImpl.OrderItemDaoImpl;
import com.food.daoImpl.OrderTableImpl;
import com.food.models.Cart;
import com.food.models.CartItem;
import com.food.models.OrderItem;
import com.food.models.OrderTable;
import com.food.models.User;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;


@WebServlet("/checkout")
public class Checkoutservlet extends HttpServlet {
	
  
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter writer = response.getWriter();
		
		HttpSession session=request.getSession();
		
		 SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
	        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
	        Calendar calendar = Calendar.getInstance();
	         Date now  = new Date(calendar.getTimeInMillis());
	        String month = monthFormat.format(now).toLowerCase();
	        String day = dayFormat.format(now);

	        // Generate a random number
	        Random random = new Random();
	        int randomNumber = random.nextInt(10000);

	        // Combine month, random number, and day to form the order ID
	        String orderId = month + randomNumber + day;
	        
	 	Cart cart=(Cart)session.getAttribute("cart");
		
		
		
		User user=(User)session.getAttribute("loggedInUser");
	
		

	
		if(cart != null &&  user != null &&  !cart.getItems().isEmpty())
		{
			String paymentMethod=request.getParameter("paymentMethod");
			
			//create and populate the order object
			
			OrderTable order=new OrderTable();
			
			
			order.setOrderId(orderId);
			order.setUserID(user.getUserID());
			order.setRestaurantID((int)session.getAttribute("restaurantId"));
			order.setOrderDate(now);	
			order.setStatus("pending");
			order.setPaymentMode(paymentMethod);
		
		
			double totalAmount=0;
			
			for(CartItem item :cart.getItems().values()) {
			totalAmount += item.getPrice()*item.getQuantity();
				
				
			}
			order.setTotalAmount(totalAmount);
			
		
			OrderTableImpl orderDao=new OrderTableImpl();
			orderDao.addOrderTable(order);
			
			
			
			OrderItem item=new OrderItem();
			item.setOrderId(orderId);
			
			
			for(CartItem items :cart.getItems().values()) {
				
				
				
				int itemID = items.getItemID();
				
				totalAmount += items.getPrice()*item.getQuantity();
				int quantity=items.getQuantity();
			
			item.setMenuID(itemID);
			item.setItemTotal(totalAmount);
			item.setQuantity(quantity);
		
				
			}
			 OrderItemDaoImpl impl=new OrderItemDaoImpl();
			
			
			 impl.addOrderItem(item);
			 
			 
			 
	
			session.setAttribute("order", order);
			
			response.sendRedirect("OrderConfirmation.jsp");
		}
		else if(cart==null)
		{
			response.sendRedirect("home");
			writer.println("You card is empty add some items to card");
		}
		else if(user ==null)
		{
			
			response.sendRedirect("LoginPage.jsp");
			writer.println("you have not logggined to your acccount please login");
		}
		else {
			response.sendRedirect("home");
			writer.println("You card is empty add some items to card");
		}
		
		
		
	
	
	
	
	}	
	

}
