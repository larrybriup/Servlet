package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
					IOException {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			for (Cookie cookie : cookies) {
				String key = cookie.getName();
				String value = cookie.getValue();
				out.println("<h3>" + key + ":" + value + "</h3>");
			}
			out.println("</body>");
			out.println("</html>");

			out.flush();
			out.close();
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
					IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);

	}

}
