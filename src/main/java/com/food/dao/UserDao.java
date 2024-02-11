package com.food.dao;

import java.util.List;

import com.food.models.User;

public interface UserDao {

	
	void addUser(User user);
	User getUser(String userName);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> getAllUser();
          
}
