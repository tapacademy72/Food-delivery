package com.food.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderItemDao;
import com.food.models.OrderItem;
import com.food.models.OrderTable;

public class OrderItemDaoImpl implements OrderItemDao {
	
	private static Connection connection=null;
	private static PreparedStatement statement=null;
	private static Statement statement1=null;
	 private static ResultSet res=null;
	
	public static final String ADD_QUERY="insert into OrderItem(orderItemId, orderId, menuID,  quantity, itemTotal) values(?,?,?,?,?)";
				                                                 
	public static final String GET="Select * from  OrderItem where int orderItemId=?";
	public static final String UPDATE_QUERY="update OrderItem set   int orderId=?, int menuID=?, int quantity=?, double itemTotal=? where orderItemId=?";
	public static final String DELETE_QUERY="delete from OrderItem where orderItemId=?";
	public static final String GET_ALL="Select * from OrderItem";
	
	
	public OrderItemDaoImpl ()
	 {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic","root","Priya.7252");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 
	 }





	@Override
	public int addOrderItem(OrderItem orderItem) {
		int i=0;
		try {
			statement = connection.prepareStatement(ADD_QUERY);
			statement.setInt(1,orderItem.getOrderItemId());
			statement.setString(2,orderItem.getOrderId());
			statement.setInt(3,orderItem.getMenuID());
			statement.setInt(4, orderItem.getQuantity());
			statement.setDouble(5,orderItem.getItemTotal());
			

			 i=statement.executeUpdate();
			}
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
		
	}

	@Override
	public OrderItem getOrderItem(int orderItemID) {
		try {
			statement=connection.prepareStatement(GET);
			statement.setInt(1,orderItemID);
			res=statement.executeQuery();
			
			
			 if(res.next())
			    {
				 int orderitemid=res.getInt("orderItemId");
			    	String orderid=res.getString("orderID");
			    	int menuid=res.getInt("menuID");
			    	int quality=res.getInt("quality");
			    	double itemTotal=res.getDouble("itemTotal");
			    	
			    	
			    	
			    	
			   OrderItem e= new OrderItem(orderitemid,orderid,menuid,quality,itemTotal);
			     return e;
			    
			    }
		}
			     
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		
		int i=0;
		try {
			statement = connection.prepareStatement(UPDATE_QUERY);
			statement.setInt(1,orderItem.getOrderItemId());
			statement.setString(2,orderItem.getOrderId());
			statement.setInt(3,orderItem.getMenuID());
			statement.setInt(4, orderItem.getQuantity());
			statement.setDouble(5,orderItem.getItemTotal());
			

			 i=statement.executeUpdate();
			}
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderItem(int orderItemID) {
		try {
			statement=connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1,orderItemID );
			 statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<OrderItem> getAllByMeansOfRestaurant(int userID) {
		

		ArrayList<OrderItem> orderitem=new ArrayList<OrderItem>();
		try {
			statement1=connection.createStatement();
			res=statement1.executeQuery(GET_ALL);
		  
		
		    while(res.next())
		    {
			 int orderitemid=res.getInt("orderItemId");
		    	String orderid=res.getString("orderID");
		    	int menuid=res.getInt("menuID");
		    	int quality=res.getInt("quality");
		    	double itemTotal=res.getDouble("itemTotal");
		    	
		    	
		    	
		    	
		   OrderItem e= new OrderItem(orderitemid,orderid,menuid,quality,itemTotal);
		     orderitem.add(e);
		    
		    }
	}
		     
	catch (SQLException e) {
		
		e.printStackTrace();
	}

	return null;

	}

}
