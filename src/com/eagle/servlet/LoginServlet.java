package com.eagle.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=(String)req.getParameter("name");
		String password=(String)req.getParameter("password");
		String page="";
		if("choda".equals(name)&&"123".equals(password)){
			HttpSession session = req.getSession();
			session.setAttribute("isLogin", "yes");
			page="success.html";
		}else{
			page="error.html";
		}
		RequestDispatcher rd = req.getRequestDispatcher(page);
		//跳转
		rd.forward(req, resp);
//		resp.sendRedirect(page);
	
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
