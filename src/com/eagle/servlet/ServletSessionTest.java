package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletSessionTest extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("msg", "Hello Session!");
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
