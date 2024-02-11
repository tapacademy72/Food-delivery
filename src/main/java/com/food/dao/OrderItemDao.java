package com.food.dao;

import java.util.List;

import com.food.models.OrderItem;

public interface OrderItemDao {
	int addOrderItem( OrderItem orderItem);
	OrderItem getOrderItem(int orderItemID);
	void updateOrderItem(OrderItem orderItem);
	void deleteOrderItem(int orderItemID);
	List<OrderItem> getAllByMeansOfRestaurant(int userID);


}
