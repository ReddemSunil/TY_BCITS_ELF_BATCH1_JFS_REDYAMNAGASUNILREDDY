package com.bcits.jpawithhibernate.manytomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.OnetoOne.EmployeeSecondaryInfo;
import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class ManyToManyTest {
	public static void main(String[] args) {
		EmployeePrimaryInfo primary = new EmployeePrimaryInfo();
		EmployeePrimaryInfo primary1 = new EmployeePrimaryInfo();
		ArrayList<ProjectInfo> alProjectInfo = new ArrayList<ProjectInfo>();
		ArrayList<EmployeePrimaryInfo> alEmployeePrimaryInfo = new ArrayList<EmployeePrimaryInfo>();

		ProjectInfo projectInfo = new ProjectInfo();
		ProjectInfo projectInfo1 = new ProjectInfo();

		primary.setEmpid(130);
		primary.setName("nagendra");
		primary.setMobileno(6300277396l);
		primary.setOfficial_mail("naglakki@gmail.com");
		primary.setDate_of_birth(java.sql.Date.valueOf("1997-02-12"));
		primary.setDate_of_joining(java.sql.Date.valueOf("2020-02-11"));
		primary.setDesignation("software developer");
		primary.setBlood_group("O+");
		primary.setSalary(25000);
		primary.setDeptid(10);
		primary.setManager_id(202);
		primary.setProList(alProjectInfo);

		primary1.setEmpid(131);
		primary1.setName("suresh");
		primary1.setMobileno(9381955817l);
		primary1.setOfficial_mail("suresh@gmail.com");
		primary1.setDate_of_birth(java.sql.Date.valueOf("1997-02-12"));
		primary1.setDate_of_joining(java.sql.Date.valueOf("2020-02-11"));
		primary1.setDesignation("software developer");
		primary1.setBlood_group("O+");
		primary1.setSalary(25000);
		primary1.setDeptid(10);
		primary1.setManager_id(201);
		primary.setProList(alProjectInfo);

		alEmployeePrimaryInfo.add(primary);
		alEmployeePrimaryInfo.add(primary1);

		projectInfo.setPid(15);
		projectInfo.setProjectName("e-commerce");
		projectInfo.setLocation("bangalore");
		projectInfo.setStartDate(java.sql.Date.valueOf("2019-12-08"));
		projectInfo.setEndDate(java.sql.Date.valueOf("2020-12-18"));
		projectInfo.setTechnology("java");
		projectInfo.setPrimaryInfo(alEmployeePrimaryInfo);

		projectInfo1.setPid(16);
		projectInfo1.setProjectName("jhp");
		projectInfo1.setLocation("bangalore");
		projectInfo1.setStartDate(java.sql.Date.valueOf("2019-12-08"));
		projectInfo1.setEndDate(java.sql.Date.valueOf("2020-12-18"));
		projectInfo1.setTechnology("python");
		projectInfo1.setPrimaryInfo(alEmployeePrimaryInfo);

		alProjectInfo.add(projectInfo);
		alProjectInfo.add(projectInfo1);

		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
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
