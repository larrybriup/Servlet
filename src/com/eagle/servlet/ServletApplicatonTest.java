package com.eagle.servlet;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletApplicatonTest extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	ServletContext applicattion = req.getSession().getServletContext();
	
	applicattion.setAttribute("msg", "Hello Applcation!");
	
	String page="ScopeServletTest";
	resp.sendRedirect(page);
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	doGet(req, resp);
	}
}
