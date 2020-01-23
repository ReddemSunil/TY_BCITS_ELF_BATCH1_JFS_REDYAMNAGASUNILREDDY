package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcoreannotations.beans.Car;

public class CarTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("carConfig.xml");
		Car myCar=context.getBean("car",Car.class);
		System.out.println(myCar.getCompany());
		System.out.println(myCar.getEngine().getCc());
		System.out.println(myCar.getEngine().getType());
	}
}
