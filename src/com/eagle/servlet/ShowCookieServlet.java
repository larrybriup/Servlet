package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Cookie[] c = req.getCookies();
		if(c!=null){
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			for(Cookie cc:c){
				String key=cc.getName();
				String value=cc.getValue();
				out.println("<h3>"+key+":"+value+"</h3>");
			}
			out.println("</body>");
			out.println("</html>");
			
			out.flush();
			out.close();
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);

		
	}

}
