package com.bcits.discomusecase.adminservice;

import com.bcits.discomusecase.bean.AdminInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;

public interface AdminService {

	public AdminInfo authenticate(int adminId, String password);

	public boolean addEmployee(EmployeeInfo employeeInfo);
}// End of interface
