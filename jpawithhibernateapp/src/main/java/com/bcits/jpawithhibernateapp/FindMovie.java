package com.bcits.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.Test;

public class FindMovie {
	public static void main(String[] args) {
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			 transaction=manager.getTransaction();
			transaction.begin();
			Test find=manager.find(Test.class, 1);
			System.out.println(find.getMid());
			System.out.println(find.getMovieName());
			System.out.println(find.getMovieRating());
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
	}
}
