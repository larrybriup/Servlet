package com.eagle.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrintNumServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//request session application
//		HttpSession session = req.getSession();
//		Object obj = session.getAttribute("num");
//		int num=1;
//		if(obj==null) {
//			session.setAttribute("num", num);
//		}else {
//			num=(Integer)obj;
//			num++;
//			session.setAttribute("num", num);
//			
//		}
		ServletContext application = req.getSession().getServletContext();
//		application.removeAttribute("num");
		
		Object obj = application.getAttribute("num");
		int num=1;
		if(obj==null) {
			application.setAttribute("num", num);
		}else {
			num=(Integer)obj;
			num++;
			application.setAttribute("num", num);
		}
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>num="+num+"</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
