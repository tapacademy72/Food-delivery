package com.food.daoImpl;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Time;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.food.dao.RestaurantDao;
import com.food.models.Restaurant;


public class RestaurantDaoImpl implements RestaurantDao{
	
	private static Connection connection=null;
	private static PreparedStatement statement=null;
	private static Statement statement1=null;
	private static ResultSet res=null;
	
	 
	public static final String ADD_QUERY="insert into Restaurant(int restaurantID, String restaurantName, int phoneNumber, String address, double rating, String cuisineType, boolean isActive, Time estimate_Time, String imagePath, int adminUserId) values(?,?,?,?,?,?,?,?,?,?)";
				                                                 
	public static final String GET="Select * from  Restaurant where restaurantID=?";
	public static final String UPDATE_QUERY="update Restaurant set int String restaurantName=?, int phoneNumber=?, String address=?, double rating=?, String cuisineType=?, boolean isActive=?, Time estimate_Time=?, String imagePath=?, int adminUserId=? where restaurantId=?";
	public static final String DELETE_QUERY="delete from Restaurant where restaurantID=?";
	public static final String GET_ALL="Select * from Restaurant";
	
	
	public RestaurantDaoImpl ()
	 {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic","root","Priya.7252");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 
	 }
	 

	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		int i=0;
		try {
			statement = connection.prepareStatement(ADD_QUERY);
			statement.setInt(1,restaurant.getRestaurantID());
			statement.setString(2, restaurant.getRestaurantName());
			statement.setInt(3,restaurant.getPhoneNumber());
			statement.setString(4,restaurant.getAddress());
			statement.setDouble(5,restaurant.getRating());
			statement.setString(6,restaurant.getCuisineType());
			statement.setBoolean(7,restaurant.isActive());
			statement.setTime(8, restaurant.getEstimate_Time());
			statement.setString(9,restaurant.getImagePath());
			statement.setInt(10,restaurant.getAdminUserId());
			
			
			
			 i=statement.executeUpdate();
			}
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant getRestaurant(int restaurantID) {
		try {
		statement=connection.prepareStatement(GET);
		statement.setInt(1,restaurantID);
		res=statement.executeQuery();
		
		
		 if(res.next())
		    {
		    	int id1=res.getInt("restauranID");
		    	String name=res.getString("restaurantName");
		    	int phoneNumber=res.getInt("phoneNumber");
		    	String address=res.getString("address");
		    	double rating=res.getDouble("rating");
		    	String cuisiveType=res.getString("cuisiveType");
		    	Boolean isActive=res.getBoolean("isActive");
		    	Time estimate_Time=res.getTime("estimate_Time");
		    	String imagePath=res.getString("imagePath");
		    	int adminUserId=res.getInt("adminUserId");
		    	
		    	
		    	
		   return new Restaurant(id1,name,phoneNumber,address,rating,cuisiveType,isActive,estimate_Time,imagePath,adminUserId);
		    
		    
		    }
	}
		     
	catch (SQLException e) {
		
		e.printStackTrace();
	}
		return null;
		
	
	}

	@Override
	public void upadateRestaurant(Restaurant restaurant) {
		try {
			statement=connection.prepareStatement(UPDATE_QUERY);
			
			statement.setString(1, restaurant.getRestaurantName());
			statement.setInt(2,restaurant.getPhoneNumber());
			statement.setString(3,restaurant.getAddress());
			statement.setDouble(4,restaurant.getRating());
			statement.setString(5,restaurant.getCuisineType());
			statement.setBoolean(6,restaurant.isActive());
			statement.setTime(7, restaurant.getEstimate_Time());
			statement.setString(8,restaurant.getImagePath());
			statement.setInt(9,restaurant.getAdminUserId());
			statement.setInt(10,restaurant.getRestaurantID());
			
			statement.executeUpdate();
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		try {
			statement=connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1,restaurantId );
			 statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		
		ArrayList<Restaurant> restaurant=new ArrayList<Restaurant>();
		try {
			statement1=connection.createStatement();
			res=statement1.executeQuery(GET_ALL);
			while(res.next())
		    {
		    	int id1=res.getInt("restaurantID");
		    	String name=res.getString("restaurantName");
		    	int phoneNumber=res.getInt("phoneNumber");
		    	String address=res.getString("address");
		    	double rating=res.getDouble("rating");
		    	String cuisineType=res.getString("cuisineType");
		    	Boolean isActive=res.getBoolean("isActive");
		    	Time estimate_Time=res.getTime("estimate_Time");
		    	String imagePath=res.getString("imagePath");
		    	int adminUserId=res.getInt("adminUserId");
		    	
		    	
		    	
		   Restaurant e= new Restaurant(id1,name,phoneNumber,address,rating,cuisineType,isActive,estimate_Time,imagePath,adminUserId);
			
			restaurant.add(e);
		
		
         	}
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return restaurant;
		
	}

}


