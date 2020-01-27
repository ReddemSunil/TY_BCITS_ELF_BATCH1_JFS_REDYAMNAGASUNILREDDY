package com.bcits.springmvc.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.customexception.EmployeeException;
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
		return dao.addEmployee(employeeInfoBean);
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
		return dao.updateEmployee(employeeInfoBean);
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if(empId <1) {
			throw new EmployeeException("Invalid Employee Id");
		}
		EmployeeInfoBean employeeInfoBean=dao.getEmployee(empId);
		if(employeeInfoBean==null) {
			throw new EmployeeException("Employee ID Not Found");
		}
		return employeeInfoBean;
	}//End of getEmployee()

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
