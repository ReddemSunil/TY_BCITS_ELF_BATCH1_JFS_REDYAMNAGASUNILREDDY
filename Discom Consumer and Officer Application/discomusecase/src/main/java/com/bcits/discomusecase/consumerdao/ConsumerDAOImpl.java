package com.bcits.discomusecase.consumerdao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.MonthlyConsumtion;
import com.bcits.discomusecase.bean.PaymentDetails;

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

	@Override
	public boolean addComments(ContactUsInfo contactUsInfo) {
		EntityManager manager = factory.createEntityManager();

		if (contactUsInfo != null) {
			EntityTransaction transaction = manager.getTransaction();

			try {
				transaction.begin();
				manager.persist(contactUsInfo);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();
			return true;
		}

		return false;
	}// End of addComments()

	@Override
	public List<MonthlyConsumtion> findBillHistory(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from MonthlyConsumtion m where m.moPk.rrNumber = :id";
		Query query = manager.createQuery(jpql);
		query.setParameter("id", rrNumber);
		List<MonthlyConsumtion> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}// End of findBillHistory()

	@Override
	public boolean payment(PaymentDetails paymentDetails) {
		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		if (paymentDetails != null) {
			try {
				PaymentDetails paymentDetails2 = manager.find(PaymentDetails.class, paymentDetails.getRrNumber());
				if (paymentDetails2 != null) {
					paymentDetails2.setAmount(paymentDetails.getAmount());
					paymentDetails2.setAmountPaid(paymentDetails.getAmountPaid());
					paymentDetails2.setRemainingAmount(paymentDetails.getRemainingAmount());
					ConsumerCurrentBill consumerCurrentBill = manager.find(ConsumerCurrentBill.class,
							paymentDetails.getRrNumber());
					
					consumerCurrentBill.setAmount(consumerCurrentBill.getAmount()-paymentDetails.getAmountPaid());
				} else {
					manager.persist(paymentDetails);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			transaction.commit();
			manager.close();
			return true;
		}

		return false;
	}// End of payment()

}// End of repository
