package com.bcits.discomusecase.employeedservice;

import java.util.List;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;
import com.bcits.discomusecase.bean.BillHistory;
import com.bcits.discomusecase.bean.PaymentDetails;

public interface EmployeeServiceDAO {
	public EmployeeInfo authenticate(int empId, String password);

	public List<PaymentDetails> displayHome(String region);

	public boolean billUpdate(ConsumerCurrentBill consumerCurrentBill);

	public List<ContactUsInfo> getComments();

	public ConsumerInfo getConsumerInfo(String rrNumber);

	public ConsumerCurrentBill getConsumerCurrentBill(String rrNumber);

	public List<BillHistory> getMonthlyConsumption(String rrNumber);

	public PaymentDetails getPaymentDetails(String rrNumber);

	public List<ConsumerInfo> getAllConsumerDetails(String region);

	public List<ConsumerCurrentBill> getAllConsumerCurrentBills(String region);

	public PaymentDetails getMonthlyRevenue(String region);

}// End of interface
