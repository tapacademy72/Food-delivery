package com.food.models;

public class CartItem {
	
   private int itemID;
   private int restaurantID;
   private String name;
   private int quantity;
   private double price;
   
   
public CartItem() {
	super();
	
}


public CartItem(int itemID, int restaurantID, String name, int quantity, double price) {
	super();
	this.itemID = itemID;
	this.restaurantID = restaurantID;
	this.name = name;
	this.quantity = quantity;
	this.price = price;
}


public int getItemID() {
	return itemID;
}


public void setItemID(int itemID) {
	this.itemID = itemID;
}


public int getRestaurantID() {
	return restaurantID;
}


public void setRestaurantID(int restaurantID) {
	this.restaurantID = restaurantID;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


@Override
public String toString() {
	return "CartItems [itemID=" + itemID + ", restaurantID=" + restaurantID + ", name=" + name + ", quantity="
			+ quantity + ", price=" + price + "]";
}
   
   
	

}
