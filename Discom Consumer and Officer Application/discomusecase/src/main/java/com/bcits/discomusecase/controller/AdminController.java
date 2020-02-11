package com.bcits.discomusecase.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.adminservice.AdminService;
import com.bcits.discomusecase.bean.AdminInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping("/adminPage")
	public String displayAdminPage() {
		return "adminLogin";
	}// End of getAdminPage()

	@PostMapping("/adminLogin")
	public String getAdminLogin(int adminId, String password, HttpServletRequest request, ModelMap modelMap) {
		AdminInfo adminInfo = service.authenticate(adminId, password);
		if (adminInfo != null) {
			// Valid session
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", adminInfo);
			return "employeeSignin";
		} else {
			// Invalid Session
			return "adminLogin";
		}

	}// End of getAdminLogin()

	@PostMapping("employeeSignin")
	public String addEmployee(EmployeeInfo employeeInfo, HttpSession session, ModelMap modelMap) {
		AdminInfo adminInfo = (AdminInfo) session.getAttribute("admin");
		if (adminInfo != null) {
			// Valid Session
			if (service.addEmployee(employeeInfo)) {
				modelMap.addAttribute("msg", "Employee Signin Successful.");
			} else {
				modelMap.addAttribute("errMsg", "Employee Signin Failed!!");
			}
			return "employeeSignin";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Please Login!");
			return "adminLogin";
		}
	}// End of addEmployee()
	
	@GetMapping("/logout")
	public String adminLogout(HttpSession session,ModelMap map) {
		session.invalidate();
		map.addAttribute("errMsg", "You are Successfully Logged Out!!");
		return "adminLogin";
	}//End of adminLogout()
}// End of controller
