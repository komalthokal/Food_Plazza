package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.CustomerImpl;
import com.model.Customer;


public class CustomerTest {

	public static void main(String[] args) throws IOException {
		Scanner sc =new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String C_name, C_email, C_pass, C_address; long C_contact;
		//Customer c=new Customer();
		CustomerImpl customerObj =new CustomerImpl();
		List<Customer> l=new ArrayList<Customer>();
		
		while(true) {
			System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.Show all customer");
			System.out.println("enter the choice:");
			int choice=sc.nextInt();
			boolean b;
			
			switch(choice) {
			case 1:
				System.out.println("how many customer you want to add:");
				int num=sc.nextInt();
				
				
				for(int i=1;i<=num;i++) {
					System.out.println("enter customer name:");
					C_name=br.readLine();
					System.out.println("enter customer email:");
					C_email=br.readLine();
					System.out.println("enter customer pass:");
					C_pass=br.readLine();
					System.out.println("enter customer contact:");
					C_contact=sc.nextLong();
					System.out.println("enter customer address:");
					C_address=br.readLine();
					
					b=customerObj.add_customer(new Customer(C_name,C_email,C_pass,C_contact,C_address));
					if(b) {
						System.out.println("Suceefully added"+C_name);
					}else {
						System.out.println("failed");
					}
					
				}break;
				
			case 2:
				System.out.println("enter customer email id:");
				C_email=sc.next();
				System.out.println("enter customer name:");
				C_name=br.readLine();
				System.out.println("enter customer pass:");
				C_pass=br.readLine();
				System.out.println("enter customer address");
				C_address=br.readLine();
				System.out.println("enter customer contact:");
				C_contact=sc.nextLong();
				Customer customer=new Customer(C_name,C_email,C_pass,C_contact,C_address);
				customer.setC_email(C_email);
				
				b=customerObj.update_customer_byiemail(customer);
				
				if(b) {
					System.out.println("update sucessfully");
				}else {
					System.out.println("failed");
				}break;
				
			case 3:
				System.out.println("enter the email for delete:");
				C_email=sc.next();
//				if(C_email==c.getC_email()){
				b=customerObj.delete_customer_byemail(C_email);
				if(b) {
					System.out.println("delete sucessfully");	
				}else {
					System.out.println("failed");
				}
				//}
//				else {
//					System.out.println("id doesn't exist.");
//				}
				break;
				
			case 4:
				System.out.println("enter  c_email for search :");
				C_email=br.readLine();
				
				Customer c=new Customer();
				
				c=customerObj.get_customerbyemail(C_email);
				
				if(c!=null) {
					System.out.println(c);
				}else {
					System.out.println("not available");
				}break;
				
			case 5:
				System.out.println("show all customer");
				
				l=customerObj.get_allcustomer();
				
				for(Customer cl:l) {
					System.out.println(cl);
				}
				break;
				default:
					System.out.println("Invalid choice");

			}
		}
	}
	}
