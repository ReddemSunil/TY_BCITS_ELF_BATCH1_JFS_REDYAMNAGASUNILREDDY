package com.bcits.discomusecase.controller;

import java.nio.channels.SeekableByteChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.BillHistory;
import com.bcits.discomusecase.bean.PaymentDetails;
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
			ConsumerCurrentBill consumerCurrentBill = service.findBillDetailes(rrNumber);
			if (consumerCurrentBill != null) {

				modelMap.addAttribute("consumerCurrentBill", consumerCurrentBill);
			} else {
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
	public String consumerLogin1(HttpSession session, HttpServletRequest req) {
		ConsumerInfo consumerInfo = (ConsumerInfo) session.getAttribute("validation");
		if (consumerInfo != null) {
			// Valid Session
			ConsumerCurrentBill consumerCurrentBill = service.findBillDetailes(consumerInfo.getRrNumber());
			if (consumerCurrentBill != null) {
				req.setAttribute("consumerCurrentBill", consumerCurrentBill);
			} else {
				req.setAttribute("errMsg", "Details Not Found");
			}
			return "consumerHome";
		} else {
			// Invalid Session
			req.setAttribute("errMsg", "Please Login First");
			return "ConsumerLogin";
		}

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
		if (consumerInfo != null) {
			// Valid Session
			map.addAttribute("consumerInfo", consumerInfo);
			return "consumerProfileOpen";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "ConsumerLogin";
		}
	}// End of consumerProfileOpen()

	@GetMapping("/consumerProfileUpdatePage")
	public String consumerProfileUpdatePage(HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("validation") != null) {
			// valid details
			return "consumerProfileUpdate";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "ConsumerLogin";
		}

	}// End of consumerProfileUpdatePage()

	@PostMapping("/consumerProfileUpdate")
	public String consumerProfileUpdate(ConsumerInfo consumerInfo, String cPassword, ModelMap modelMap,
			HttpSession session) {
		ConsumerInfo consumerInfo2 = (ConsumerInfo) session.getAttribute("validation");
		if (consumerInfo2 != null) {
			// Valid Session
			consumerInfo.setRrNumber(consumerInfo2.getRrNumber());
			if (service.updateConsumerProfile(consumerInfo, cPassword)) {
				modelMap.addAttribute("msg", "Successfully profile Updated");
			} else {
				modelMap.addAttribute("errMsg", "Profile Updation is Failed...");
			}
			return "consumerProfileUpdate";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "ConsumerLogin";
		}
	}// End of consumerProfileUpdate()

	@GetMapping("/billPaymentPage")
	public String billPaymentPage(HttpSession session, ModelMap modelMap) {
		ConsumerInfo consumerInfo = (ConsumerInfo) session.getAttribute("validation");
		if (consumerInfo != null) {
			// Valid Session
			
				ConsumerCurrentBill bill=service.findBillDetailes(consumerInfo.getRrNumber());
				if (bill==null) {
					
					modelMap.addAttribute("errMsg", "You are a new user as of now your bill not yet generated!!");
					return "consumerHome";
				}else if (bill.getAmount()==0.0) {
					modelMap.addAttribute("consumerCurrentBill", bill);
					modelMap.addAttribute("errMsg", "Your Bill is Paided!!");
					return "consumerHome";
				} else {
					if (bill.getCount()==1) {
						modelMap.addAttribute("bill", bill);
						return "billPaymentPage";
					}else {
						modelMap.addAttribute("errMsg", "Only Once You Can Pay the bill Per Month");
						return "consumerHome";
					}
					
				}
				
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "ConsumerLogin";
		}
	}// End of billPaymentPage()

	@PostMapping("/paymentSuccessfullPage")
	public String paymentSuccessful(HttpSession session,ModelMap modelMap,Double amountPaid,PaymentDetails paymentDetails) {
		ConsumerInfo consumerInfo = (ConsumerInfo) session.getAttribute("validation");
		if (consumerInfo != null) {
			//Valid session
			ConsumerCurrentBill bill=service.findBillDetailes(consumerInfo.getRrNumber());
			paymentDetails.setAmount(bill.getAmount());
			paymentDetails.setRrNumber(bill.getRrNumber());
			paymentDetails.setAmountPaid(amountPaid);
			if(service.payment(paymentDetails, amountPaid)) {
				return "Payment";
				
			}else {
				modelMap.addAttribute("errMsg", "Payment Failed");
				return "billPaymentPage";
			}
		}else {
			//Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "ConsumerLogin";
		}
	}// End of paymentSuccessful()

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("msg", "You are Successfully Logged Out!!");
		return "ConsumerLogin";
	}// End of logout()

	@GetMapping("/contactUsPage")
	public String contactUsPage(HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("validation") != null) {
			// valid details
			return "contactUsPage";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "ConsumerLogin";
		}
	}// End of contactUsPage()

	@PostMapping("/contactUs")
	public String contactUs(HttpSession session, ModelMap modelMap, ContactUsInfo contactUsInfo) {
		ConsumerInfo consumerInfo = (ConsumerInfo) session.getAttribute("validation");
		if (consumerInfo != null) {
			// Valid Session
			contactUsInfo.setRrNumber(consumerInfo.getRrNumber());
			if (service.addComments(contactUsInfo)) {

				modelMap.addAttribute("msg", "Comments Request Successfull! We Will Call You Later");
			} else {
				modelMap.addAttribute("errMsg", "Comments Request failed..");
			}
			return "contactUsPage";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "ConsumerLogin";
		}

	}// End of contactUs()
	
	
	@GetMapping("/getBillHistory")
	public String getBillHistory(HttpSession session,ModelMap modelMap) {
		ConsumerInfo consumerInfo = (ConsumerInfo) session.getAttribute("validation");
		String rrNumber=consumerInfo.getRrNumber();
		if (consumerInfo != null) {
			//Valid Session
			List<BillHistory> list=service.findBillHistory(rrNumber);
			if(list!=null&&!list.isEmpty()) {
				modelMap.addAttribute("list", list);
				modelMap.addAttribute("rrNumber", consumerInfo.getRrNumber());
			}else {
				modelMap.addAttribute("errMsg", "You don't have bill history!!");
			}
			return "billHistory";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "ConsumerLogin";
		}
	}//End of getBillHistory()

}// End of class
