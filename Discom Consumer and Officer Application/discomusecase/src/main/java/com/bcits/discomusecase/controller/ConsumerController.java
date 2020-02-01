package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.consumerservicedao.ConsumerServiceDAO;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private ConsumerServiceDAO service;
	
	@GetMapping("/consumerLoginPage")
	public String getConsumerLogin() {
		return "ConsumerLogin";
	}//End of getConsumerLogin()
	
	@PostMapping("/consumerLogin")
	public String consumerLogin(String meterNumber,String password,HttpServletRequest req,ModelMap modelMap) {
		ConsumerInfo consumerInfo=service.authenticate(meterNumber, password);
		if(consumerInfo!=null) {
			//Valid Session
			HttpSession session=req.getSession(true);
			session.setAttribute("validation", consumerInfo);
			return "consumerHome";
		}else {
			//InvalidSession
			modelMap.addAttribute("errMsg", "Invalid Credentials!");
			return "ConsumerLogin";
		}
	}//End of consumerLogin()
	
	@GetMapping("/consumerSigninPage")
	public String getConsumerSignin() {
		return "consumerSignin";
	}//End of getConsumerLogin()
	
	
	@PostMapping("/consumerSignin")
	public String consumerSignin(ConsumerInfo consumerInfo,String cPassword,String meterNumber, ModelMap modelMap) {
		if(service.signinConumer(consumerInfo, cPassword,meterNumber)) {
			
			modelMap.addAttribute("msg", "Signin Successfull");
		}else {
			modelMap.addAttribute("errMsg", "Signin Failed!");
		}
		return "ConsumerLogin";
	}//End of consumerSignin()

}// End of class
