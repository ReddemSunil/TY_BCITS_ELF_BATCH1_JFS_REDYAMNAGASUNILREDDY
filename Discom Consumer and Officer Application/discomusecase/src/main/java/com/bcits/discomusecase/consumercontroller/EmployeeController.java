package com.bcits.discomusecase.consumercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.consumerservicedao.ConsumerServiceDAO;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private ConsumerServiceDAO service;
	
	@GetMapping("/employeeLogin")
	public String getEmployeeLogin() {
		return "employeeLogin";
	}//End of getEmployeeLogin()
	
	
}//End of EmployeeController
