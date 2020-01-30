package com.bcits.springboot.service;

import java.util.List;

import com.bcits.springboot.beans.EmployeeInfoBean;


public interface EmployeeService {
	public EmployeeInfoBean authenticate(int empId, String password);
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();
}//End of Service
