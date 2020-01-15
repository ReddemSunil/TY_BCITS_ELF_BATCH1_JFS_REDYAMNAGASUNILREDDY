package com.bcits.jpawithhibernate.onetoonetest;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapppractise.bean.EmployeeBankInfo;
import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class OneToOneUniTest {
	public static void main(String[] args) {
		EmployeePrimaryInfo primary = new EmployeePrimaryInfo();
		primary.setEmpId(11);
		primary.setBloodGroup("o+");
		primary.setDateOfBirth(java.sql.Date.valueOf("1998-07-13"));
		primary.setDateOfJoining(java.sql.Date.valueOf("2020-02-11"));
		primary.setDeptid(10);
		primary.setDesignation("software developer");
		primary.setManagerId(13);
		primary.setMobileno(9502774436l);
		primary.setName("sunil");
		primary.setOfficialMail("rnsunil@gmail.com");
		primary.setSalary(25000);

		EmployeeBankInfo bank = new EmployeeBankInfo();
		bank.setAccountNo(3301457836l);
		bank.setBankName("sbi");
		bank.setBranchName("kadapa");
		
		bank.setIfscCode("ifsc120");
		bank.setPrimary(primary);

		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(bank);
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
