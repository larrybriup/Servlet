package com.eagle.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServletTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("name");
		System.out.println("in dispatcherServletTest name="+name);
		String page="";
//		if("大超".equals(name)) {
//			page="/success.html";
//		}else {
//			page="/error.html";
//		}
		page="/OtherServletTest";
		//获得一个跳转对象,服务器内部跳转
		RequestDispatcher rd = req.getRequestDispatcher(page);
		//跳转
		rd.forward(req, res);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
//		res.setCharacterEncoding("UTF-8");
		doGet(req, res);
	}
	
}
