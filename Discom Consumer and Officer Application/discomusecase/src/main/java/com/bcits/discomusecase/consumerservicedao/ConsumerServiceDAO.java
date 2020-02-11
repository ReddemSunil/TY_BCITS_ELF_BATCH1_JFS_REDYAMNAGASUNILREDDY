package com.bcits.discomusecase.consumerservicedao;

import java.util.List;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.BillHistory;
import com.bcits.discomusecase.bean.PaymentDetails;

public interface ConsumerServiceDAO {
	
	public ConsumerInfo authenticate(String rrNumber, String password);
	public boolean signinConumer(ConsumerInfo consumerInfo,String cPassword,String 	rrNumber);
	public boolean updateConsumerProfile(ConsumerInfo consumerInfo,String cPassword);
	public ConsumerCurrentBill findBillDetailes(String rrNumber);
	public boolean addComments(ContactUsInfo contactUsInfo);
	public List<BillHistory> findBillHistory(String rrNumber);
	public boolean payment(PaymentDetails paymentDetails,Double amountPaid);
}//End of interface
