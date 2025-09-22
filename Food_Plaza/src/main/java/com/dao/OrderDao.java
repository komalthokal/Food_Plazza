package com.dao;

import java.util.List;

import com.model.Orders;

public interface OrderDao {

	boolean update_order(String c_email,float t_price);
	Orders place_order(String c_email);
	List<Orders>show_order();
}
