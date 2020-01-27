package com.bcits.springmvc.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.interfaces.EmployeeDAO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

//	@PersistenceContext
//	private EntityManager manager;

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		EntityManager manager = factory.createEntityManager();

		if (employeeInfoBean != null) {

			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.persist(employeeInfoBean);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();

			return true;
		}
		return false;
	}// End of addEmployee()

	@Override
	public boolean deleteEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();

		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		if (employeeInfoBean != null) {

			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.remove(employeeInfoBean);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();
			return true;
		}
		return false;
	}// End of deleteEmployee()

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();

		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		if (employeeInfoBean != null) {

			manager.close();
			return employeeInfoBean;
		}
		return null;
	}// End of getEmployee()

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager manager = factory.createEntityManager();

		String jpql = "from EmployeeInfoBean";
		Query query = manager.createQuery(jpql);
		List<EmployeeInfoBean> list = query.getResultList();
		manager.close();
		return list;
	}// End of getAllEmployees()

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		if (employeeInfoBean != null) {
			EntityManager manager = factory.createEntityManager();

			EntityTransaction transaction = manager.getTransaction();
			EmployeeInfoBean employeeInfoBean1 = manager.find(EmployeeInfoBean.class, employeeInfoBean.getEmpId());
			transaction.begin();
			if (!employeeInfoBean.getName().equals(employeeInfoBean1.getName()) && employeeInfoBean.getName() != null) {
				employeeInfoBean1.setName(employeeInfoBean.getName());
			}
			if (employeeInfoBean.getMobileno() != null
					&& !employeeInfoBean.getMobileno().equals(employeeInfoBean1.getMobileno())) {
				employeeInfoBean1.setMobileno(employeeInfoBean.getMobileno());
			}
			if (employeeInfoBean.getOfficialMail() != null
					&& !employeeInfoBean.getOfficialMail().equals(employeeInfoBean1.getOfficialMail())) {
				employeeInfoBean1.setOfficialMail(employeeInfoBean.getOfficialMail());
			}
			if (employeeInfoBean.getDateOfBirth() != null
					&& !employeeInfoBean.getDateOfBirth().equals(employeeInfoBean1.getDateOfBirth())) {
				employeeInfoBean1.setDateOfBirth(employeeInfoBean.getDateOfBirth());
			}
			if (employeeInfoBean.getDateOfJoining() != null
					&& !employeeInfoBean.getDateOfJoining().equals(employeeInfoBean1.getDateOfJoining())) {
				employeeInfoBean1.setDateOfJoining(employeeInfoBean.getDateOfJoining());
			}
			if (employeeInfoBean.getDesignation() != null
					&& !employeeInfoBean.getDesignation().equals(employeeInfoBean1.getDesignation())) {
				employeeInfoBean1.setDesignation(employeeInfoBean.getDesignation());
			}
			if (employeeInfoBean.getSalary() != null
					&& !employeeInfoBean.getSalary().equals(employeeInfoBean1.getSalary())) {
				employeeInfoBean1.setSalary(employeeInfoBean.getSalary());
			}
			if (employeeInfoBean.getDeptid() != null
					&& !employeeInfoBean.getDeptid().equals(employeeInfoBean1.getDeptid())) {
				employeeInfoBean1.setDeptid(employeeInfoBean.getDeptid());
			}
			if (employeeInfoBean.getManagerId() != null
					&& !employeeInfoBean.getManagerId().equals(employeeInfoBean1.getManagerId())) {
				employeeInfoBean1.setManagerId(employeeInfoBean.getManagerId());
			}
			if (employeeInfoBean.getPassword() != null
					&& !employeeInfoBean.getPassword().equals(employeeInfoBean1.getPassword())) {
				employeeInfoBean1.setPassword(employeeInfoBean.getPassword());
			}

			transaction.commit();
			return true;
		}
		return false;
	}// End of updateEmployee()

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		EntityManager manager = factory.createEntityManager();

		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		if (employeeInfoBean != null && employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;
		} else {

			return null;
		}
	}// End of authenticate()

}// End of class
