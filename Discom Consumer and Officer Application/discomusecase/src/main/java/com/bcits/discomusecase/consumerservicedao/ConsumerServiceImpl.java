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
	public ConsumerInfo authenticate(String meterNumber, String password) {
		for (int i = 0; i < meterNumber.length() - 1; i++) {
			if (meterNumber.charAt(i) < 0) {
				throw new ConsumerException("MeterNumber Should Not Contains Negative Values");
			}

		}
		return dao.authenticate(meterNumber, password);
	}// End of authenticate()

	@Override
	public boolean signinConumer(ConsumerInfo consumerInfo, String cPassword, String meterNumber) {
		for (int i = 0; i < meterNumber.length() - 1; i++) {
			if (meterNumber.charAt(i) < 0) {
				throw new ConsumerException("MeterNumber Should Not Contains Negative Values");
			}

		}
		if (!consumerInfo.getPassword().equals(cPassword)) {
			throw new ConsumerException("Password and ConfirmPassword Not Matched try Again!!");
		}
		return dao.signinConumer(consumerInfo);
	}// End of signinConsumer()

}// End of class
