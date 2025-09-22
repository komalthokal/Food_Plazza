package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dao.CustomerImpl;
import com.model.Customer;
import com.model.Food;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/customer")
public class Customercontroller extends HttpServlet{
	CustomerImpl cd=new CustomerImpl();
	boolean b;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String action=req.getParameter("action");
		if(action==null) {
			List<Customer> list=cd.get_allcustomer();
			if(list!=null && !list.isEmpty()) {
				session.setAttribute("f_list", list);
				resp.sendRedirect("customerlist.jsp");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
		if(action!=null && action.equals("delete")) {
			String c_email=req.getParameter("c_email");
			b=cd.delete_customer_byemail(c_email);
			if(b) {
				resp.sendRedirect("customer");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		String name=req.getParameter("C_name");
		String email=req.getParameter("C_email");
		String password=req.getParameter("C_pass");
		long contact=Long.parseLong(req.getParameter("C_contact"));
		String add=req.getParameter("C_address");
		
		if(action!=null && action.equals("add")) {
			b=cd.add_customer(new Customer(name, email, password, contact ,add));
			if(b) {
				System.out.println("success.jsp");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
		if(action!=null && action.equals("update")) {
			String c_email=req.getParameter("c_email");
			Customer c=new Customer(name, c_email, password, contact, add);
			
			b=cd.update_customer_byiemail(c);
			if(b) {
				resp.sendRedirect("success.jsp");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
	}

}
