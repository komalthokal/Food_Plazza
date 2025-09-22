package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnect;
import com.model.Customer;
import com.model.Food;

public class CustomerImpl implements CustomerDao {
	
	private static final Customer Customer = null;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	boolean b;
	private String c_name;
	private String c_pass;
	private String c_contact;
	private String c_address;
	private String c_email;

	@Override
	public boolean add_customer(Customer cs) {
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("insert into customer values(?,?,?,?,?)");
			ps.setString(1, cs.getC_name());
			ps.setString(2, cs.getC_email());
			ps.setString(3, cs.getC_pass());
			ps.setLong(4, cs.getC_contact());
			ps.setString(5, cs.getC_address());
			
			row=ps.executeUpdate();
			b=(row>0)?true:false;
			
		} catch (Exception e) {
             e.printStackTrace();
		}return b;
	}

	@Override
	public boolean update_customer_byiemail(Customer cs) {
		try {
			
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update customer set c_name=?,c_contact=?,c_address=? where c_email= ?");
			ps.setString(1, cs.getC_name());
			ps.setLong(2, cs.getC_contact());
			ps.setString(3, cs.getC_address());
			ps.setString(4, cs.getC_email());
			
			
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}return b;
	}

	@Override
	public boolean  delete_customer_byemail(String c_email) {
		try {
			
			con=DbConnect.get_connect();
			ps=con.prepareStatement("delete from customer where c_email=?");
			ps.setString(1, c_email);
			row=ps.executeUpdate();
			b=(row>0)?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}return b;
	}

	@Override
	public Customer get_customerbyemail(String c_email) {
		Customer c=new Customer();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select * from customer where c_email=?");
			ps.setString(1, c_email);
			rs=ps.executeQuery();
			while(rs.next()) {
				c.setC_name(rs.getString("c_name"));
				c.setC_email(rs.getString("c_email"));
				c.setC_pass(rs.getString("c_pass"));
				c.setC_contact(rs.getLong("c_contact"));
				c.setC_address(rs.getString("c_address"));
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}return c;
	}

	@Override
	public List<Customer> get_allcustomer() {
		List<Customer>list=new ArrayList<Customer>();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select * from customer");
			rs=ps.executeQuery();
			while(rs.next()) {
				Customer c=new Customer();
				c.setC_email(rs.getString("c_email"));
				c.setC_name(rs.getString("c_name"));
				c.setC_pass(rs.getString("c_pass"));
				c.setC_contact(rs.getLong("c_contact"));
				c.setC_address(rs.getString("c_address"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return list;
	}

}