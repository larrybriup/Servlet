package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RedirectServletTest extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		System.out.println("in RedirectServletTest name="+name+"\n");
		String page="";
		if("larry".equals(name)) {
			HttpSession session = req.getSession();
			session.setAttribute("isLogin", "yes");
			page="success.html";
		}else {
			page="error.html";
		}
//		page="DispatcherServletTest";
		resp.sendRedirect(page);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
		
	}

}
