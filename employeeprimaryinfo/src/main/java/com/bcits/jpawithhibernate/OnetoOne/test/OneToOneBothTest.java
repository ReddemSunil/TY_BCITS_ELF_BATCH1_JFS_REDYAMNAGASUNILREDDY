package com.bcits.jpawithhibernate.OnetoOne.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.OnetoOne.EmployeeSecondaryInfo;
import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class OneToOneBothTest {
	public static void main(String[] args) {
		EmployeePrimaryInfo primaryInfo=new EmployeePrimaryInfo();
		EmployeeSecondaryInfo secondaryInfo=new EmployeeSecondaryInfo();
		
		
		primaryInfo.setEmpid(100);
		primaryInfo.setName("subbu");
		primaryInfo.setMobileno(7989632513l);
		primaryInfo.setOfficial_mail("subbu@gmail.com");
		primaryInfo.setDate_of_birth(java.sql.Date.valueOf("1997-10-01"));
		primaryInfo.setDate_of_joining(java.sql.Date.valueOf("2020-02-11"));
		primaryInfo.setDesignation("software developer");
		primaryInfo.setBlood_group("O+");
		primaryInfo.setSalary(28000);
		primaryInfo.setDeptid(20);
		primaryInfo.setManager_id(202);
		primaryInfo.setSecondaryInfo(secondaryInfo);


		secondaryInfo.setAge(22);
		secondaryInfo.setGender("male");
		secondaryInfo.setGourdianContactNo(9502774436l);
		secondaryInfo.setGovId("adhar");
		secondaryInfo.setIsMarried("not married");
		secondaryInfo.setJobLocation("bangalore");
		secondaryInfo.setNationality("indian");
		secondaryInfo.setPersonalMail("subba1723@gmail.com");
		secondaryInfo.setPrimary(primaryInfo);
		
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(primaryInfo);
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
