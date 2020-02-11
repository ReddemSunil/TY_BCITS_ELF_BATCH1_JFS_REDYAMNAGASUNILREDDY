package com.bcits.discomusecase.admindao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.bean.AdminInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;

@Repository
public class AdminImpl implements AdminDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public AdminInfo authenticate(int adminId, String password) {
		EntityManager manager = factory.createEntityManager();
		AdminInfo adminInfo = manager.find(AdminInfo.class, adminId);
		if (adminInfo != null && adminInfo.getPassword().equals(password)) {
			return adminInfo;
		}
		return null;
	}// End of authenticate()

	@Override
	public boolean addEmployee(EmployeeInfo employeeInfo) {
		EntityManager manager = factory.createEntityManager();
		if (employeeInfo != null) {
			EntityTransaction transaction = manager.getTransaction();

			try {
				transaction.begin();
				manager.persist(employeeInfo);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();
			return true;
		}
		return false;
	}// End of addEmployee()

}// End of class
