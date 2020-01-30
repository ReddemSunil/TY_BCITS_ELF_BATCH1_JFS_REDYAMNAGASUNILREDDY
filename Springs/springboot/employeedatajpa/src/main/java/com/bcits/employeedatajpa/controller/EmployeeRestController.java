package com.bcits.employeedatajpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.employeedatajpa.bean.EmployeeInfoBean;
import com.bcits.employeedatajpa.bean.EmployeeResponse;
import com.bcits.employeedatajpa.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getEmployee(int empId) {
		Optional<EmployeeInfoBean> op = repository.findById(empId);
		EmployeeResponse response = new EmployeeResponse();
		if (op.isPresent()) {
			EmployeeInfoBean employeeInfoBean= op.get();
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("record for employee ID " + empId + " found");
			response.setEmployeeInfoBean(employeeInfoBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("record for employee ID " + empId + "Not found");
		}
		return response;
	}// End of getEmployee()
	
	@GetMapping(path = "/getEmployeeManually", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getEmployee(int empId,String password) {
		EmployeeInfoBean op = repository.findEmployeeManually(empId,password);
		EmployeeResponse response = new EmployeeResponse();
		if (op!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("record for employee ID " + empId + " found");
			response.setEmployeeInfoBean(op);
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("record for employee ID " + empId + "Not found");
		}
		return response;
	}// End of getEmployee()

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}// End of restcontroller
