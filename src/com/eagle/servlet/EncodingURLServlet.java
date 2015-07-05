package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EncodingURLServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("msg", "Hello MIMI!");
		
		PrintWriter out = resp.getWriter();
		String url=resp.encodeURL("GetDataServlet");
		out.println("<html>");
			out.println("<body>");
				out.println("<h1>");
				out.println("<a href='"+url+"'>GetDataServlet</a>");
				out.println("</h1>");
			out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();

		
	}

	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}
