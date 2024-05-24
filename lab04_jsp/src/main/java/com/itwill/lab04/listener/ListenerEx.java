package com.itwill.lab04.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerEx
 *
 */
public class ListenerEx implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public ListenerEx() {
        System.out.println("ListenerEx 생성자 호출");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override 
    public void sessionCreated(HttpSessionEvent se)  { 
         // session이 생성되었을떄 was가 호출하는 메서드
    	System.out.println("세션 생성"+se.getSession());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	// session이 소멸되었을떄 was가 호출하는 메서드
    	System.out.println("세션 소멸"+se.getSession());
    }
    
    /**
     * @see  HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
    	// TODO Auto-generated method stub
    	HttpSessionAttributeListener.super.attributeAdded(se);
    	System.out.println("세션 속성 추가: "+se.getName());
    }
	
}
