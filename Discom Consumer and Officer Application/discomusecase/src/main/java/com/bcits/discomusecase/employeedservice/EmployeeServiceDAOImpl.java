package com.bcits.discomusecase.employeedservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;
import com.bcits.discomusecase.bean.BillHistory;
import com.bcits.discomusecase.bean.PaymentDetails;
import com.bcits.discomusecase.consumerException.BillUpdatePageException;
import com.bcits.discomusecase.consumerException.ConsumerSigninException;
import com.bcits.discomusecase.consumerException.EmployeeLoginException;
import com.bcits.discomusecase.employeedao.EmployeeDAO;

@Service
public class EmployeeServiceDAOImpl implements EmployeeServiceDAO {
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfo authenticate(int empId, String password) {
		if (empId < 1) {
			throw new EmployeeLoginException("Employee Id Not Contains Negative Values");
		}
		if (password.trim().length() < 5) {
			throw new EmployeeLoginException("Please Enter Proper Password Length!!");
		}
		return dao.authenticate(empId, password);
	}// End of authenticate()

	@Override
	public List<PaymentDetails> displayHome(String region) {
		return dao.displayHome(region);
	}// End of displayHome()

	@Override
	public boolean billUpdate(ConsumerCurrentBill consumerCurrentBill) {
		if (consumerCurrentBill.getRrNumber().isEmpty()||consumerCurrentBill.getRrNumber().startsWith("-")) {
			throw new BillUpdatePageException(
					"RR Number is not valid!!");
		}
		if (consumerCurrentBill.getFinalUnits()==null||consumerCurrentBill.getFinalUnits()<0) {
			throw new BillUpdatePageException(
					"please enter valid final units!!");
		}
		if (consumerCurrentBill.getReadingsTakenOn() == null||consumerCurrentBill.getDueDate()==null) {
			throw new BillUpdatePageException(
					"please enter valid date!!");
		}
		if(consumerCurrentBill.getReadingsTakenOn().compareTo(consumerCurrentBill.getDueDate())>0) {
			throw new BillUpdatePageException(
					"due date is not valid!!");
		}
		ConsumerCurrentBill consumerCurrentBill2 = dao.getConsumerCurrentBill(consumerCurrentBill.getRrNumber());
		if (consumerCurrentBill2 != null) {
			if (consumerCurrentBill2.getReadingsTakenOn().compareTo(consumerCurrentBill.getReadingsTakenOn())>0) {
				throw new BillUpdatePageException(
						"please enter valid readings taken date it should be more previeous readings taken!!");
			}
			if (consumerCurrentBill.getFinalUnits() < consumerCurrentBill2.getFinalUnits()) {
				throw new BillUpdatePageException(
						"Final value readings are less compare to previeous readings please check once!!");
			}
		}
		return dao.billUpdate(consumerCurrentBill);
	}// End of billUpdate()

	@Override
	public List<ContactUsInfo> getComments() {
		return dao.getComments();
	}// End of getComments()

	@Override
	public ConsumerInfo getConsumerInfo(String rrNumber) {

		return dao.getConsumerInfo(rrNumber);
	}// End of getConsumerInfo()

	@Override
	public ConsumerCurrentBill getConsumerCurrentBill(String rrNumber) {
		return dao.getConsumerCurrentBill(rrNumber);
	}// End of getConsumerCurrentBill()

	@Override
	public List<BillHistory> getMonthlyConsumption(String rrNumber) {
		return dao.getBillHistory(rrNumber);
	}// End of getMonthlyConsumption()

	@Override
	public PaymentDetails getPaymentDetails(String rrNumber) {
		return dao.getPaymentDetails(rrNumber);
	}// End of getPaymentDetails()

	@Override
	public List<ConsumerInfo> getAllConsumerDetails(String region) {
		return dao.getAllConsumerDetails(region);
	}// End of getAllConsumerDetails()

	@Override
	public List<ConsumerCurrentBill> getAllConsumerCurrentBills(String region) {
		return dao.getAllConsumerCurrentBills(region);
	}// End of getAllConsumerCurrentBills()

	@Override
	public List<Object[]> getMonthlyRevenue(String region) {
		return dao.getMonthlyRevenue(region);
	}// End of getMonthlyRevenue()

	@Override
	public ContactUsInfo displayResponsePage(String rrNumber) {
		return dao.displayResponsePage(rrNumber);
	}// End of displayResponsePage()

	@Override
	public boolean sedingResponse(String suggestion, ContactUsInfo contactUsInfo) {
		return dao.sedingResponse(suggestion, contactUsInfo);
	}// End of sendingResponse()

}// End of class
