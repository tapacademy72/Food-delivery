package com.food.servlets;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderGenerator {
    public static void main(String[] args) {
        String orderId = generateOrderId();
        System.out.println(orderId);
       
       
    }

    public static String generateOrderId() {
        // Get current month and day
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        Date now = new Date();
        String month = monthFormat.format(now).toLowerCase();
        String day = dayFormat.format(now);

        // Generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        // Combine month, random number, and day to form the order ID
        String orderId = month + randomNumber + day;

        return orderId;
    }
}
		        	
		        
