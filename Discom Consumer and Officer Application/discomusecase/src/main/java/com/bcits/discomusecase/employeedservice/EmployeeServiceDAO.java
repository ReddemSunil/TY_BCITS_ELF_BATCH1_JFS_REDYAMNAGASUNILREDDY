package com.bcits.discomusecase.employeedservice;

import com.bcits.discomusecase.bean.EmployeeInfo;

public interface EmployeeServiceDAO {
	public EmployeeInfo authenticate(int empId,String password);
}//End of interface
