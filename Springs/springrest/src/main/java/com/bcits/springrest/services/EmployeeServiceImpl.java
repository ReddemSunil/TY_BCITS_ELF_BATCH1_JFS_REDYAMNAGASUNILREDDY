package com.bcits.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springrest.beans.EmployeeInfoBean;
import com.bcits.springrest.dao.EmployeeDAO;
import com.bcits.springrest.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		return dao.authenticate(empId, password);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.addEmployee(employeeInfoBean);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		if(empId<1) {
			throw new EmployeeException("Invalid EmployeeId");
		}
		return dao.deleteEmployee(empId);
	}
	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.updateEmployee(employeeInfoBean);
	}



	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if(empId<1) {
			throw new EmployeeException("Invalid EmployeeId");
		}
		return dao.getEmployee(empId);
	}

}//End of class
