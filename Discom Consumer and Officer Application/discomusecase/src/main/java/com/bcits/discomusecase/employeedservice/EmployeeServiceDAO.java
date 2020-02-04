package com.bcits.discomusecase.employeedservice;

import java.util.List;

import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;

public interface EmployeeServiceDAO {
	public EmployeeInfo authenticate(int empId,String password);
	public List<String> displayHome(String region);
}//End of interface
