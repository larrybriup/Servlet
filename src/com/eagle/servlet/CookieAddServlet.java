package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieAddServlet
 */
public class CookieAddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie c1 = new Cookie("name", "Tom");
		Cookie c2 = new Cookie("msg", "Hello!");
		// 设置cookie的期限
		c1.setMaxAge(60);	// one minute
		c2.setMaxAge(60 * 60 * 24 * 365 * 10);
		// 由响应带走
		resp.addCookie(c1);
		resp.addCookie(c2);
		
		resp.setContentType("text/html;Encoding:utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
			out.println("<body>");
				out.println("<h1>");
					out.println("<a href='CookieShowServlet'>CookieShowServlet三炮</a>");
				out.println("</h1>");
			out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
