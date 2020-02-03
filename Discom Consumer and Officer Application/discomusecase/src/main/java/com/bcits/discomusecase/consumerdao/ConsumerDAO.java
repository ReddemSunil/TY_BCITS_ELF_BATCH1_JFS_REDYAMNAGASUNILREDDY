package com.bcits.discomusecase.consumerdao;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;

public interface ConsumerDAO {

	public ConsumerInfo authenticate(String rrNumber, String password);
	public boolean signinConumer(ConsumerInfo consumerInfo);
	public boolean updateConsumerProfile(ConsumerInfo consumerInfo);
	public ConsumerCurrentBill findBillDetailes(String rrNumber);
	
}// End of Interface
