package com.bcits.jpawithhibernateapppractise.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class FindEmployee {
	public static void main(String[] args) {
		
		
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("test");
		EntityManager manager= entityManagerFactory.createEntityManager();
		EmployeePrimaryInfo emInfo= manager.find(EmployeePrimaryInfo.class, 100);
		System.out.println("empid--"+emInfo.getEmpid());
		System.out.println("name--"+emInfo.getName());
		System.out.println("mobileno--"+emInfo.getMobileno());
		System.out.println("mail--"+emInfo.getOfficial_mail());
		System.out.println("salary--"+emInfo.getSalary());
		System.out.println("designation--"+emInfo.getDesignation());
		System.out.println("blood group--"+emInfo.getBlood_group());
		System.out.println("date of birth--"+emInfo.getDate_of_birth());
		System.out.println("date of joining--"+emInfo.getDate_of_joining());
		System.out.println("deptid--"+emInfo.getDeptid());
		System.out.println("managerid--"+emInfo.getManager_id());
	}// end of main

}// end of class
