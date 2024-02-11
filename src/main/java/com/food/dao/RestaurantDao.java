package com.food.dao;

import java.util.List;

import com.food.models.Restaurant;

public interface RestaurantDao {
	
	void addRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(int restaurantID);
	void upadateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurantId);
	List<Restaurant> getAllRestaurants();

}
