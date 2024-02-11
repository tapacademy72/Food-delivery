package com.food.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImpl.RestaurantDaoImpl;
import com.food.models.Restaurant;


@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDaoImpl impl = new  RestaurantDaoImpl();
		
		List<Restaurant> all = impl.getAllRestaurants();
		request.setAttribute("restaurant",all );
	
		RequestDispatcher rd = request.getRequestDispatcher("restaurant.jsp");
		rd.include(request, resp);
		
		
	}


	


	
}
