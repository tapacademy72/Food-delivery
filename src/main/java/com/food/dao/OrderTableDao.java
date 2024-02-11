package com.food.dao;

import java.util.List;

import com.food.models.OrderTable;



public interface OrderTableDao {
	void addOrderTable( OrderTable orderTable);
	OrderTable getOrderTable(String orderId);
	void updateOrderTable(OrderTable orderTable);
	void deleteOrderTable(String orderID);
	List<OrderTable> getAllByMeansOfRestaurant(int userID);

}
