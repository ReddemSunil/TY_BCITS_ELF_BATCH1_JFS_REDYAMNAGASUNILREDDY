package com.bcits.springcoreannotations.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class MessageBean implements InitializingBean,DisposableBean{
	private String message;

	public MessageBean() {
		System.out.println("instantiation phase");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("its destroy phase");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("its initialization phase....");
	}
}
