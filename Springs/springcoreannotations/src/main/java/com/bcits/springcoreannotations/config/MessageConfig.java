package com.bcits.springcoreannotations.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.MessageBean;
import com.bcits.springcoreannotations.mybeanpostprocessors.MyBeanFactoryPostProcessor;
import com.bcits.springcoreannotations.mybeanpostprocessors.MyBeanPostProcessor;

@Configuration
public class MessageConfig{
	
	@Bean(name="messageBean")
	public MessageBean getMessageBean() {
		MessageBean messageBean=new MessageBean();
		messageBean.setMessage("welcome back to spring core");
		return messageBean;
	}// End of getMessageBean()
	@Bean
	public MyBeanPostProcessor getMyBPP() {
		return new MyBeanPostProcessor();
	}
	
	
	@Bean
	public MyBeanFactoryPostProcessor getMyBFPP() {
		return new MyBeanFactoryPostProcessor();
	}
	}// End of class
