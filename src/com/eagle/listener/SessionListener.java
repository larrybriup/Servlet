package com.eagle.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent e) {
//		HttpSession session = e.getSession();
		System.out.println("session created...");
	}

	public void sessionDestroyed(HttpSessionEvent e) {
		System.out.println("session distroyed!");
		
	}

}
