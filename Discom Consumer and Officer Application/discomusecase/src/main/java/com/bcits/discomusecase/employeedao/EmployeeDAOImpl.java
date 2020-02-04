package com.bcits.discomusecase.employeedao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;
import com.bcits.discomusecase.bean.MonthlyConsumtion;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public EmployeeInfo authenticate(int empId, String password) {
		EntityManager manager = factory.createEntityManager();
		EmployeeInfo employeeInfo = manager.find(EmployeeInfo.class, empId);
		if (employeeInfo != null && employeeInfo.getPassword().equals(password)) {
			return employeeInfo;
		} else {

			return null;
		}
	}// End of authenticate()

	@Override
	public List<String> displayHome(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = " select rrNumber from ConsumerInfo  where region = :region";
		Query query = manager.createQuery(jpql);
		query.setParameter("region", region);
		List<String> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}

	}// End of displayHome()

}// End of class
