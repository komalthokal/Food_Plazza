package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnect;
import com.model.Food;

public class FoodImpl implements FoodDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	boolean b;

	@Override
	public boolean add_food(Food food) {
		
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("insert into food values(f_id,?,?,?,?)");
			ps.setString(1, food.getF_name());
			ps.setString(2, food.getF_type());
			ps.setString(3, food.getF_category());
			ps.setFloat(4, food.getF_price());
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	@Override
	public boolean update_food_byid(Food food) {
		try {
			
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update food set f_name=?,f_type=?,f_category=?,f_price=? where f_id=?");
			ps.setString(1, food.getF_name());
			ps.setString(2, food.getF_type());
			ps.setString(3, food.getF_category());
			ps.setFloat(4,food.getF_price());
			ps.setInt(5, food.getF_id());
			
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (Exception e) {
		e.printStackTrace();
		}return b;
	}

	@Override
	public boolean delete_food_byid(int f_id) {
		try {
			
			con=DbConnect.get_connect();
			ps=con.prepareStatement("delete from food where f_id=?");
			ps.setInt(1, f_id);
			row=ps.executeUpdate();
			b=(row>0)?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}return b;
	}

	@Override
	public Food get_food_byid(int f_id) {
		Food f=new Food();
		try {
			
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select * from food where f_id=?");
			ps.setInt(1, f_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				f.setF_id(rs.getInt("f_id"));
				f.setF_name(rs.getString("f_name"));
				f.setF_type(rs.getString("f_type"));
				f.setF_category(rs.getString("f_category"));
				f.setF_price(rs.getFloat("f_price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return f;
	}

	@Override
	public List<Food> get_all_food() {
		List<Food>list=new ArrayList<>();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select * from food");
			rs=ps.executeQuery();
			while(rs.next()) {
				Food f=new Food();
				f.setF_id(rs.getInt("f_id"));
				f.setF_name(rs.getString("f_name"));
				f.setF_type(rs.getString("f_type"));
				f.setF_category(rs.getString("f_category"));
				f.setF_price(rs.getFloat("f_price"));
				list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return list;
	}
	

}
