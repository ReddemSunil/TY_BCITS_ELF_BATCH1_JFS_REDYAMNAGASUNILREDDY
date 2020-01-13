package com.bcits.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class ReadEmployee {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		String jpql = "from EmployeePrimaryInfo";
		Query query = manager.createQuery(jpql);
		List<EmployeePrimaryInfo> list = query.getResultList();
		for (EmployeePrimaryInfo employeePrimaryInfo : list) {
			System.out.println("empid-->" + employeePrimaryInfo.getEmpid());
			System.out.println("bloodgroup-->" + employeePrimaryInfo.getBlood_group());
			System.out.println("deptid-->" + employeePrimaryInfo.getDeptid());
			System.out.println("designation-->" + employeePrimaryInfo.getDesignation());
			System.out.println("mangerid-->" + employeePrimaryInfo.getManager_id());
			System.out.println("mobileno-->" + employeePrimaryInfo.getMobileno());
			System.out.println("name-->" + employeePrimaryInfo.getName());
			System.out.println("mail-->" + employeePrimaryInfo.getOfficial_mail());
			System.out.println("salary-->" + employeePrimaryInfo.getSalary());
			System.out.println("date of birth-->" + employeePrimaryInfo.getDate_of_birth());
			System.out.println("date of joining-->" + employeePrimaryInfo.getDate_of_joining());
			System.out.println("-------------------------------------");
		}
	}
}
