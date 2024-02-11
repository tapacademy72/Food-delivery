package com.food.models;

import java.util.HashMap;



public class Cart{
	
	private HashMap<Integer,CartItem> items;

	public Cart() {
		
		this.items=new HashMap<Integer,CartItem>();
	}
	
	
	
   public void addItem(CartItem item)
	{
		int itemId=item.getItemID();
		if(items.containsKey(itemId)) {
			
		//if item already exists increase quantity
			CartItem existingItem = items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());
		}
		else
		{
			items.put(itemId, item);
		}
		
	}
	
	
   
   public void UpdateItem(int itemID,int quantity)
    {
	   if(items.containsKey(itemID))
	   {
		   if(quantity<=0)
		   {
			   items.remove(itemID);
		   }else {
			   items.get(itemID).setQuantity(quantity);
		   }
	   }
    	
    }
   
   
   
	
	public void removeItem(int itemID)
	{
		items.remove(itemID);
	}
	
	
	public HashMap<Integer,CartItem> getItems()
	{
		return items;
		
	}
	
	
	public void clear()
	{
		items.clear();
	}
	

}
