package com.bcits.springmvc.interfaces;

import java.util.List;

import com.bcits.springmvc.beans.EmployeeInfoBean;

public interface EmployeeDAO {
	
	public EmployeeInfoBean authenticate(int empId, String password);
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();
}
