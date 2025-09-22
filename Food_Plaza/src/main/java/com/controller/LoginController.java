package com.controller;

import java.io.IOException;



import com.dao.LoginImpl;
import com.model.Admin;
import com.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	LoginImpl l=new LoginImpl();
	boolean b;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.invalidate();
		resp.sendRedirect("index.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String action=req.getParameter("action");
		String type=req.getParameter("type");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		if(type!=null && type.equals("admin")) {
			session.setAttribute("type", type);
			if(action!=null && action.equals("login")) {
				b=l.admin_login(new Admin(email, pass));
				if(b) {
					session.setAttribute("a_email",email);
					resp.sendRedirect("index.jsp");
				}else {
					resp.sendRedirect("failed.jsp");
				}
			}
			
			if(action!=null && action.equals("change")) {
				String c_pass=req.getParameter("c_pass");
				b=l.admin_changepass(new Admin(email, c_pass));
				if(b) {
					resp.sendRedirect("success.jsp");
				}else {
					resp.sendRedirect("failed.jsp");
				}
			}
		}
		
		if(type!=null && type.equals("user")) {
			session.setAttribute("type", type);
			if(action!=null && action.equals("login")) {
				b=l.user_login(new Customer(email, pass));
				if(b) {
					session.setAttribute("c_email",email);
					resp.sendRedirect("index.jsp");
				}else {
					resp.sendRedirect("failed.jsp");
				}
			}
			
			if(action!=null && action.equals("change")) {
				String c_pass=req.getParameter("c_pass");
				b=l.user_changepass(new Customer(email, c_pass));
				if(b) {
					resp.sendRedirect("success.jsp");
				}else {
					resp.sendRedirect("failed.jsp");
				}
			}
		}
	}

}
