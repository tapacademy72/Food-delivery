package com.food.dao;

import java.util.List;

import com.food.models.Menu;

public interface MenuDao {
	void addMenu(Menu menu);
	Menu getMenu(int menuID);
	void updateMenu(Menu menu);
	void delete(int menuId);
	List<Menu> getAllByMeansOfRestaurant(int restaurantID);
	

}
