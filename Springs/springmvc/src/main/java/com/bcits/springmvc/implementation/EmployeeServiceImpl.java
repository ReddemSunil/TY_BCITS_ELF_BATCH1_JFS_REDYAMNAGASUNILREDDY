package com.bcits.springmvc.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.interfaces.EmployeeDAO;
import com.bcits.springmvc.service.EmployeeService;

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
		return false;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		if(empId<1) {
			
			return false;
		}
		return dao.deleteEmployee(empId);
	}
	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		return false;
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return null;
	}

}
