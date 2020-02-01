package com.bcits.discomusecase.employeedao;

import com.bcits.discomusecase.bean.EmployeeInfo;

public interface EmployeeDAO {
	public EmployeeInfo authenticate(int empId,String password);
}//End of interface
