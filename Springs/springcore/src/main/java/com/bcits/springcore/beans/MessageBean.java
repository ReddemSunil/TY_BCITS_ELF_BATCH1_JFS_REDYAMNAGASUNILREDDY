package com.bcits.springcore.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBean implements InitializingBean,DisposableBean{
	private String message;
	public MessageBean() {
		System.out.println("it's instantiation phase!");
	}
	//Getters & setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("initialization phase");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy phase");
	}
	
//	public void init() {
//		System.out.println("it's initialization phase...");
//	}
//	
//	public void destroy() {
//		System.out.println("it's destruction phase!");
//	}
}//End of class
