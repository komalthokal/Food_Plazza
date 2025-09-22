package com.test;

import java.sql.Connection;

import com.db.DbConnect;

public class Test {

	public static void main(String[] args) {
		Connection con=DbConnect.get_connect();
		if(con!=null) {
			System.out.println("database connection sucessfully");
		}else {
			System.out.println("fail to connect");
		}
	}
}
