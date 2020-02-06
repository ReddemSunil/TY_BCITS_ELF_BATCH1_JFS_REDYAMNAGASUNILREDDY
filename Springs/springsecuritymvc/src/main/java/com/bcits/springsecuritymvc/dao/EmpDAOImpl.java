package com.bcits.springsecuritymvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;

@Repository
public class EmpDAOImpl implements EmpDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean register(EmpInfoBean empInfoBean) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isRegistered = false;
		try {
			transaction.begin();
			manager.persist(empInfoBean);
			transaction.commit();
			isRegistered = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return isRegistered;
	}// End of register()

	@Override
	public EmpInfoBean getEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();
		EmpInfoBean empInfoBean = manager.find(EmpInfoBean.class, empId);
		manager.close();
		return empInfoBean;
	}// End of getEmployee()

	@Override
	public List<EmpInfoBean> getAllEmployees() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery( "from EmpInfoBean");
		List<EmpInfoBean> emList = query.getResultList();
		manager.close();
		return emList;
	}// End of getAllEmployee()

}// End of repositary
