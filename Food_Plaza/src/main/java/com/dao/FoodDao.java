package com.dao;

import java.util.List;

import com.model.Food;

public interface FoodDao {

	boolean add_food(Food food);
	boolean update_food_byid(Food food);
	boolean delete_food_byid(int  f_id);
	Food get_food_byid(int f_id);
	List<Food> get_all_food();
}
