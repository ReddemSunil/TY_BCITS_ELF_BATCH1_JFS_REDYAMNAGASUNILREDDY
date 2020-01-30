package com.bcits.discomusecase.consumerservicedao;

import com.bcits.discomusecase.bean.ConsumerInfo;

public interface ConsumerServiceDAO {
	
	public boolean signinConumer(ConsumerInfo consumerInfo,String cPassword);
}
