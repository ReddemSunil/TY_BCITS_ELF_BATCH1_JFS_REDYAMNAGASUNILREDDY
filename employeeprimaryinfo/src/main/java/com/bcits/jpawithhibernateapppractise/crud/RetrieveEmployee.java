package com.bcits.jpawithhibernateapppractise.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class RetrieveEmployee {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = entityManagerFactory.createEntityManager();

//		EmployeePrimaryInfo info=manager.find(EmployeePrimaryInfo.class, 1000);
		EmployeePrimaryInfo info = manager.getReference(EmployeePrimaryInfo.class, 1000);
		System.out.println("name "+info.getName());
		/*
		 * System.out.println("employeeid-->" + info.getEmpid());
		 * System.out.println("employeeName-->" + info.getName());
		 * System.out.println("employee mobile-->" + info.getMobileno());
		 * System.out.println("employee mail-->" + info.getOfficial_mail());
		 * System.out.println("employee salary-->" + info.getSalary()); 
		 * System.out.println("employee deptid-->" + info.getDeptid());
		 * System.out.println("employee designation-->" + info.getDesignation());
		 * System.out.println("employee managerid-->" + info.getManager_id());
		 * System.out.println("employee blood group-->" + info.getBlood_group());
		 * System.out.println("employee date of birth-->" + info.getDate_of_birth());
		 * System.out.println("employee date of joining-->" +
		 * info.getDate_of_joining());
		 */
		System.out.println("=========================");
		manager.close();
	}
}
