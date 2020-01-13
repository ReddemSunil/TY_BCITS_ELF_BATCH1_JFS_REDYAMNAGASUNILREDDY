package com.bcits.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class NoOfCount {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("test");
		EntityManager manager=factory.createEntityManager();
		String jpql="select count(*) from EmployeePrimaryInfo";
		Query query=manager.createQuery(jpql);
		System.out.println(query.getSingleResult());
		
	}
}
