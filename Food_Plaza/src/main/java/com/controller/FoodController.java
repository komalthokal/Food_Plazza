package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.FoodImpl;
import com.model.Customer;
import com.model.Food;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/food")
public class FoodController extends HttpServlet{
	
	FoodImpl fd=new FoodImpl();
	boolean b;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String action=req.getParameter("action");
		if(action==null) {
			List<Food> list=fd.get_all_food();
			if(list!=null && !list.isEmpty()) {
				session.setAttribute("f_list", list);
				resp.sendRedirect("foodlist.jsp");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
		if(action!=null && action.equals("delete")) {
			int f_id=Integer.parseInt(req.getParameter("f_id"));
			b=fd.delete_food_byid(f_id);
			if(b) {
				resp.sendRedirect("food");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		String f_name=req.getParameter("f_name");
		String f_type=req.getParameter("f_type");
		String f_category=req.getParameter("f_category");
		float f_price=Float.parseFloat(req.getParameter("f_price"));
		
		if(action!=null && action.equals("addf")) {
			b=fd.add_food(new Food(f_name, f_type, f_category, f_price));
			if(b) {
				resp.sendRedirect("success.jsp");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
		
		if(action!=null && action.equals("update")) {
			int f_id=Integer.parseInt(req.getParameter("f_id"));
			Food f=new Food(f_name, f_type, f_category, f_price);
			f.setF_id(f_id);
			b=fd.update_food_byid(f);
			if(b) {
				resp.sendRedirect("food");
			}else {
				System.out.println(b);
				System.out.println(f);
				resp.sendRedirect("failed.jsp");
				
			}
		}
	}

}
