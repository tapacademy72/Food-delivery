package com.food.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GenerateOrderId")
public class GenerateOrderId extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        // Get current month and day
		
		  HttpSession session = request.getSession();
        //PrintWriter out=response.getWriter();
        
        
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        Date now = new Date();
        String month = monthFormat.format(now).toLowerCase();
        String day = dayFormat.format(now);

        // Generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        // Combine month, random number, and day to form the order ID
        String orderId = month + randomNumber + day;
        
        
        session.setAttribute("ordermain", orderId);
        //out.println(orderId);

        response.sendRedirect("checkout");
      
    }

}
