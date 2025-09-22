package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.FeedbackImpl;
import com.model.Feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/feedback")
public class FeedbackController extends HttpServlet{
	FeedbackImpl fd=new FeedbackImpl();
	boolean b;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    String action = req.getParameter("action");

	    if (action == null) {
	        // Always fetch the feedback list
	        List<Feedback> list = fd.get_allfeedback();
	        session.setAttribute("fb_list", list); // even if it's empty

	        // Forward instead of redirect so request/session data is preserved immediately
	        req.getRequestDispatcher("feedbacklist.jsp").forward(req, resp);
	        return;
	    }

	    if (action.equals("delete")) {
	        String c_email = req.getParameter("c_email");
	        b = fd.delete_feedback(c_email);
	        // After deleting, reload the list
	        List<Feedback> list = fd.get_allfeedback();
	        session.setAttribute("fb_list", list);

	        req.getRequestDispatcher("feedbacklist.jsp").forward(req, resp);
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		String c_email=req.getParameter("c_email");
		String review=req.getParameter("review");
		String advice=req.getParameter("advice");
		int ranks=Integer.parseInt(req.getParameter("ranks"));
		
		if(action!=null && action.equals("add")) {
			b=fd.add_feedback(new Feedback(c_email, review, advice, ranks));
			if(b) {
				resp.sendRedirect("success.jsp");
			}else {
				resp.sendRedirect("failed.jsp");
			}
		}
	}

}
