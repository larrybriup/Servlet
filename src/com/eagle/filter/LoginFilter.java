package com.eagle.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		HttpSession session = request.getSession();
		Object o= session.getAttribute("isLogin");
		if(o==null){
			response.sendRedirect("Message.html");
		}
		if(o!=null){
			String s=(String)o;
			if("yes".equals(s)){
				chain.doFilter(request, response);
			}else{
				response.sendRedirect("Message.html");
			}
		}
		
		
	}

	public void init(FilterConfig conf) throws ServletException {
		
	}

}
