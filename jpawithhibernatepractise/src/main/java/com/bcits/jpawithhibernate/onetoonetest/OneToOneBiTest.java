package com.bcits.jpawithhibernate.onetoonetest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapppractise.bean.EmployeeBankInfo;
import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class OneToOneBiTest {
	
	public static void main(String[] args) {
		EmployeePrimaryInfo primary = new EmployeePrimaryInfo();
		EmployeeBankInfo bank = new EmployeeBankInfo();
		primary.setEmpId(12);
		primary.setBloodGroup("o+");
		primary.setDateOfBirth(java.sql.Date.valueOf("1997-08-10"));
		primary.setDateOfJoining(java.sql.Date.valueOf("2020-05-11"));
		primary.setDeptid(20);
		primary.setDesignation("software developer");
		primary.setManagerId(11);
		primary.setMobileno(7989632513l);
		primary.setName("pavan");
		primary.setOfficialMail("pavan@gmail.com");
		primary.setSalary(25000);
		primary.setBank(bank);

		
		bank.setAccountNo(3312457896l);
		bank.setBankName("kotak");
		bank.setBranchName("kadapa");
		
		bank.setIfscCode("ifsc110");
		bank.setPrimary(primary);

		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(primary);
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
