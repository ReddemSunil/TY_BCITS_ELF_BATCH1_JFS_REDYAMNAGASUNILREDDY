package com.bcits.discomusecase.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.bean.EmployeeInfo;
import com.bcits.discomusecase.consumerservicedao.ConsumerServiceDAO;
import com.bcits.discomusecase.employeedservice.EmployeeServiceDAO;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeServiceDAO service;

	@GetMapping("/employeeLoginPage")
	public String getEmployeeLogin() {
		return "employeeLogin";
	}// End of getEmployeeLogin()

	@PostMapping("/employeeLogin")
	public String employeeLogin(int empId, String password, ModelMap modelMap, HttpServletRequest req) {
		EmployeeInfo employeeInfo = service.authenticate(empId, password);
		if (employeeInfo != null) {
			// Valid Session
			HttpSession session = req.getSession(true);
			session.setAttribute("valid", employeeInfo);
			return "employeeHome";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Invalid Credentials!");
			return "employeeLogin";
		}

	}// End of employeeLogin()
}// End of EmployeeController
