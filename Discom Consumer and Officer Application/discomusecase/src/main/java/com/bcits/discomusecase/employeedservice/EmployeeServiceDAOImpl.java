package com.bcits.discomusecase.employeedservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;
import com.bcits.discomusecase.bean.MonthlyConsumtion;
import com.bcits.discomusecase.bean.PaymentDetails;
import com.bcits.discomusecase.consumerException.ConsumerException;
import com.bcits.discomusecase.employeedao.EmployeeDAO;

@Service
public class EmployeeServiceDAOImpl implements EmployeeServiceDAO {
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfo authenticate(int empId, String password) {
		if (empId < 1) {
			throw new ConsumerException("Employee Id Not Contains Negative Values");
		}
		return dao.authenticate(empId, password);
	}// End of authenticate()

	@Override
	public List<PaymentDetails> displayHome(String region) {
		return dao.displayHome(region);
	}//End of displayHome()

	@Override
	public boolean billUpdate(ConsumerCurrentBill consumerCurrentBill) {
		return dao.billUpdate(consumerCurrentBill);
	}//End of billUpdate()

	@Override
	public List<ContactUsInfo> getComments() {
		return dao.getComments();
	}//End of getComments()

	@Override
	public ConsumerInfo getConsumerInfo(String rrNumber) {
		return dao.getConsumerInfo(rrNumber);
	}//End of getConsumerInfo()

	@Override
	public ConsumerCurrentBill getConsumerCurrentBill(String rrNumber) {
		return dao.getConsumerCurrentBill(rrNumber);
	}//End of getConsumerCurrentBill()

	@Override
	public List<MonthlyConsumtion> getMonthlyConsumption(String rrNumber) {
		return dao.getMonthlyConsumption(rrNumber);
	}//End of getMonthlyConsumption()

	@Override
	public PaymentDetails getPaymentDetails(String rrNumber) {
		return dao.getPaymentDetails(rrNumber);
	}//End of getPaymentDetails()

}// End of class
