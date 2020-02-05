package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam.Mode;
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

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;
import com.bcits.discomusecase.bean.MonthlyConsumtion;
import com.bcits.discomusecase.bean.PaymentDetails;
import com.bcits.discomusecase.consumerservicedao.ConsumerServiceDAO;
import com.bcits.discomusecase.employeedservice.EmployeeServiceDAO;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
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
			
			List<PaymentDetails> list=service.displayHome(employeeInfo.getRegion());
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
			List<PaymentDetails> list=service.displayHome(employeeInfo.getRegion());
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
	
	
	@GetMapping("/billUpdatePage")
	public String billUpdatePage(HttpSession session,ModelMap modelMap) {
		EmployeeInfo employeeInfo=(EmployeeInfo)session.getAttribute("valid");
		if(employeeInfo!=null) {
			//Valid details
			return "employeeBillUpdatePage";
		}else {
			//Invalid details
			modelMap.addAttribute("errMsg", "Please LogIn First!!!");
			return "employeeLogin";
		}
	}//End of billUpdatePage()
	
	@PostMapping("/billUpdate")
	public String billUpdate(HttpSession session,ModelMap modelMap,ConsumerCurrentBill consumerCurrentBill) {
		EmployeeInfo employeeInfo=(EmployeeInfo)session.getAttribute("valid");
		if(employeeInfo!=null) {
			//Valid details
			if (service.billUpdate(consumerCurrentBill)) {
				modelMap.addAttribute("msg", "Bill Updation Successfull..");
			}else {
				modelMap.addAttribute("errMsg", "Bill Updation Failed!!");
			}
			return "employeeBillUpdatePage";
		}else {
			//Invalid details
			modelMap.addAttribute("errMsg", "Please LogIn First!!!");
			return "employeeLogin";
		}
	}//End of billUpdate()
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("msg", "You are Successfully Logged Out");
		return "employeeLogin";
	}//End of logout()
	
	@GetMapping("/getComments")
	public String getComments(HttpSession session,ModelMap modelMap) {
		EmployeeInfo employeeInfo=(EmployeeInfo)session.getAttribute("valid");
		if(employeeInfo!=null) {
			//Valid details
			List<ContactUsInfo> list=service.getComments();
			if (list!=null&&!list.isEmpty()) {
				modelMap.addAttribute("list", list);
				
			}else {
				modelMap.addAttribute("errMsg", "Details are not found Please check the region!");
			}
			return "commentsPage";
		}else {
			//Invalid details
			modelMap.addAttribute("errMsg", "Please LogIn First!!!");
			return "employeeLogin";
		}
	}//End of getComments()
	
	
	@GetMapping("/searchPage")
	public String searchPage(HttpSession session,ModelMap modelMap) {
		EmployeeInfo employeeInfo=(EmployeeInfo)session.getAttribute("valid");
		if(employeeInfo!=null) {
			//Valid details
			return "employeeSearch";
		}else {
			//Invalid details
			modelMap.addAttribute("errMsg", "Please LogIn First!!!");
			return "employeeLogin";
		}
	}//End of searchPage()
	
	@PostMapping("displayLinks")
	public String displayLinks(HttpSession session,ModelMap modelMap,String rrNumber) {
		EmployeeInfo employeeInfo=(EmployeeInfo)session.getAttribute("valid");
		if(employeeInfo!=null) {
			//Valid details
			session.setAttribute("sessionRRNumber", rrNumber);
			modelMap.addAttribute("rrNumber", rrNumber);
			return "employeeSearch";
		}else {
			//Invalid details
			modelMap.addAttribute("errMsg", "Please LogIn First!!!");
			return "employeeLogin";
		}
	}//End of displayLinks()
	
	@GetMapping("/searchConsumerDetails")
	public String searchConsumerDetails(HttpSession session,ModelMap modelMap) {
		String rrNumber=(String)session.getAttribute("sessionRRNumber");
		ConsumerInfo consumerInfo=service.getConsumerInfo(rrNumber);
		if (consumerInfo != null) {
			session.setAttribute("rrNumber", rrNumber);
			modelMap.addAttribute("consumerInfo", consumerInfo);
		}else {
			modelMap.addAttribute("errMsg", "Details are Not Found!!");
		}
		return "employeeSearch";
	}//End of searchConsumerDetails()
	
	@GetMapping("/searchConsumerCurrentBillDetails")
	public String searchConsumerCurrentBillDetails(HttpSession session,ModelMap modelMap) {
		String rrNumber=(String)session.getAttribute("sessionRRNumber");
		ConsumerCurrentBill currentBill=service.getConsumerCurrentBill(rrNumber);
		if (currentBill != null) {
			session.setAttribute("rrNumber", rrNumber);
			modelMap.addAttribute("currentBill", currentBill);
		}else {
			modelMap.addAttribute("errMsg", "Details are Not Found!!");
		}
		return "employeeSearch";
	}//End of searchConsumerDetails()
	
	@GetMapping("/searchMonthlyConsumtionDetails")
	public String searchMonthlyConsumtionDetails(HttpSession session,ModelMap modelMap) {
		String rrNumber=(String)session.getAttribute("sessionRRNumber");
		List<MonthlyConsumtion> monthlyConsumtion=service.getMonthlyConsumption(rrNumber);
		if (monthlyConsumtion != null) {
			session.setAttribute("rrNumber", rrNumber);
			modelMap.addAttribute("monthlyConsumtion", monthlyConsumtion);
		}else {
			modelMap.addAttribute("errMsg", "Details are Not Found!!");
		}
		return "employeeSearch";
	}//End of searchMonthlyConsumtionDetails()
	
	@GetMapping("/searchPaymentDetails")
	public String searchPaymentDetails(HttpSession session,ModelMap modelMap) {
		String rrNumber=(String)session.getAttribute("sessionRRNumber");
		PaymentDetails paymentDetails=service.getPaymentDetails(rrNumber);
		if (paymentDetails != null) {
			session.setAttribute("rrNumber", rrNumber);
			modelMap.addAttribute("paymentDetails", paymentDetails);
		}else {
			modelMap.addAttribute("errMsg", "Details are Not Found!!");
		}
		return "employeeSearch";
	}//End of searchPaymentDetails()
	
	
}// End of EmployeeController
