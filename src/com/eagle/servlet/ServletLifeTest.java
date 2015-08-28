package com.eagle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeTest extends HttpServlet {

	public ServletLifeTest() {
		System.out.println("in LifeServletTest() constructor");
	}

	public void init() throws ServletException {
		System.out.println("in LifeServletTest init()");
	}

	public void destroy() {
		System.out.println("in LifeServletTest destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
					IOException {
		System.out.println("in LifeServletTest doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
					IOException {
		System.out.println("in LifeServletTest doPost");
	}

}
