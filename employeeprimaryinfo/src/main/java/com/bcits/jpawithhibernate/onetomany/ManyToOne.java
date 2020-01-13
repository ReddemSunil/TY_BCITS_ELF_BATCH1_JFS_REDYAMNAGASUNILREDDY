package com.bcits.jpawithhibernate.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class ManyToOne {
	public static void main(String[] args) {
		EmployeePrimaryInfo primaryInfo = new EmployeePrimaryInfo();

		primaryInfo.setEmpid(101);
		primaryInfo.setName("ravi");
		primaryInfo.setMobileno(8945631241l);
		primaryInfo.setOfficial_mail("ravi@gmail.com");
		primaryInfo.setDate_of_birth(java.sql.Date.valueOf("2000-02-12"));
		primaryInfo.setDate_of_joining(java.sql.Date.valueOf("2020-02-11"));
		primaryInfo.setDesignation("software developer");
		primaryInfo.setBlood_group("O+");
		primaryInfo.setSalary(25000);
		primaryInfo.setDeptid(10);
		primaryInfo.setManager_id(201);

		EmployeeAddressPK addressPk=new EmployeeAddressPK();
		addressPk.setAddressType("permenant");
		addressPk.setEmpid(101);
		
		EmployeeAddressInfo addressInfo=new EmployeeAddressInfo();
		addressInfo.setAddressPK(addressPk);
		addressInfo.setHouseNo("#457");
		addressInfo.setAddress1("ashwata nagar");
		addressInfo.setAddress2("5 th cross");
		addressInfo.setLandMark("marathalli");
		addressInfo.setPinCode(560037);
		addressInfo.setPrimaryInfo(primaryInfo);
		
		
		
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo pr=manager.find(EmployeePrimaryInfo.class, 101);
			/*
			 * addressInfo.setPrimaryInfo(pr); manager.persist(addressInfo);
			 */
			System.out.println(pr.getAddress().get(0).getAddress1());
			System.out.println(pr.getAddress().get(0).getAddress2());
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
