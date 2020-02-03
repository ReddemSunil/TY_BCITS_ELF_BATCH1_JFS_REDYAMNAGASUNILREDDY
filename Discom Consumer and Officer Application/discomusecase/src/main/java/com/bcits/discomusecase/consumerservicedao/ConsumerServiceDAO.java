package com.bcits.discomusecase.consumerservicedao;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;

public interface ConsumerServiceDAO {
	
	public ConsumerInfo authenticate(String rrNumber, String password);
	public boolean signinConumer(ConsumerInfo consumerInfo,String cPassword,String 	rrNumber);
	public boolean updateConsumerProfile(ConsumerInfo consumerInfo,String cPassword);
	public ConsumerCurrentBill findBillDetailes(String rrNumber);
}//End of interface
