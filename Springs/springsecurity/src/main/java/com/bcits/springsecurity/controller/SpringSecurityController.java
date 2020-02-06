package com.bcits.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpringSecurityController {

	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}//End of getIndexPage()
	
	@GetMapping("/adminSecureHome")
	public String getAdminSecureHome() {
		return "adminHomePage";
	}//End of getAdminSecureHome()
	
	@GetMapping("/userSecureHome")
	public String getUserSecureHome() {
		return "userHomePage";
	}//End of getUserSecureHome()
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
}//End of controller
