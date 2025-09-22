package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dao.LoginImpl;
import com.model.Admin;
import com.model.Customer;

public class LoginTest {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		LoginImpl adObj=new LoginImpl();
		
		String emailId,password;
		while(true) {
		System.out.println("1.UserLogin\n2.UserchangePassword\n3.AdminLogin\n4.AdminchangePassword");
		System.out.println("Enter the choice:");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("Enter the emailId:");
			emailId=br.readLine();
			System.out.println("Enter the password:");
			password=br.readLine();
			Customer c=new Customer(emailId,password);
			
			boolean b1=adObj.user_login(c);
			
			if(b1) {
				System.out.println("Login successfully.");
			}else {
				System.out.println("Invalid emailid");
			}break;
			
		case 2:
			System.out.println("Enter the existing emailID:");
			emailId=br.readLine();
			System.out.println("Enter the new password:");
			password=br.readLine();
			Customer c1=new Customer(emailId, password);
			boolean b2=adObj.user_changepass(c1);
			if(b2) {
				System.out.println("Change password successfully");
			}else {
				System.out.println("Invalid email id");
			}break;
			
		case 3:
			System.out.println("Enter the email id:");
			emailId=br.readLine();
			System.out.println("Enter the password:");
			password=br.readLine();
			Admin a=new Admin(emailId,password);
			boolean b3=adObj.admin_login(a);
			if(b3) {
				System.out.println("Login successfully.");
			}else {
				System.out.println("Invalid emailid");
			}break;
			
		case 4:
			System.out.println("Enter the existing emailID:");
			emailId=br.readLine();
			System.out.println("Enter the new password:");
			password=br.readLine();
			Admin a1=new Admin(emailId, password);
			boolean b4=adObj.admin_changepass(a1);
			if(b4) {
				System.out.println("Change password successfully");
			}else {
				System.out.println("Invalid email id");
			}break;
		}
	}

}
}
