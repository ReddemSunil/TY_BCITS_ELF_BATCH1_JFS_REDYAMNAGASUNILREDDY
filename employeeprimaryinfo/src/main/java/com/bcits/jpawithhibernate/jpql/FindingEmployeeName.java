package com.bcits.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

public class FindingEmployeeName {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select name from EmployeePrimaryInfo";
		Query query = manager.createQuery(jpql);
		List<String> list = query.getResultList();
		for (String employeePrimaryInfo : list) {
			
			System.out.println("employee name "+employeePrimaryInfo);
		}
	}

}
