package com.dao;

import java.util.List;

import com.model.Customer;

public interface CustomerDao {

	boolean add_customer(Customer cs);
	boolean update_customer_byiemail(Customer cs);
	boolean delete_customer_byemail(String c_email);
	
	Customer get_customerbyemail(String c_email);
	List<Customer>get_allcustomer();
	
	
}
