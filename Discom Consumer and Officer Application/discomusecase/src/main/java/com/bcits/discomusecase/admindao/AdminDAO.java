package com.bcits.discomusecase.admindao;

import com.bcits.discomusecase.bean.AdminInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;

public interface AdminDAO {

	public AdminInfo authenticate(int adminId, String password);

	public boolean addEmployee(EmployeeInfo employeeInfo);
}// End of interface
