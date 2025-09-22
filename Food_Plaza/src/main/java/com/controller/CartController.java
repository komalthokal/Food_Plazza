package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.CartImpl;
import com.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartController extends HttpServlet{
	CartImpl c=new CartImpl();
	boolean b;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String action=req.getParameter("action");
		if(action==null) {
			String c_email=(String)session.getAttribute("c_email");
			List<Cart> list=c.show_cart(c_email);
			if(list!=null && !list.isEmpty()) {
				session.setAttribute("c_list", list);
				resp.sendRedirect("cartlist.jsp");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
		if(action!=null && action.equals("delete")) {
			int c_id=Integer.parseInt(req.getParameter("c_id"));
			b=c.delete_cart(c_id);
			if(b) {
				resp.sendRedirect("cart");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		String c_email=req.getParameter("c_email");
		String f_name=req.getParameter("f_name");
		int quan=Integer.parseInt(req.getParameter("f_quan"));
		int f_id=Integer.parseInt(req.getParameter("f_id"));
		float price=Float.parseFloat(req.getParameter("f_price"));
		float tprice=Float.parseFloat(req.getParameter("t_price"));
		
		if(action!=null && action.equals("add")) {
			Cart cart=c.get_cart(f_id);
			if(cart.getF_id()==f_id) {
			quan=cart.getF_quantity()+quan;
			tprice=cart.getT_price()+tprice;
			b=c.update_cart(new Cart(f_id, c_email, f_name, price, quan, tprice));
			if(b) {
				resp.sendRedirect("cart");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}else {
			b=c.add_tocart(new Cart(f_id, c_email, f_name, price, quan, tprice));
			if(b) {
				resp.sendRedirect("cart");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
	}

}
}
