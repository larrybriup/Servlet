package com.eagle.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements  Filter{

	public void destroy() {
		System.out.println("destroy");
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("in doFilter");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//过滤器放行
		chain.doFilter(req, resp);
		
	}

	public void init(FilterConfig conf) throws ServletException {
		System.out.println("in EncodingFilter");
		
	}

}
