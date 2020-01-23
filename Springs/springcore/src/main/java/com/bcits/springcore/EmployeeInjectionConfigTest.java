package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeInjectionConfigTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("importAllConfigs.xml");
		EmployeeBean employeeBean=context.getBean("employee", EmployeeBean.class);
		
		System.out.println("name = "+employeeBean.getName());
		System.out.println("age = "+employeeBean.getAge());
		System.out.println("dept id = "+employeeBean.getDepartmentBean().getDeptId());
		System.out.println("dept name = "+employeeBean.getDepartmentBean().getDeptName());
	}// End of main()
}//End of class
