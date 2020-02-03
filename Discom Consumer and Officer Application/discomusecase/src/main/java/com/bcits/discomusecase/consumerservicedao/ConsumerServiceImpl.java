package com.bcits.discomusecase.consumerservicedao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.consumerException.ConsumerException;
import com.bcits.discomusecase.consumerdao.ConsumerDAO;

@Service
public class ConsumerServiceImpl implements ConsumerServiceDAO {
	@Autowired
	private ConsumerDAO dao;

	@Override
	public ConsumerInfo authenticate(String rrNumber, String password) {
		for (int i = 0; i < rrNumber.length() - 1; i++) {
			if (rrNumber.charAt(i) < 0) {
				throw new ConsumerException("rrNumber Should Not Contains Negative Values");
			}

		}
		return dao.authenticate(rrNumber, password);
	}// End of authenticate()

	@Override
	public boolean signinConumer(ConsumerInfo consumerInfo, String cPassword, String rrNumber) {
		for (int i = 0; i < rrNumber.length() - 1; i++) {
			if (rrNumber.charAt(i) < 0) {
				throw new ConsumerException("rrNumber Should Not Contains Negative Values");
			}

		}
		if (!consumerInfo.getPassword().equals(cPassword)) {
			throw new ConsumerException("Password and ConfirmPassword Not Matched try Again!!");
		}
		return dao.signinConumer(consumerInfo);
	}// End of signinConsumer()

	@Override
	public boolean updateConsumerProfile(ConsumerInfo consumerInfo, String cPassword) {
		if ( !consumerInfo.getPassword().equals(cPassword)) {
			throw new ConsumerException("Password and ConfirmPassword Not Matched try Again!!");
		}
		return dao.updateConsumerProfile(consumerInfo);
	}//End of updateConsumerProfile()

	@Override
	public ConsumerCurrentBill findBillDetailes(String rrNumber) {

		return dao.findBillDetailes(rrNumber);
	}//End of findBillDetailes()

}// End of class
