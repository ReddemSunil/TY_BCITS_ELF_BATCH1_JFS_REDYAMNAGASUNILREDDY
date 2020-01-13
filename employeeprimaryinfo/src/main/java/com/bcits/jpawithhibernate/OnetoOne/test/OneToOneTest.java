package com.bcits.jpawithhibernate.OnetoOne.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.OnetoOne.EmployeeSecondaryInfo;
import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class OneToOneTest {
	public static void main(String[] args) {
		EmployeePrimaryInfo test = new EmployeePrimaryInfo();
		EmployeeSecondaryInfo second = new EmployeeSecondaryInfo();
		
		
		test.setEmpid(244);
		test.setName("pavan");
		test.setMobileno(950277443);
		test.setOfficial_mail("pavan@gmail.com");
		test.setDate_of_birth(java.sql.Date.valueOf("1996-02-12"));
		test.setDate_of_joining(java.sql.Date.valueOf("2020-02-11"));
		test.setDesignation("software developer");
		test.setBlood_group("O+");
		test.setSalary(25000);
		test.setDeptid(10);
		test.setManager_id(201);


		second.setAge(20);
		second.setGender("male");
		second.setGourdianContactNo(9502774436l);
		second.setGovId("adhar");
		second.setIsMarried("not married");
		second.setJobLocation("bangalore");
		second.setNationality("indian");
		second.setPersonalMail("rnsunil@gmail.com");
		second.setPrimary(test);
		
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(second);
			System.out.println("record saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {

			manager.close();
		}
	}
}
