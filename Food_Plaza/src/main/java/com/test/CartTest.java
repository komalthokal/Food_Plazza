package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.CartImpl;
import com.dao.CustomerImpl;
import com.model.Cart;
import com.model.Customer;

public class CartTest {
	public static void main(String[] args) throws IOException {
		Scanner sc =new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int c_id,foodId,quantity;String emailId,foodName;float foodprice,totalprice;
		CartImpl cartObj =new CartImpl();
		
		
		while(true) {
			System.out.println("1.Add\n2.Delete\n3.Clear\n4.Show");
			System.out.println("Enter the choice:");
			int choice=sc.nextInt();
			boolean b;
			
			switch(choice) {
			case 1:
				System.out.println("Enter how many items add to cart:");
				int num=sc.nextInt();
				
				for(int i=1;i<=num;i++) {
					System.out.println("Enter food id:");
					foodId=sc.nextInt();
					System.out.println("Enter the quantity:");
					quantity=sc.nextInt();
					System.out.println("Enter email id:");
					emailId=br.readLine();
					System.out.println("Enter food name:");
					foodName=br.readLine();
					System.out.println("Enter the price");
					foodprice=sc.nextFloat();
					totalprice=foodprice*quantity;
					
					b=cartObj.add_tocart(new Cart(foodId, emailId, foodName, foodprice, quantity, totalprice));
					if(b) {
						System.out.println("Add to Cart");
					}else {
						System.out.println("Fail to cart");
					}	
				}break;
				
			case 2:
				System.out.println("Enter the existing c_Id:");
				c_id=sc.nextInt();
				b=cartObj.delete_cart(c_id);
				if(b) {
					System.out.println("Deleted successfully");
				}else {
					System.out.println("Failed");
				}break;
				
			case 3:
				System.out.println("Enter the existing emailId:");
				emailId=br.readLine();
				b=cartObj.clear_cart(emailId);
				if(b) {
					System.out.println("Clear successfully");
				}else {
					System.out.println("Fail");
				}break;
				
			case 4:
				System.out.println("Enter the emailId:");
				emailId=br.readLine();
				List<Cart> l=cartObj.show_cart(emailId);
				Iterator<Cart> itr=l.iterator();
				while(itr.hasNext()) {
					System.out.println(itr.next());
				}
				break;
				
			}
		}
	}

}
