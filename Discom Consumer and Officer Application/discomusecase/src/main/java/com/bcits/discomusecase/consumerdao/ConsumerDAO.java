package com.bcits.discomusecase.consumerdao;

import com.bcits.discomusecase.bean.ConsumerInfo;

public interface ConsumerDAO {

	public ConsumerInfo authenticate(String meterNumber, String password);
	public boolean signinConumer(ConsumerInfo consumerInfo);
}// End of Interface
