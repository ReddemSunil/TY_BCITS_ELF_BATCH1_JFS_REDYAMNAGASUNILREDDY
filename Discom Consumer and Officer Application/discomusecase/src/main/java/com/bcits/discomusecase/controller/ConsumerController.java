package com.bcits.discomusecase.controller;

import java.nio.channels.SeekableByteChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
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
	}// End of getConsumerLogin()

	@GetMapping("/consumerHomePage")
	public String getConsumerHome() {
		return "consumerHome";
	}// End of getConsumerHome()

	@PostMapping("/consumerLogin")
	public String consumerLogin(String rrNumber, String password, HttpServletRequest req, ModelMap modelMap) {
		ConsumerInfo consumerInfo = service.authenticate(rrNumber, password);
		if (consumerInfo != null) {
			// Valid Session
			HttpSession session = req.getSession(true);
			session.setAttribute("validation", consumerInfo);
			ConsumerCurrentBill consumerCurrentBill=service.findBillDetailes(rrNumber);
			if (consumerCurrentBill != null) {
				
				modelMap.addAttribute("consumerCurrentBill", consumerCurrentBill);
			}else {
				modelMap.addAttribute("errMsg", "Details Not Found");
			}
			return "consumerHome";
		} else {
			// InvalidSession
			modelMap.addAttribute("errMsg", "Invalid Credentials!");
			return "ConsumerLogin";
		}
	}// End of consumerLogin()

	@GetMapping("/home")
	public String consumerLogin1(HttpSession session,HttpServletRequest req) {
		ConsumerInfo consumerInfo=(ConsumerInfo)session.getAttribute("validation");
		ConsumerCurrentBill consumerCurrentBill=service.findBillDetailes(consumerInfo.getRrNumber());
		req.setAttribute("consumerCurrentBill", consumerCurrentBill);
		return "consumerHome";

	}// End of consumerLogin()

	@GetMapping("/consumerSigninPage")
	public String getConsumerSignin() {
		return "consumerSignin";
	}// End of getConsumerLogin()

	@PostMapping("/consumerSignin")
	public String consumerSignin(ConsumerInfo consumerInfo, String cPassword, String rrNumber, ModelMap modelMap) {
		if (service.signinConumer(consumerInfo, cPassword, rrNumber)) {

			modelMap.addAttribute("msg", "Signin Successfull");
		} else {
			modelMap.addAttribute("errMsg", "Signin Failed!");
		}
		return "ConsumerLogin";
	}// End of consumerSignin()

	@GetMapping("/consumerProfileOpen")
	public String consumerProfileOpen(HttpSession session, ModelMap map) {
		ConsumerInfo consumerInfo = (ConsumerInfo) session.getAttribute("validation");
		map.addAttribute("consumerInfo", consumerInfo);
		return "consumerProfileOpen";
	}// End of consumerProfileOpen()

	@GetMapping("/consumerProfileUpdatePage")
	public String consumerProfileUpdatePage() {
		return "consumerProfileUpdate";
	}// End of consumerProfileUpdatePage()

	@PostMapping("/consumerProfileUpdate")
	public String consumerProfileUpdate(ConsumerInfo consumerInfo, String cPassword, ModelMap modelMap,HttpSession session) {
		ConsumerInfo consumerInfo2=(ConsumerInfo)session.getAttribute("validation");
		consumerInfo.setRrNumber(consumerInfo2.getRrNumber());
		if (service.updateConsumerProfile(consumerInfo, cPassword)) {
			modelMap.addAttribute("msg", "Successfully profile Updated");
		} else {
			modelMap.addAttribute("errMsg", "Profile Updation is Failed...");
		}
		return "consumerProfileUpdate";
	}// End of consumerProfileUpdate()
	
	@GetMapping("/billPaymentPage")
	public String billPaymentPage() {
		return "billPaymentPage";
	}

}// End of class
