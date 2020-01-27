package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcits.springmvc.customexception.EmployeeException;

@ControllerAdvice
public class EmployeeControllerAdvice {
	
	@ExceptionHandler(EmployeeException.class)
	public String handleEmployeeException(EmployeeException exception,HttpServletRequest req) {
		String errMsg=exception.getMessage();
		
		req.setAttribute("errMsg",errMsg);
		return "errorPage";
	}
}//End of class
