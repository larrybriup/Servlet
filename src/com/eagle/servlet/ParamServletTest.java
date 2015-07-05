package com.eagle.servlet;


import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServletTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("in paramTest doGet()...");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String id=req.getParameter("id");
		System.out.println("name="+name);
		System.out.println("age="+age);
		System.out.println("id="+id);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("in paramTest doPost()...");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String[] hoppy=req.getParameterValues("hoppy");
		String city=req.getParameter("city");
		String dis=req.getParameter("dis");
		
		System.out.println("id="+id+"\nname="+name+
				"\npassword="+password+"\ngender="+gender);
		if(hoppy!=null) {
			for(String s:hoppy) {
				System.out.println("hoppy="+s);
			}
		}
		System.out.println("city="+city);
		System.out.println("discription="+dis);
		
	}
}
