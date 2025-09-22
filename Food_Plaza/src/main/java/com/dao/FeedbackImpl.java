package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnect;
import com.model.Feedback;

public class FeedbackImpl implements FeedbackDao{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	boolean b;
	

	@Override
	public boolean add_feedback(Feedback fd) {
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("insert into feedback values(?,?,?,?)");
			ps.setString(1, fd.getC_email());
			ps.setString(2, fd.getReview());
			ps.setString(3, fd.getAdvice());
			ps.setInt(4, fd.getRanks());
			row=ps.executeUpdate();
			b=(row>0)?true:false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean delete_feedback(String c_email) {
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("delete from feedback where c_email=?");
			ps.setString(1, c_email);
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Feedback> get_allfeedback() {
		List<Feedback> list=new ArrayList<>();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select * from feedback");
			rs=ps.executeQuery();
			while(rs.next()) {
				Feedback f=new Feedback();
				f.setC_email(rs.getString("c_email"));
				f.setReview(rs.getString("review"));
				f.setAdvice(rs.getString("advice"));
				f.setRanks(rs.getInt("ranks"));
				list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
