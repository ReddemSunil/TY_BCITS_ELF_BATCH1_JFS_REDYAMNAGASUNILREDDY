package com.bcits.discomusecase.consumerservicedao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.consumerException.ConsumerException;
import com.bcits.discomusecase.consumerdao.ConsumerDAO;

@Service
public class ConsumerServiceImpl implements ConsumerServiceDAO {
	@Autowired
	private ConsumerDAO dao;

	@Override
	public boolean signinConumer(ConsumerInfo consumerInfo, String cPassword) {
		if (!consumerInfo.getPassword().equals(cPassword)) {
			throw new ConsumerException("Password and ConfirmPassword Not Matched try Again!!");
		}
		return dao.signinConumer(consumerInfo);
	}// End of signinConsumer()

}// End of class
