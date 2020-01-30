package com.bcits.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springboot.beans.EmployeeInfoBean;
import com.bcits.springboot.beans.EmployeeResponse;
import com.bcits.springboot.service.EmployeeService;

//@Controller 
@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;

//	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
////	@ResponseBody
//	public EmployeeInfoBean getEmployee(int empId) {
//		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
//		return employeeInfoBean;
//	}// End of getEmployee()

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//	@ResponseBody
	public EmployeeResponse getEmployee(int empId) {
		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
		EmployeeResponse response = new EmployeeResponse();
		if (employeeInfoBean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Record Found for Id " + empId);
			response.setEmployeeInfoBean(employeeInfoBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee Id Not Found!! ");
		}
		return response;
	}// End of getEmployee()

	@GetMapping(path = "/getAllEmployee", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
//	@ResponseBody
	public EmployeeResponse getAllEmployees() {
		List<EmployeeInfoBean> emList = service.getAllEmployees();
		EmployeeResponse response = new EmployeeResponse();
		if (emList != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Records Fetched Successfully ");
			response.setEmployeeList(emList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch Records!! ");
		}
		return response;
	}// End of getAllEmployees()

//	@DeleteMapping(path = "/deleteEmployee",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//	public boolean deleteEmployee(int empId) {
	@DeleteMapping(path = "/deleteEmployee/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmployee(@PathVariable(name = "employeeId") int empId) {
		boolean isDeleted = service.deleteEmployee(empId);
		EmployeeResponse response = new EmployeeResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Record Deleted Successfully ");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete employee Record!! ");
		}
		return response;
	}// End of deleteEmployee()

	@PostMapping(path = "/addEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		boolean isAdded = service.addEmployee(employeeInfoBean);
		EmployeeResponse response = new EmployeeResponse();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Record added Successfully ");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add employee Record!! ");
		}
		return response;
	}// End of addEmployee()

	@PutMapping(path = "/updateEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		boolean isUpdated = service.updateEmployee(employeeInfoBean);
		EmployeeResponse response = new EmployeeResponse(); 
		if (isUpdated) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Record Updated Successfully ");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to update employee Record!! ");
		}
		return response;
	}// End of updateEmployee()

}// End of controller
