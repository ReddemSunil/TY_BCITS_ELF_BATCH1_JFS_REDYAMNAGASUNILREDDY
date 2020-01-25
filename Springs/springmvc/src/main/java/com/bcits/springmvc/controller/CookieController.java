package com.bcits.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {

	@GetMapping("/cookie")
	public String getcookiePage() {
		return "cookiePage";
	}

	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse resp, ModelMap map) {
		Cookie myCookie = new Cookie("empName", "suresh");
		resp.addCookie(myCookie);
		map.addAttribute("msg", "cookie is created successfully");
		return "cookiePage";
	}// End of createCookie()

	@GetMapping("/readCookie")
	public String getCookie(@CookieValue(name = "empName", required = false) // required=false is avoiding the bad
																				// request problem in browser
	String employeeName, ModelMap map) {
		if (employeeName != null) {
			map.addAttribute("msg", "cookie value is " + employeeName);
		} else {
			map.addAttribute("errMsg", "cookie not present!");
		}
		return "cookiePage";
	}// End of getCookie()
}// End of class
