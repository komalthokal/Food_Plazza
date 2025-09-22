package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.db.DbConnect;
import com.model.Cart;
import com.model.Orders;

public class OrderImpl implements OrderDao{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	boolean b;

	@Override
	public boolean update_order(String c_email, float t_price) {
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update orders set t_price=? where c_email=?");
			ps.setFloat(1, t_price);
			ps.setString(2, c_email);
			row=ps.executeUpdate();
			b=(row>0)?true:false;
			System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}return b;
		
	}

	@Override
	public Orders place_order(String c_email) {
		float t_price=0; 
		String date=new Date().toString();
		Orders o=new Orders();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select sum(t_price) as total from cart where c_email=?");
			ps.setString(1, c_email);
			rs=ps.executeQuery();
			if(rs.next()) {
				t_price=rs.getFloat("total");
			}
			if(t_price>0) {
				ps=con.prepareStatement("insert into orders values(o_id,?,?,?)");
				ps.setString(1, c_email);
				ps.setFloat(2, t_price);
				ps.setString(3, date);
				row=ps.executeUpdate();
				if(row>0) {
					ps=con.prepareStatement("select * from orders where c_email=? and date=?");
					ps.setString(1, c_email);
					ps.setString(2, date);
					rs=ps.executeQuery();
					if(rs.next()) {
						o.setO_id(rs.getInt("o_id"));
						o.setC_email(rs.getString("c_email"));
						o.setT_price(rs.getFloat("t_price"));
						o.setDate(rs.getString("date"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public List<Orders> show_order() {
		List<Orders> list=new ArrayList<>();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select * from orders");
			rs=ps.executeQuery();
			while(rs.next()){
				Orders o=new Orders();
				o.setO_id(rs.getInt("o_id"));
				o.setC_email(rs.getString("c_email"));
				o.setT_price(rs.getFloat("t_price"));
				o.setDate(rs.getString("date"));
				list.add(o);
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;
	}
}
