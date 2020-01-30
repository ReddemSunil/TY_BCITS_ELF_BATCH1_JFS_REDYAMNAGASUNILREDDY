package com.bcits.discomusecase.consumercontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcits.discomusecase.consumerException.ConsumerException;

@ControllerAdvice
public class ConsumerControllerAdvice {

	@ExceptionHandler(ConsumerException.class)
	public void handleConsumerException(ConsumerException ex, HttpServletRequest req) {
		String errMsg = ex.getMessage();

		req.setAttribute("errMsg", errMsg);
	}// End of handleConsumerException()
}// End of class
