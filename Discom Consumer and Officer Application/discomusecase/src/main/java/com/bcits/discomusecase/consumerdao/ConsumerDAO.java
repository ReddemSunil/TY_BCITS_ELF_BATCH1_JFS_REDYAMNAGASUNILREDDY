package com.bcits.discomusecase.consumerdao;

import java.util.List;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.BillHistory;
import com.bcits.discomusecase.bean.PaymentDetails;

public interface ConsumerDAO {

	public ConsumerInfo authenticate(String rrNumber, String password);
	public boolean signinConumer(ConsumerInfo consumerInfo);
	public boolean updateConsumerProfile(ConsumerInfo consumerInfo);
	public ConsumerCurrentBill findBillDetailes(String rrNumber);
	public boolean addComments(ContactUsInfo contactUsInfo);
	public List<BillHistory> findBillHistory(String rrNumber);
	public boolean payment(PaymentDetails paymentDetails);
}// End of Interface
