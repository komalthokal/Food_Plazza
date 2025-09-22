package com.controller;

import java.io.IOException;

import com.dao.CartImpl;
import com.dao.OrderImpl;
import com.model.Orders;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeorder")
public class OrderController extends HttpServlet{
	
	OrderImpl o=new OrderImpl();
	CartImpl ct=new CartImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("c_email");
		System.out.println("email:"+ email);
		
		float t_price=Float.parseFloat(req.getParameter("price"));
		System.out.println("total:"+t_price);
		
		Orders order=o.place_order(email);
		order.setT_price(t_price);
		if(order!=null) {
			System.out.println("order:"+order);
			order.setT_price(t_price);
			boolean b=ct.clear_cart(email);
			if(b) {
				req.setAttribute("order", order);
				req.getRequestDispatcher("bill.jsp").forward(req, resp);
			}else {
				System.out.println("b");
				resp.sendRedirect("failed.jsp");
			}
		}
		
	}

}
