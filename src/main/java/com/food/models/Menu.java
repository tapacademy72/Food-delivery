package com.food.models;

public class Menu {
	private int MenuId;
	private int restaurantID;
	private String ItemName;
	private String Description;
	private int Price;
	private double Rating;
	private boolean isAvailable;
	private String imagePath;
	
	public Menu() {
		
		
	}

	public Menu(int menuId, int restaurantID, String itemName, String description, int price, double rating,
			boolean isAvailable, String imagePath) {
		super();
		MenuId = menuId;
		this.restaurantID = restaurantID;
		ItemName = itemName;
		Description = description;
		Price = price;
		Rating = rating;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return MenuId;
	}

	public void setMenuId(int menuId) {
		MenuId = menuId;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public double getRating() {
		return Rating;
	}

	public void setRating(double rating) {
		Rating = rating;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Menu [MenuId=" + MenuId + ", restaurantID=" + restaurantID + ", ItemName=" + ItemName + ", Description="
				+ Description + ", Price=" + Price + ", Rating=" + Rating + ", isAvailable=" + isAvailable
				+ ", imagePath=" + imagePath + "]";
	}

	

	


}
