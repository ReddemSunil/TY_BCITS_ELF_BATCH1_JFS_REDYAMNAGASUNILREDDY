package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.implementation.EmployeeDAOImpl;
import com.bcits.springmvc.interfaces.EmployeeDAO;
import com.bcits.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/login")
	public String displayLogin() {
		return "empLoginForm";
	}// End of displayLogin()

	@PostMapping("/login")
	public String authenticate(int empId, String password, ModelMap map, HttpServletRequest req) {

		EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);
		if (employeeInfoBean != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmpInfo", employeeInfoBean);

			return "employeeHome";
		} else {
			// Invalid credentials
			map.addAttribute("errMsg", "Invalid Credentials");
			return "empLoginForm";
		}
	}// End of authenticate()

	@GetMapping("/searchEmpForm")
	public String displayEmployeeForm(HttpSession session, ModelMap map) {
		if (session.isNew()) {
			// user not logged in
			session.invalidate();

			map.addAttribute("errMsg", "Please LogIn first");
			return "empLoginForm";
		} else {
			// user already logged
			return "searchEmpForm";
		}
	}// End of displayEmployeeForm()

	@GetMapping("/search")
	public String searchEmployee(int empId, HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("loggedInEmpInfo") != null) {
			// valid session

			EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
			if (employeeInfoBean != null) {
				modelMap.addAttribute("employeeInfoBean", employeeInfoBean);

			} else {
				modelMap.addAttribute("errMsg", "Employee Id not found");
			}
			return "searchEmpForm";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "empLoginForm";
		}
	}// End of searchEmployee()

	@GetMapping("/deleteEmpForm")
	public String displayDeleteEmployeeForm(
			@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		if (employeeInfoBean != null) {
			// valid session
			return "deleteEmpForm";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please login first");
			return "empLoginForm";
		}
	}// End of displayDeleteEmployeeForm()

	@GetMapping("/delete")
	public String deleteEmployee(int empId,
			@SessionAttribute(name = "loggedInEmpInfo") EmployeeInfoBean employeeInfoBean, ModelMap modelMap) {
		if (employeeInfoBean != null) {
			// valid session
			if (service.deleteEmployee(empId)) {
				modelMap.addAttribute("msg", "Employee Record Deleted Successfully...");
			} else {
				modelMap.addAttribute("errMsg", "Employee Record Not Found");
			}
			return "deleteEmpForm";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please login first");
			return "empLoginForm";
		}
	}// End of deleteEmployee()

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("errMsg", "you are successfully logged out");
		return "empLoginForm";
	}// End of logout()

}// End of class
