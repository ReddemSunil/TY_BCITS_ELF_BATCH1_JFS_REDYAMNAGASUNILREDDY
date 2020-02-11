package com.bcits.discomusecase.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.admindao.AdminDAO;
import com.bcits.discomusecase.bean.AdminInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;
import com.mysql.fabric.xmlrpc.base.Data;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO dao;

	@Override
	public AdminInfo authenticate(int adminId, String password) {
		return dao.authenticate(adminId, password);
	}// End of authenticate()

	@Override
	public boolean addEmployee(EmployeeInfo employeeInfo) {
		return dao.addEmployee(employeeInfo);
	}// End of addEmployee()

}// End of service
