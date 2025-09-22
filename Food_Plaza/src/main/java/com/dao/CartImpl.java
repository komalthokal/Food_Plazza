package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnect;
import com.model.Cart;

public class CartImpl implements CartDao{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	boolean b;
	private int c_id;
	private int f_id;
	private String c_email;
	private String f_name;
	private int f_price;
	private int f_quantity;
	private int t_price;

	@Override
	public boolean add_tocart(Cart c) {
try {
	
	con=DbConnect.get_connect();
	ps=con.prepareStatement("insert into cart values(c_id,?,?,?,?,?,?)");
	ps.setInt(1, c.getF_id());
	ps.setString(2, c.getC_email());
	ps.setString(3, c.getF_name());
	ps.setFloat(4, c.getF_price());
	ps.setInt(5, c.getF_quantity());
	ps.setFloat(6, c.getT_price());
	
	row=ps.executeUpdate();
	b=(row>0)?true:false;
} catch (Exception e) {
	e.printStackTrace();
}
		return b;
	}

	@Override
	public Cart get_cart(int f_id) {
		Cart c=new Cart();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select * from cart where f_id=?");
			ps.setInt(1, f_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				c.setC_id(rs.getInt(c_id));
				c.setC_email(rs.getString(c_email));
				c.setF_id(rs.getInt(f_id));
				c.setF_name(rs.getString(f_name));
				c.setF_quantity(rs.getInt(f_quantity));
				c.setF_price(rs.getFloat(f_price));
				c.setT_price(rs.getFloat(t_price));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
		
	}

	@Override
	public boolean delete_cart(int c_id) {
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("delete from cart where c_id=?");
			ps.setInt(1, c_id);
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}return b;
	}

	@Override
	public boolean update_cart(Cart c) {
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update cart set f_quantity=?,t_price=? where f_id=?");
			ps.setInt(1, c.getF_quantity());
			ps.setFloat(2, c.getT_price());
			ps.setInt(3, c.getF_id());
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}return b;
	}

	@Override
	public boolean clear_cart(String c_email) {
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("delete from cart where c_email=?");
			ps.setString(1, c_email);
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}return b;
	}

	@Override
	public List<Cart> show_cart(String c_email) {
		List<Cart> list=new ArrayList<>();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select * from cart where c_email=?");
			ps.setString(1, c_email);
			rs=ps.executeQuery();
			while(rs.next()){
				Cart c=new Cart();
				
                c.setC_id(rs.getInt("c_id"));
				c.setF_id(rs.getInt("f_id"));
				c.setC_email(rs.getString("c_email"));
				c.setF_name(rs.getString("f_name"));
				c.setF_price(rs.getFloat("f_price"));
				c.setF_quantity(rs.getInt("f_quantity"));
				c.setT_price(rs.getFloat("t_price"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return list;
	}

}
