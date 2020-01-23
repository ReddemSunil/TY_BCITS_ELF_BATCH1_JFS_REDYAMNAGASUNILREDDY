package com.bcits.springcoreannotations;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.EmployeeBean;
import com.bcits.springcoreannotations.config.EmployeeConfig;

public class EmployeeTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		
		((ConfigurableApplicationContext)context).registerShutdownHook();
		
		EmployeeBean employeeBean1 = context.getBean(EmployeeBean.class);
		System.out.println("ente employee name");
		employeeBean1.setName(sc.nextLine());
		System.out.println("enter employee age");
		employeeBean1.setAge(sc.nextInt());
		sc.nextLine();

		EmployeeBean employeeBean2 = context.getBean(EmployeeBean.class);
		System.out.println("ente employee name");
		employeeBean2.setName(sc.nextLine());
		System.out.println("enter employee age");
		employeeBean2.setAge(sc.nextInt());

		System.out.println("employee-1 name = " + employeeBean1.getName());
		System.out.println("employrr-1 age = " + employeeBean1.getAge());
		System.out.println("employee-2 name = " + employeeBean2.getName());
		System.out.println("employrr-2 age = " + employeeBean2.getAge());
	}// End of main()
}// End of class
