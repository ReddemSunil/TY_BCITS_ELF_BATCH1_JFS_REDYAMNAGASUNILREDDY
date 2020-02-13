package com.bcits.discomusecase.consumerservicedao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.BillHistory;
import com.bcits.discomusecase.bean.PaymentDetails;
import com.bcits.discomusecase.consumerException.ConsumerLoginException;
import com.bcits.discomusecase.consumerException.ConsumerPaymentException;
import com.bcits.discomusecase.consumerException.ConsumerSigninException;
import com.bcits.discomusecase.consumerException.ConsumerUpdateException;
import com.bcits.discomusecase.consumerdao.ConsumerDAO;

@Service
public class ConsumerServiceImpl implements ConsumerServiceDAO {
	@Autowired
	private ConsumerDAO dao;

	@Override
	public ConsumerInfo authenticate(String rrNumber, String password) {
		if (rrNumber.startsWith("-")) {
			throw new ConsumerLoginException("RR Number Should contains Positive values only");
		}
		if (password.trim().length() < 5) {
			throw new ConsumerLoginException("Pleas enter proper password length!");
		}

		return dao.authenticate(rrNumber, password);
	}// End of authenticate()

	@Override
	public boolean signinConumer(ConsumerInfo consumerInfo, String cPassword, String rrNumber) {

		if (consumerInfo.getFirstName().trim().length() > 15) {
			throw new ConsumerSigninException("First name Should contains lessthan 15 characters!!");
		}
		if (consumerInfo.getLastName().trim().length() > 25) {
			throw new ConsumerSigninException("last name Should contains lessthan 20 characters!!");
		}
		if (rrNumber.startsWith("-")) {
			throw new ConsumerSigninException("RR Number Should contains Positive values only");
		}

		if (consumerInfo.getContactNumber().toString().length() > 12||consumerInfo.getContactNumber().toString().length() < 10) {
			throw new ConsumerSigninException("Contact Number Must be contains 10 digits!");
		}
		if (!consumerInfo.getPassword().equals(cPassword)) {
			throw new ConsumerSigninException("Password and ConfirmPassword Not Matched try Again!!");
		}
		if (consumerInfo.getPassword().trim().length() < 5) {
			throw new ConsumerSigninException("Please Maintain Minimum Password Length(5)!!");
		}
		if (consumerInfo.getPincode().toString().length() > 6) {
			throw new ConsumerSigninException("Pincode Must be contains 6 digits!");
		}

		if (consumerInfo.getRegion() == null) {
			throw new ConsumerSigninException("please select region!!!!");
		}
		if (consumerInfo.getTypeOfConsumer() == null) {
			throw new ConsumerSigninException("please select consumer type!!");
		}
		if (consumerInfo.getPincode() < 6) {
			throw new ConsumerSigninException("please enter valid pincode");
		}

		if (consumerInfo.getAddress1().trim() == null || consumerInfo.getAddress1().trim() == ""
				|| consumerInfo.getAddress1().trim().length() < 20 || consumerInfo.getAddress1().trim().length() > 70) {
			throw new ConsumerSigninException("please enter address1");
		}
		if (consumerInfo.getAddress2().trim() == null || consumerInfo.getAddress2().trim() == ""
				|| consumerInfo.getAddress2().trim().length() < 10 || consumerInfo.getAddress2().trim().length() > 70) {
			throw new ConsumerSigninException("please enter address2");
		}
		return dao.signinConumer(consumerInfo);
	}// End of signinConsumer()

	@Override
	public boolean updateConsumerProfile(ConsumerInfo consumerInfo, String cPassword) {
		if (consumerInfo.getContactNumber().toString().length() > 12||consumerInfo.getContactNumber().toString().length() < 10) {
			throw new ConsumerUpdateException("Contact Number Must be contains 10 digits!");
		}
		if (!consumerInfo.getPassword().equals(cPassword)) {
			throw new ConsumerUpdateException("Password and ConfirmPassword Not Matched try Again!!");
		}
		if (consumerInfo.getContactNumber().toString().length() > 10) {
			throw new ConsumerUpdateException("Contact Number Must be contains 10 digits!");
		}
		return dao.updateConsumerProfile(consumerInfo);
	}// End of updateConsumerProfile()

	@Override
	public ConsumerCurrentBill findBillDetailes(String rrNumber) {

		return dao.findBillDetailes(rrNumber);
	}// End of findBillDetailes()

	@Override
	public boolean addComments(ContactUsInfo contactUsInfo) {

		return dao.addComments(contactUsInfo);
	}// End of addComments()

	@Override
	public List<BillHistory> findBillHistory(String rrNumber) {
		return dao.findBillHistory(rrNumber);
	}// End of findBillHistory()

	@Override
	public boolean payment(PaymentDetails paymentDetails, Double amountPaid) {
		if (amountPaid <= 0) {
			throw new ConsumerPaymentException("Please enter valid amount");
		}
		if (amountPaid.toString().startsWith("-")) {
			throw new ConsumerPaymentException("Please enter valid amount");
		}
		paymentDetails.setRemainingAmount(paymentDetails.getAmount() - amountPaid);

		return dao.payment(paymentDetails);
	}// End of payment()

}// End of class
