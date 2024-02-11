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

import com.food.dao.OrderHistoryDao;
import com.food.models.OrderHistory;
import com.food.models.OrderItem;

public class OrderHistoryDaoImpl implements OrderHistoryDao{
	Connection connection=null;
	PreparedStatement statement=null;
	private static Statement statement1=null;
	 private static ResultSet res=null;
	
	public static final String ADD_QUERY="insert into OrderHistory(int orderHistoryId, int userID, int orderId, Date orderDate, double totalAmount,String status)  values(?,?,?,?,?,?,?)";
			                                                 
	public static final String GET="Select * from  OrderHistory where int orderHistoryId=?";
	public static final String UPDATE_QUERY="update OrderHistory set    int userID=?, int orderId=?, Date orderDate=?, double totalAmount=?,String status=? where int orderHistoryId";
	public static final String DELETE_QUERY="delete from OrderHistory where orderHistoryId=?";
	public static final String GET_ALL="Select * from OrderHistory";
	
	
	public OrderHistoryDaoImpl ()
	 {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic","root","Priya.7252");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 
	 }




	@Override
	public void addOrderHistory(OrderHistory order) {
		int i=0;
		try {
			statement = connection.prepareStatement(ADD_QUERY);
			statement.setInt(1,order.getOrderHistoryId());
			statement.setInt(2,order.getUserID());
			statement.setInt(3,order.getOrderId());
			statement.setDate(4, order.getOrderDate());
			statement.setDouble(5,order.getTotalAmount());
			statement.setString(6,order.getStatus());
			

			 i=statement.executeUpdate();
			}
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryID) {
		
		try {
			statement=connection.prepareStatement(GET);
			statement.setInt(1,orderHistoryID);
			res=statement.executeQuery();
			
			
			 if(res.next())
			    {
				 int orderHistoryid=res.getInt("orderHistoryId");
			    	int userid=res.getInt("userID");
			    	int orderid=res.getInt("orderID");
			    	Date date=res.getDate("orderDate");
			    	double Total=res.getDouble("totalAmount");
			    	String status=res.getString("status");
			    	
			    	
			    	
			    	
			   OrderHistory e= new OrderHistory(orderHistoryid,userid,orderid,date,Total,status);
			     return e;
			    
			    }
		}
			     
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
		
		return null;
	}

	@Override
	public void updateOrderHistory(OrderHistory order) {
		int i=0;
		try {
			statement = connection.prepareStatement(UPDATE_QUERY);
			statement.setInt(1,order.getOrderHistoryId());
			statement.setInt(2,order.getUserID());
			statement.setInt(3,order.getOrderId());
			statement.setDate(4, order.getOrderDate());
			statement.setDouble(5,order.getTotalAmount());
			statement.setString(6,order.getStatus());
			

			 i=statement.executeUpdate();
			}
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryID) {
		try {
			statement=connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1,orderHistoryID );
			 statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}

	@Override
	public List<OrderHistory> getAllByMeansOfRestaurant(int userID) {
    ArrayList<OrderHistory> orderHistory=new ArrayList<OrderHistory>();
		try {
			statement1=connection.createStatement();
			res=statement1.executeQuery(GET_ALL);

			 if(res.next())
			    {
				 int orderHistoryid=res.getInt("orderHistoryId");
			    	int userid=res.getInt("userID");
			    	int orderid=res.getInt("orderID");
			    	Date date=res.getDate("orderDate");
			    	double Total=res.getDouble("totalAmount");
			    	String status=res.getString("status");
			    	
			    	
			    	
			    	
			   OrderHistory e= new OrderHistory(orderHistoryid,userid,orderid,date,Total,status);
			   orderHistory.add(e);  
			
		
	}

}
		catch (SQLException e) {
			
			e.printStackTrace();
		}

		return orderHistory;

		}
}

	
