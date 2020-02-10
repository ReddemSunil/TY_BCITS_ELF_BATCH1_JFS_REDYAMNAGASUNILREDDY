package com.bcits.springsecurityrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springsecurityrest.beans.EmpInfoBean;
import com.bcits.springsecurityrest.beans.EmployeeResponse;
import com.bcits.springsecurityrest.service.EmpService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmpService service;

	@GetMapping("/getEmployee")
	public EmployeeResponse getEmployee(int empId) {
		EmpInfoBean empInfoBean = service.getEmployee(empId);

		EmployeeResponse response = new EmployeeResponse();
		if (empInfoBean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Record Found.");
			response.setEmpInfo(empInfoBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee Record Not Found!");
		}
		return response;
	}// End of getEmployee()

	@GetMapping("/getAllEmployees")
	public EmployeeResponse getAllEmployee() {
		List<EmpInfoBean> emList = service.getAllEmployees();
		EmployeeResponse response = new EmployeeResponse();
		if (emList != null && !emList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Data Found.");
			response.setEmployeeList(emList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No Records To Display!");
		}
		return response;
	}// End of getAllEmployee()
}// End of controller
