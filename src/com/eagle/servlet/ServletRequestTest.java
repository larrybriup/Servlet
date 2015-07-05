package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRequestTest extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//把值保存到request对象中key value
		//						 String Object
		req.setAttribute("msg", "Hello Kitty!");
		String page="ScopeServletTest";
//		RequestDispatcher rd = req.getRequestDispatcher(page);
//		rd.forward(req, resp);
		resp.sendRedirect(page);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
