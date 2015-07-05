package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessyServletTest extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("name=" + name);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 在接受数据之前转换一下字符编码
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("name");
		System.out.println("name=" + name);

		PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println(" <head>");
		out.println(" 	<title>");
		out.println("	</title>");
		out.println("</head>");
		out.println("	<body>");
		out.println("		<h1>name=" + name+"</h1>");
		out.println("	</body>");
		out.println("</html>");

		out.flush();
		out.close();

	}

}
