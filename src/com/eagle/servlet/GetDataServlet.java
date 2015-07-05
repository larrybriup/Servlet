package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetDataServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String msg=(String) session.getAttribute("msg");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
			out.println("<body>");
			out.println("<h3>msg="+msg+"</h3>");
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
