package com.eagle.servlet2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eagle.service.IUserService;
import com.eagle.service.bean.User;
import com.eagle.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService service= new UserServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受参数
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		int age=Integer.parseInt(req.getParameter("age"));
		
		//封装成javabean对象
		User u= new User();
		u.setName(name);
		u.setPassword(password);
		u.setAge(age);
		
		//调用service层方法进行业务处理
		String page="";
		try {
			service.register(u);
			page="/success.html";
			req.setAttribute("msg", "注册成功!");
			
		} catch (Exception e) {
			e.printStackTrace();
			page="/error.html";
			req.setAttribute("msg", e.getMessage());
		}
		
		//进行跳转
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
