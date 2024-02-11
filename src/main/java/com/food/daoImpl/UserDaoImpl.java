package com.food.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.food.dao.UserDao;
import com.food.models.User;

public class UserDaoImpl implements UserDao{
	Connection connection=null;
	PreparedStatement statement=null;
	private static Statement statement1=null;
	 private static ResultSet res=null;
	
	public static final String ADD_QUERY="insert into User(userId,userName,password,email,phoneNumber,address,role) values(?,?,?,?,?,?,?)";
	public static final String GET="Select * from User where userName=?";
	public static final String UPDATE_QUERY="update User set userName=?,password=?,email=?,phoneNumber=?,address=?,role=? where userId=?";
	public static final String DELETE_QUERY="delete from User where userId=?";
	public static final String GET_ALL="Select * from User";
	
	public UserDaoImpl()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic","root","Priya.7252");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User user) {
	int i=0;
		try {
			statement = connection.prepareStatement(ADD_QUERY);
			statement.setInt(1, user.getUserID());
			statement.setString(2, user.getUserName());
			statement.setString(3,user.getPassword());
			statement.setString(4,user.getEmail());
			statement.setInt(5,user.getPhoneNumber());
			statement.setString(6,user.getAddress());
			statement.setString(7,user.getRole());
			
			 i=statement.executeUpdate();
			}
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public User getUser(String userName) {
	try {
			statement=connection.prepareStatement(GET);
			statement.setString(1,userName);
			res=statement.executeQuery();
			
			 if(res.next())
			    {
			    	int id1=res.getInt("userID");
			    	String name=res.getString("userName");
			    	String password=res.getString("password");
			    	String email=res.getString("email");
			    	int phoneNumber=res.getInt("phoneNumber");
			    	String address=res.getString("address");
			    	String role=res.getString("role");
			    	
			    User e= new User(id1,name,password,email,phoneNumber,address,role);
			     return e;
			    
			    }
		}
			     
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	return null;
	
	}

	@Override
	public void updateUser(User user) {

		
		try {
			statement=connection.prepareStatement(UPDATE_QUERY);
			statement.setString(1,user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setInt(4, user.getPhoneNumber());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getRole());
			
			statement.executeUpdate();
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}
	

	@Override
	public void deleteUser(int userId) {
		
		try {
			statement=connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1,userId );
			 statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<User> getAllUser() {
		ArrayList<User> user=new ArrayList<User>();
		
		try {
			statement1=connection.createStatement();
			res=statement1.executeQuery(GET_ALL);
		    while(res.next())
		    {
		    	int id=res.getInt("userID");
		    	String name=res.getString("userName");
		    	String password=res.getString("password");
		    	String email=res.getString("email");
		    	int phoneNumber=res.getInt("phoneNumber");
		    	String address=res.getString("address");
		    	String role=res.getString("role");
		    
		     User e=new User(id,name,password,email,phoneNumber,address,role);
		    user.add(e);
		} 
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return user;
		
	}

}
