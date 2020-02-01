package com.bcits.discomusecase.employeedservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.bean.EmployeeInfo;
import com.bcits.discomusecase.consumerException.ConsumerException;
import com.bcits.discomusecase.employeedao.EmployeeDAO;

@Service
public class EmployeeServiceDAOImpl implements EmployeeServiceDAO {
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfo authenticate(int empId, String password) {
		if (empId < 1) {
			throw new ConsumerException("Employee Id Not Contains Negative Values");
		}
		return dao.authenticate(empId, password);
	}// End of authenticate()

}// End of class
