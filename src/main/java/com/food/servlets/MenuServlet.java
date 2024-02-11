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

import com.food.daoImpl.MenuDaoImpl;


@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {
	
	
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String restaurantid = request.getParameter("restaurantID");
		
		MenuDaoImpl Impl = new MenuDaoImpl();
		//com.food.models.Menu menu = Impl.getMenu(24);
		//System.out.println(menu.getItemName());
		
		List<com.food.models.Menu> all = Impl.getAllByMeansOfRestaurant(Integer.parseInt(restaurantid));
		request.setAttribute("menus", all);
		
		RequestDispatcher rd = request.getRequestDispatcher("menudetails.jsp");
		rd.include(request, response);
	}

}
