package com.food.dao;

import java.util.List;

import com.food.models.OrderHistory;

public interface OrderHistoryDao {
	void addOrderHistory( OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderHistoryID);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int orderHistoryID);
	List<OrderHistory> getAllByMeansOfRestaurant(int userID);                                         


}
