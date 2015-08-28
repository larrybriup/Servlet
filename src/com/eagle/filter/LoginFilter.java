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

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("in LoginFilter"+"\n");
		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		Object o= session.getAttribute("isLogin");
		if(o==null){
			resp.sendRedirect("message.html");
		}
		if(o!=null){
			String s=(String)o;
			if("yes".equals(s)){
				chain.doFilter(req, resp);
			}else{
				resp.sendRedirect("message.html");
			}
		}
		
		
	}

	public void init(FilterConfig conf) throws ServletException {
		
	}

}
