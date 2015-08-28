package com.eagle.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent e) {
		System.out.println("application distroyed!"+"\n");
	}

	public void contextInitialized(ServletContextEvent e) {
		ServletContext application = e.getServletContext();
		System.out.println("application created...");
	}

}
