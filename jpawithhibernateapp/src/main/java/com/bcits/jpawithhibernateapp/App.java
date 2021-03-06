package com.bcits.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.Test;

public class App {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		EntityManager manager = null;

		Test test = new Test();
		test.setMid(7);
		test.setMovieName("spiderman");
		test.setMovieRating("good");

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(test);
			System.out.println("record saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {

			manager.close();
		}
	}//end of main
}//end of class
