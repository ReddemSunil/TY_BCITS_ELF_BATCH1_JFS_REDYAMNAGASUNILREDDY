package com.bcits.discomusecase.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Data;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.ManifestReading.SealBaseLocator;

@Data
public class Mail {
	
	private String from;
	private String to;
	private String subject;
	private Object message;

//	public static void main(String[] args) {
//		ApplicationContext context = 
//	             new ClassPathXmlApplicationContext("discom-bean.xml");
//	    	 
//	    	MailMail mm = (MailMail) context.getBean("mailMail");
//	        mm.sendMail("rnsunil.software@gmail.com",
//	    		   "rnsunil1432@gmail.com",
//	    		   "mailtest", 
//	    		   "Hi this sunil i am checking mail testing");
//	        System.out.println("main method");
//	    }
}
