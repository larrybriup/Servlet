package com.eagle.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements  ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent e) {
		
		System.out.println("request is distroyed!");
	}

	public void requestInitialized(ServletRequestEvent e) {
		ServletRequest request = e.getServletRequest();
		System.out.println("request is created...");
	}

}
