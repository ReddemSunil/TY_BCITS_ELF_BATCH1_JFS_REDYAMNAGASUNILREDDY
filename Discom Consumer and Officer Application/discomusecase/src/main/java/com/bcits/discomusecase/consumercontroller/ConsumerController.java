package com.bcits.discomusecase.consumercontroller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.consumerservicedao.ConsumerServiceDAO;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private ConsumerServiceDAO service;
	
	@GetMapping("/consumerLogin")
	public String getConsumerLogin() {
		return "ConsumerLogin";
	}//End of getConsumerLogin()
	
	@GetMapping("/consumerSignin")
	public String getConsumerSignin() {
		return "consumerSignin";
	}//End of getConsumerLogin()

}// End of class
