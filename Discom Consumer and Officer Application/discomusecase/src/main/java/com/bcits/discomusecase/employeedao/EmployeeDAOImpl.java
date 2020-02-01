package com.bcits.discomusecase.employeedao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.bean.EmployeeInfo;

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

}// End of class
