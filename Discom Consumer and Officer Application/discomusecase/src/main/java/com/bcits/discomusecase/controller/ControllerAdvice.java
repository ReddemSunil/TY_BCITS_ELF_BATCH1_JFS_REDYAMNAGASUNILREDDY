package com.bcits.discomusecase.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcits.discomusecase.consumerException.BillUpdatePageException;
import com.bcits.discomusecase.consumerException.ConsumerLoginException;
import com.bcits.discomusecase.consumerException.ConsumerPaymentException;
import com.bcits.discomusecase.consumerException.ConsumerSigninException;
import com.bcits.discomusecase.consumerException.ConsumerUpdateException;
import com.bcits.discomusecase.consumerException.EmployeeLoginException;
import com.bcits.discomusecase.consumerException.EmployeeSearchException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(ConsumerSigninException.class)
	public String handleConsumerException(ConsumerSigninException ex, HttpServletRequest req) {
		String errMsg = ex.getMessage();

		req.setAttribute("errMsg", errMsg);
		return "consumerSignin";
	}// End of handleConsumerException()
	
	@ExceptionHandler(ConsumerLoginException.class)
	public String handleConsumerLoginException(ConsumerLoginException ex, HttpServletRequest req) {
		String errMsg = ex.getMessage();

		req.setAttribute("errMsg", errMsg);
		return "ConsumerLogin";
	}// End of handleConsumerLoginException()
	
	@ExceptionHandler(EmployeeLoginException.class)
	public String handleEmployeeLoginException(EmployeeLoginException ex, HttpServletRequest req) {
		String errMsg = ex.getMessage();

		req.setAttribute("errMsg", errMsg);
		return "employeeLogin";
	}// End of handleEmployeeLoginException()
	
	@ExceptionHandler(BillUpdatePageException.class)
	public String handleBillUpdatePageException(BillUpdatePageException ex, HttpServletRequest req) {
		String errMsg = ex.getMessage();

		req.setAttribute("errMsg", errMsg);
		return "employeeBillUpdatePage";
	}// End of handleBillUpdatePageException()
	
	@ExceptionHandler(EmployeeSearchException.class)
	public String handleEmployeeSearchException(EmployeeSearchException ex, HttpServletRequest req) {
		String errMsg = ex.getMessage();

		req.setAttribute("errMsg", errMsg);
		return "employeeSearch";
	}// End of handleEmployeeSearchException()
	
	@ExceptionHandler(ConsumerUpdateException.class)
	public String handleConsumerUpdateException(ConsumerUpdateException ex, HttpServletRequest req) {
		String errMsg = ex.getMessage();

		req.setAttribute("errMsg", errMsg);
		return "consumerProfileUpdate";
	}// End of handleConsumerUpdateException()
	
	@ExceptionHandler(ConsumerPaymentException.class)
	public String handleConsumerPaymentException(ConsumerPaymentException ex, HttpServletRequest req) {
		String errMsg = ex.getMessage();

		req.setAttribute("errMsg", errMsg);
		return "billPaymentPage";
	}// End of handleConsumerPaymentException()
}// End of class
