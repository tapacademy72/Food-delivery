package com.food.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.daoImpl.UserDaoImpl;
import com.food.models.User;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			 String Username = request.getParameter("username");
			 String password = request.getParameter("password");
			 String email = request.getParameter("email");
		      String number2 = request.getParameter("number");
		      int number=Integer.parseInt(number2);
		     String role = request.getParameter("role");
		      
		      
		      User user=new User();
		      user.setUserName(Username);
		      user.setPassword(password);
		      user.setEmail(email);
		      user.setPhoneNumber(number);
		      user.setRole(role);
		      
		      
		      UserDaoImpl userImpl=new UserDaoImpl();
		      userImpl.addUser(user);
		      
		
	

	}

}
