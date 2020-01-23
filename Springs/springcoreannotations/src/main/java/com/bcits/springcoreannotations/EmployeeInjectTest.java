package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.EmployeeBean;
import com.bcits.springcoreannotations.config.EmployeeConfig;
import com.bcits.springcoreannotations.config.EmployeeInjectConfig;

public class EmployeeInjectTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeInjectConfig.class);
		EmployeeBean employeeBean = context.getBean(EmployeeBean.class);

		System.out.println("emp name = " + employeeBean.getName());
		System.out.println("emp age = " + employeeBean.getAge());
		System.out.println("dept name = " + employeeBean.getDepartmentBean().getDeptName());
		System.out.println("dept id = " + employeeBean.getDepartmentBean().getDeptId());
	}
}
