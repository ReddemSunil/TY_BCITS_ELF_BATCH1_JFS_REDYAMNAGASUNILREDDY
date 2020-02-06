package com.bcits.springsecuritymvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;
import com.bcits.springsecuritymvc.service.EmpService;

@Controller
public class EmpSecurityController {

	@Autowired
	private EmpService service;

	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}// End of getIndexPage()

	@GetMapping("/register")
	public String getRegisterForm() {
		return "register";
	}// End of getRegisterForm()

	@PostMapping("/register")
	public String register(EmpInfoBean empInfoBean, ModelMap modelMap) {
		boolean isRegistered = service.register(empInfoBean);
		if (isRegistered) {
			modelMap.addAttribute("msg", "Register SuccessFully...");
		} else {
			modelMap.addAttribute("errMsg", "Register Failed!!");
		}
		return "register";
	}// End of register()

	@GetMapping("/adminSecureHome")
	public String adminSecureHomePage() {
		return "adminHomePage";
	}// End of adminSecureHomePage()

	@GetMapping("/userSecureHome")
	public String userSecureHomePage() {
		return "userHomePage";
	}// End of userSecureHomePage()

	@GetMapping("/getEmployeeForm")
	public String getEmployeeForm() {
		return "search";
	}// End of getEmployeeForm()

	@GetMapping("/getEmployee")
	public String getEmployee(ModelMap modelMap, int empId) {
		EmpInfoBean empInfoBean = service.getEmployee(empId);
		modelMap.addAttribute("empInfoBean", empInfoBean);
		return "search";
	}// End of getEmployee()

	@GetMapping("/getAllEmployee")
	public String getAllEmployee(ModelMap modelMap) {
		List<EmpInfoBean> list = service.getAllEmployees();
		modelMap.addAttribute("list", list);
		return "getAllEmployees";
	}// End of getAllEmployee()
}// End of controller
