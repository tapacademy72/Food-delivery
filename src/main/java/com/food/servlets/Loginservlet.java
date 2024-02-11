package com.food.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoImpl.UserDaoImpl;
import com.food.models.User;


@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDaoImpl user=new UserDaoImpl();
		User user2 = user.getUser(parameter);
		String name=user2.getUserName();
		
		
		
		if(user2 != null && user2.getPassword().equals(password))
		{
			HttpSession session=request.getSession();
			
			session.setAttribute("loggedInUser", user2);
			session.setAttribute("UserName", name);
			
			response.sendRedirect("home");
			
		}
		else {
			request.setAttribute("errorMessage","Invalid username or password");
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
		
		

}
}
