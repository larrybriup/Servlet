package com.eagle.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent e) {
		System.out.println("application distroyed!");

	}

	public void contextInitialized(ServletContextEvent e) {
		System.out.println("application created...");

	}

}
