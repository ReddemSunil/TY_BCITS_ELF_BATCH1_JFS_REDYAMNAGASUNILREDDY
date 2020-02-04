package com.bcits.discomusecase.controller;

import java.util.List;

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

	@PostMapping("/employeeLoginPage")
	public String employeeLogin(int empId, String password, ModelMap modelMap, HttpServletRequest req) {
		EmployeeInfo employeeInfo = service.authenticate(empId, password);
		if (employeeInfo != null) {
			// Valid Session
			HttpSession session = req.getSession(true);
			session.setAttribute("valid", employeeInfo);
			modelMap.addAttribute("employee", employeeInfo);
			
			List<String> list=(List<String>)service.displayHome(employeeInfo.getRegion());
			if (list!=null&&!list.isEmpty()) {
				modelMap.addAttribute("list", list);
				
			}else {
				modelMap.addAttribute("errMsg", "Details are not found Please check the region!");
			}
			return "employeeHome";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Invalid Credentials!");
			return "employeeLogin";
		}

	}// End of employeeLogin()
	
	
	@GetMapping("/employeHome")
	public String employeeHome(HttpSession session,ModelMap modelMap) {
		EmployeeInfo employeeInfo=(EmployeeInfo)session.getAttribute("valid");
		if(employeeInfo!=null) {
			//Valid details
			List<String> list=(List<String>)service.displayHome(employeeInfo.getRegion());
			if (list!=null&&!list.isEmpty()) {
				modelMap.addAttribute("list", list);
				modelMap.addAttribute("employee", employeeInfo);
				
			}else {
				modelMap.addAttribute("errMsg", "Details are not found Please check the region!");
			}
			return "employeeHome";
		}else {
			//Invalid details
			modelMap.addAttribute("errMsg", "Please LogIn First!!!");
			return "employeeLogin";
		}
	}//End of employeeHome()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// End of EmployeeController
