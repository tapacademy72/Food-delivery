package com.food.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.MenuDao;
import com.food.models.Menu;

public class MenuDaoImpl implements MenuDao {
	Connection connection=null;
	PreparedStatement statement=null;
	private static Statement statement1=null;
	 private static ResultSet res=null;
	
	public static final String ADD_QUERY="insert into Menu(( menuId,  restaurantID, itemName,description,  price, rating, isAvailable,  imagePath values(?,?,?,?,?,?,?,?)";
    public static final String GET="Select * from Menu where menuId=?";
	public static final String UPDATE_QUERY="update Menu set int restaurantID=?, String itemName=?,String description, =?, int price=?, double rating=?, boolean isAvailable=?, String imagePath=? where menuId=?";
	public static final String DELETE_QUERY="delete from Menu where menuId=?";
	public static final String GET_ALL="Select * from Menu where restaurantID=?";
	
	
	public MenuDaoImpl ()
	 {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic","root","Priya.7252");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 
	 }

	@Override
	public void addMenu(Menu menu) {
		
		int i=0;
		try {
			statement = connection.prepareStatement(ADD_QUERY);
			statement.setInt(1,menu.getMenuId());
			statement.setInt(2, menu.getRestaurantID());
			statement.setString(3,menu.getItemName());
			statement.setString(4,menu.getDescription());
            statement.setInt(5, menu.getPrice());
			statement.setDouble(6,menu.getRating());

			statement.setBoolean(7,menu.isAvailable());
			statement.setString(8, menu.getImagePath());
			
			
			
			
			 i=statement.executeUpdate();
			}
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	@Override
	public Menu getMenu(int itemId) {
		try {
			statement=connection.prepareStatement(GET);
			statement.setInt(1,itemId);
			res=statement.executeQuery();
			
			 if(res.next())
			    {
			    	int id1=res.getInt("menuId");
			    	int restaurantid=res.getInt("restaurantID");
			    	String name=res.getString("itemName");
			    	String description=res.getString("description");
			    	 int price=res.getInt("price");
			    	 double rating=res.getDouble("rating");
			    	 boolean available=res.getBoolean("isAvailable"); 
			    	String imagePath=res.getString("imagePath");
			    	
			    	
			    
				return new Menu(id1,restaurantid,name,description,price,rating,available,imagePath);
			   
			    
			    }
		}
			     
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void updateMenu(Menu menu) {
		int i=0;
		try {
			statement = connection.prepareStatement(UPDATE_QUERY);
			statement.setInt(1,menu.getMenuId());
			statement.setInt(2, menu.getRestaurantID());
			statement.setString(3,menu.getItemName());
			statement.setString(4,menu.getDescription());
            statement.setInt(5, menu.getPrice());
			statement.setDouble(6,menu.getRating());

			statement.setBoolean(7,menu.isAvailable());
			statement.setString(8, menu.getImagePath());
			
			
			
			
			 i=statement.executeUpdate();
			}
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int menuId) {
		try {
			statement=connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1,menuId );
			 statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
		

	@Override
	public List<Menu> getAllByMeansOfRestaurant(int restaurantID) {
		
		ArrayList<Menu> menu=new ArrayList<Menu>();
		try {
			statement=connection.prepareStatement(GET_ALL);
			statement.setInt(1,restaurantID);
			
			res=statement.executeQuery();
			
			while(res.next())
			    {
			    	int id=res.getInt("menuId");
			    	int restaurantid2=res.getInt("restaurantID");
			    	String name=res.getString("itemName");
			    	String description=res.getString("description");
			    	 int price=res.getInt("price");
			    	 double rating=res.getDouble("rating");
			    	 boolean available=res.getBoolean("isAvailable"); 
			    	String imagePath=res.getString("imagePath");
			    	
			    	
			    
				 Menu e= new Menu(id,restaurantid2,name,description,price,rating,available,imagePath);
			     menu.add(e);			    
			    }
		}
			     
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return menu;
		
	}

	

}
