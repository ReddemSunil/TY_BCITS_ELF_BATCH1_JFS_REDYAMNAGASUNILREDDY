package com.bcits.springcore;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeTest {
		public static void main(String[] args) {
			Scanner scn=new Scanner(System.in);

			ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			EmployeeBean bean=(EmployeeBean)context.getBean("employee");
			EmployeeBean bean2=(EmployeeBean)context.getBean("employee");
			
			System.out.println("enter employee name");
			bean.setName(scn.nextLine());
			System.out.println("enter employee age");
			bean.setAge(scn.nextInt());
			scn.nextLine();
			
			System.out.println("enter employee name");
			bean2.setName(scn.nextLine());
			System.out.println("enter employee age");
			bean2.setAge(scn.nextInt());
			scn.nextLine();
			
			System.out.println("name = "+bean.getName());
			System.out.println("age = "+bean.getAge());
			
			System.out.println("name = "+bean2.getName());
			System.out.println("age = "+bean2.getAge());
		}
}
