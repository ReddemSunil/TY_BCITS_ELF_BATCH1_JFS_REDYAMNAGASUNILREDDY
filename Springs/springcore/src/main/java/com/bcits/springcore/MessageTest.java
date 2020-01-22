package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.MessageBean;

public class MessageTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		 ((ConfigurableApplicationContext)applicationContext).registerShutdownHook();
		MessageBean messageBean = (MessageBean) applicationContext.getBean("message");

		System.out.println(messageBean.getMessage());
		
		 MessageBean messageBean2 =(MessageBean) applicationContext.getBean("message");
		 System.out.println(messageBean2.getMessage());

		/*
		 * // close the context container 
		 * 
		 * ((AbstractApplicationContext)applicationContext).close();
		 */

		/*
		 * //exception (we are closing the container) IllegalStateException
		 * 
		 * MessageBean messageBean2 =(MessageBean) applicationContext.getBean("message");
		 * System.out.println(messageBean2.getMessage());
		 */

	}
}
