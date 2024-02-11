package com.food.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImpl.MenuDaoImpl;
import com.food.daoImpl.OrderItemDaoImpl;
import com.food.models.Cart;
import com.food.models.CartItem;
import com.food.models.Menu;
import com.food.models.OrderItem;


@WebServlet("/OrderItems")
public class OrderItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		
		
	}

}

