package com.bcits.discomusecase.employeedao;

import java.util.List;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;

public interface EmployeeDAO {
	public EmployeeInfo authenticate(int empId,String password);
	public List<String> displayHome(String region);
}//End of interface
