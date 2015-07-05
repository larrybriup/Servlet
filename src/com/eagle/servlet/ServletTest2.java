package com.eagle.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletTest2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");//设置返回给浏览器的内容的类型
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println(" <head>");
		out.println(" 	<title>");
		out.println("	</title>");
		out.println("</head>");
		double num= Math.random();
		out.println("	<body>");
		out.println("		<h1> This is ServletTest2!"+num+"</h1>");
		out.println("	</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}

}
