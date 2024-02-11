package com.food.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImpl.MenuDaoImpl;
import com.food.models.Cart;
import com.food.models.CartItem;
import com.food.models.Menu;






@WebServlet("/cart")
public class Cartservlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
         
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart == null) {
			
			 cart=new Cart();
			 session.setAttribute("cart",cart); 
		}
		
          
		String action=request.getParameter("action");
		if(action.equals("add"))
		{
			addItemToCart(request,cart);
		}
		else if(action.equals("update"))
		{
			updateCartItem(request,cart);
		}
		else if(action.equals("remove")) {
			removeItemFromCart(request,cart);
		}
		
		session.setAttribute("cart",cart);
		response.sendRedirect("cartItem.jsp");
		
			
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("cartItem.jsp");
		rd.include(request, response);
		
	}
	
								
	
	public void addItemToCart(HttpServletRequest request,Cart cart) {
		
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		
		
		HttpSession session = request.getSession();
			
		MenuDaoImpl menuDao = new MenuDaoImpl();
		Menu menuItem =menuDao.getMenu(itemId);
		
		
		
		session.setAttribute("restaurantId",menuItem.getRestaurantID());
		
		
		
		if(menuItem != null) {
			
		CartItem item=new CartItem(
				
		  menuItem.getMenuId(), 
		  menuItem.getRestaurantID(),
		  menuItem.getItemName(),
		  quantity,
		  menuItem.getPrice()
		    
		);
		cart.addItem(item);
		}
	}
		
		  
		
		
	
	
	private void updateCartItem(HttpServletRequest request,Cart cart)
	{
        int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		cart.UpdateItem(itemId,quantity);
		
	}
	
	
	
	private void removeItemFromCart(HttpServletRequest request,Cart cart)
	{
        int itemId=Integer.parseInt(request.getParameter("itemId"));
        cart.removeItem(itemId);
	}
	
}
	     
	
	
		
		
			
