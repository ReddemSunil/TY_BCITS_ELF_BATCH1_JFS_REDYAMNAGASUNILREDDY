package com.bcits.jpawithhibernateapppractise.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeePrimaryInfo test=new EmployeePrimaryInfo();
        test.setEmpid(1);
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
        
        

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(test);
		System.out.println("record saved");
		transaction.commit();
		manager.close();
        
    }
}
