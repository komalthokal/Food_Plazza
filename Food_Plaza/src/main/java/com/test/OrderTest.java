package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.OrderImpl;
import com.model.Orders;

public class OrderTest {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		OrderImpl od=new OrderImpl();
		String emailId;
		int choice;
		while(true) {
			System.out.println("****Order*****");
			System.out.println("1.Place Order \n2.Show Order\n3.Exit");
			System.out.println("Enter choice:");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter an existing emailId:");
				emailId=br.readLine();
				Orders o=od.place_order(emailId);
				if(o!=null) {
					System.out.println(o);
				}else {
					System.out.println("Failed");
				}break;
				
			case 2:
				System.out.println("Show order");
				List<Orders>l=od.show_order();
				Iterator<Orders>itr=l.iterator();
				while(itr.hasNext()) {
					System.out.println(itr.next());
				}
				break;
			}
		}
	}

}
