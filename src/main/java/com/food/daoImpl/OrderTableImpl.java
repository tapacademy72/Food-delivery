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

import com.food.dao.OrderTableDao;
import com.food.models.OrderTable;


public class OrderTableImpl implements OrderTableDao {
	
	private static Connection connection=null;
	private static PreparedStatement statement=null;
	private static Statement statement1=null;
	 private static ResultSet res=null;
	
	public static final String ADD_QUERY="insert into  `OrderTable`(orderId, userID, restaurantID,  orderDate,totalAmount, status, paymentMode) values(?,?,?,?,?,?,?)";
	                                                 
	public static final String GET="Select * from  OrderTable where StringrderId=?";
	public static final String UPDATE_QUERY="update OrderTable set  int userID=?, int restaurantID=?, Date orderDate=?, double totalAmount=?, String status=?,String paymentMode=? where String orderId=?";
	public static final String DELETE_QUERY="delete from OrderTable where orderId=?";
	public static final String GET_ALL="Select * from OrderTable";
	
	
	
	
	public OrderTableImpl ()
	 {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic","root","Priya.7252");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 
	 }



	@Override
	public void addOrderTable(OrderTable orderTable) {
		
		int i=0;
		try {
			statement = connection.prepareStatement(ADD_QUERY);
			
			statement.setString(1,orderTable.getOrderId());
			statement.setInt(2,orderTable.getUserID());
			statement.setInt(3,orderTable.getRestaurantID());
			statement.setDate(4, orderTable.getOrderDate());
			statement.setDouble(5,orderTable.getTotalAmount());
			statement.setString(6,orderTable.getStatus());
			statement.setString(7,orderTable.getPaymentMode());
	
			
			 i=statement.executeUpdate();
			}
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		
	}

	@Override
	public OrderTable getOrderTable(String orderId) {
		try {
			statement=connection.prepareStatement(GET);
			statement.setString(1,orderId);
			res=statement.executeQuery();
			
			
			 if(res.next())
			    {
				 String orderid=res.getString("orderId");
			    	int userid=res.getInt("userID");
			    	int restaurantid=res.getInt("restaurantID");
			    	Date date=res.getDate("orderDate");
			    	double totalAmount=res.getDouble("totalAmount");
			    	String status=res.getString("status");
			    	String paymentmode=res.getString("paymentMode");
			    	
			    	
			    	
			   return new OrderTable(orderid,userid,restaurantid,date,totalAmount,status,paymentmode);
			     
			    
			    }
		}
			     
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
		return null;
	}

	@Override
	public void updateOrderTable(OrderTable orderTable) {
		try {
		statement = connection.prepareStatement(UPDATE_QUERY);
		statement.setString(1,orderTable.getOrderId());
		statement.setInt(2,orderTable.getUserID());
		statement.setInt(3,orderTable.getRestaurantID());
		statement.setDate(4, orderTable.getOrderDate());
		statement.setDouble(5,orderTable.getTotalAmount());
		statement.setString(6,orderTable.getStatus());
		statement.setString(7,orderTable.getPaymentMode());
		
	
		
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
		
	}

	@Override
	public void deleteOrderTable(String orderID) {
		try {
			statement=connection.prepareStatement(DELETE_QUERY);
			statement.setString(1,orderID );
			 statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderTable> getAllByMeansOfRestaurant(int userID) {
		
		ArrayList<OrderTable> ordertable=new ArrayList<OrderTable>();
		try {
			statement1=connection.createStatement();
			res=statement1.executeQuery(GET_ALL);
		  
		      while(res.next())
		    {
			 String orderid=res.getString("orderId");
		    	int userid=res.getInt("userID");
		    	int restaurantid=res.getInt("restaurantID");
		    	Date date=res.getDate("orderDate");
		    	double totalAmount=res.getDouble("totalAmount");
		    	String status=res.getString("status");
		    	String paymentmode=res.getString("paymentMode");
		    	
		    	
		    	
		    	
		   OrderTable e= new OrderTable(orderid,userid,restaurantid,date,totalAmount,status,paymentmode);
		   ordertable.add(e);
		    }
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			return ordertable;
			
		}



	



	

	}
