package com.bcits.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.Test;

public class DeleteMovie {
	public static void main(String[] args) {
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			 transaction=manager.getTransaction();
			transaction.begin();
			Test info=manager.find(Test.class, 5);
			manager.remove(info);
			transaction.commit();
			System.out.println("record deleted");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		manager.close();
	}

}
