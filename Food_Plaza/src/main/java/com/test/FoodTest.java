package com.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.FoodImpl;
import com.model.Food;

public class FoodTest {
	public static void main(String[] args) throws IOException {
		Scanner sc =new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int FoodId,fQuantity; String fName,fType,fCategory; float fPrice;
		Food f=new Food();
		FoodImpl foodObj =new FoodImpl();
		List<Food> l =new ArrayList<Food>();
		
		while(true) {
			
			System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.Show all data");
			System.out.println("enter the choice:");
			int choice=sc.nextInt();
			boolean b;
			
			switch(choice) {
			case 1:
				System.out.println("how many data you want to add:");
				int num=sc.nextInt();
				
				
				for(int i=1;i<=num;i++) {
					System.out.println("enter food name:");
					fName=br.readLine();
					System.out.println("enter food type:");
					fType=br.readLine();
					System.out.println("enter food category:");
					fCategory=br.readLine();
					System.out.println("enter food price:");
					fPrice=sc.nextFloat();
					
					b=foodObj.add_food(new Food(fName,fType,fCategory,fPrice));
					if(b) {
						System.out.println("Suceefully added"+fName);
					}else {
						System.out.println("failed");
					}
					
				}break;
				
			case 2:
				System.out.println("enter the food id:");
				FoodId=sc.nextInt();
				System.out.println("enter food name:");
				fName=br.readLine();
				System.out.println("enter food type:");
				fType=br.readLine();
				System.out.println("enter food category:");
				fCategory=br.readLine();
				System.out.println("enter food price:");
				fPrice=sc.nextFloat();
				Food food=new Food(fName,fType,fCategory,fPrice);
				food.setF_id(FoodId);
				
				b= foodObj.update_food_byid(food);
				
				if(b) {
					System.out.println("update sucessfully");
				}else {
					System.out.println("failed");
				}break;
				
				 
				case 3:
					System.out.println("enter the foodId for delete:");
					FoodId=sc.nextInt();
					if(FoodId==f.getF_id()){
					b=foodObj.delete_food_byid(FoodId);
					if(b) {
						System.out.println("delete sucessfully");	
					}else {
						System.out.println("failed");
					}
					}
					else {
						System.out.println("id doesn't exist.");
					}break;
					
				case 4:
					System.out.println("enter the foodId for search :");
					FoodId=sc.nextInt();
					
					f=foodObj.get_food_byid(FoodId);
					
					if(f!=null) {
						System.out.println(f);
					}else {
						System.out.println("not available");
					}break;
				
				case 5:
					System.out.println("show all data");
					
					l=foodObj.get_all_food();
					
					Iterator<Food>it=l.iterator();
					
					while(it.hasNext()) {
						System.out.println(it.next());
					}break;
			
				case 6:
					System.out.println("show all data");
					
					foodObj.get_all_food();
			
			}break;
			
		}
		
	}

}
