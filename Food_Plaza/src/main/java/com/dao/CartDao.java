package com.dao;

import java.util.List;

import com.model.Cart;

public interface CartDao {

	boolean add_tocart(Cart c);
	Cart get_cart(int f_id);
	boolean delete_cart(int c_id);
	boolean update_cart(Cart c);
	boolean clear_cart(String c_email);
	List<Cart> show_cart(String c_email);
	
	
}
