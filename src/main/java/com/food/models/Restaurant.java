package com.food.models;

import java.sql.Time;

public class Restaurant {
	
	private int restaurantID;
	private String restaurantName;
	private int phoneNumber;
	private String address;
	private double rating;
	private String cuisineType;
	private boolean isActive;
	private Time estimate_Time;
	private String imagePath;
	private int adminUserId;
	
	public Restaurant(){
		
	}

	public Restaurant(int restaurantID, String restaurantName, int phoneNumber, String address, double rating,
			String cuisineType, boolean isActive, Time estimate_Time, String imagePath, int adminUserId) {
		super();
		this.restaurantID = restaurantID;
		this.restaurantName = restaurantName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.rating = rating;
		this.cuisineType = cuisineType;
		this.isActive = isActive;
		this.estimate_Time = estimate_Time;
		this.imagePath = imagePath;
		this.adminUserId = adminUserId;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Time getEstimate_Time() {
		return estimate_Time;
	}

	public void setEstimate_Time(Time estimate_Time) {
		this.estimate_Time = estimate_Time;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantID=" + restaurantID + ", restaurantName=" + restaurantName + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", rating=" + rating + ", cuisineType=" + cuisineType
				+ ", isActive=" + isActive + ", estimate_Time=" + estimate_Time + ", imagePath=" + imagePath
				+ ", adminUserId=" + adminUserId + "]";
	}

	
	

}
