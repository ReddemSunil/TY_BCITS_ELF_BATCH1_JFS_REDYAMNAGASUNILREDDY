package com.bcits.discomusecase.consumerdao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;

@Repository
public class ConsumerDAOImpl implements ConsumerDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public ConsumerInfo authenticate(String rrNumber, String password) {
		EntityManager manager = factory.createEntityManager();

		ConsumerInfo consumerInfo = manager.find(ConsumerInfo.class, rrNumber);
		if (consumerInfo != null && consumerInfo.getPassword().equals(password)) {
			return consumerInfo;
		} else {

			return null;
		}

	}// End of authenticate()

	@Override
	public boolean signinConumer(ConsumerInfo consumerInfo) {
		EntityManager manager = factory.createEntityManager();

		if (consumerInfo != null) {
			EntityTransaction transaction = manager.getTransaction();

			try {
				transaction.begin();
				manager.persist(consumerInfo);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();
			return true;
		}

		return false;
	}// End of signinConsumer()

	@Override
	public boolean updateConsumerProfile(ConsumerInfo consumerInfo) {
		if (consumerInfo != null) {
			EntityManager manager = factory.createEntityManager();

			EntityTransaction transaction = manager.getTransaction();
			ConsumerInfo consumerInfo2 = manager.find(ConsumerInfo.class, consumerInfo.getRrNumber());
			transaction.begin();
			if (consumerInfo.getContactNumber() != null
					&& !consumerInfo.getContactNumber().equals(consumerInfo2.getContactNumber())) {
				consumerInfo2.setContactNumber(consumerInfo.getContactNumber());
			}
			if (!consumerInfo.getMail().isEmpty() && consumerInfo.getMail() != null
					&& !consumerInfo.getMail().equals(consumerInfo2.getMail())) {
				consumerInfo2.setMail(consumerInfo.getMail());
			}
			if (!consumerInfo.getPassword().isEmpty() && consumerInfo.getPassword() != null
					&& !consumerInfo.getPassword().equals(consumerInfo2.getPassword())) {
				consumerInfo2.setPassword(consumerInfo.getPassword());
			}
			transaction.commit();
			return true;
		}
		return false;
	}// End of updateConsumerProfile()

	@Override
	public ConsumerCurrentBill findBillDetailes(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		ConsumerCurrentBill consumerCurrentBill = manager.find(ConsumerCurrentBill.class, rrNumber);

		return consumerCurrentBill;
	}// End of findBillDetailes()

}// End of repository
