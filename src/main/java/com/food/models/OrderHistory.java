package com.food.models;

import java.sql.Date;

public class OrderHistory {
	private int OrderHistoryId;
	private int userID;
	private int orderId;
	private Date OrderDate;
	private double TotalAmount;
	private String Status;
	
	public OrderHistory() {
		
	}

	public OrderHistory(int orderHistoryId, int userID, int orderId, Date orderDate, double totalAmount,
			String status) {
		super();
		OrderHistoryId = orderHistoryId;
		this.userID = userID;
		this.orderId = orderId;
		OrderDate = orderDate;
		TotalAmount = totalAmount;
		Status = status;
	}

	public int getOrderHistoryId() {
		return OrderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		OrderHistoryId = orderHistoryId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "OrderHistory [OrderHistoryId=" + OrderHistoryId + ", userID=" + userID + ", orderId=" + orderId
				+ ", OrderDate=" + OrderDate + ", TotalAmount=" + TotalAmount + ", Status=" + Status + "]";
	}
	
	
	

}
