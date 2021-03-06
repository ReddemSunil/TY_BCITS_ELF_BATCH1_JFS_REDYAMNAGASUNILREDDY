package com.bcits.discomusecase.employeedao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;
import com.bcits.discomusecase.bean.BillHistoryPK;
import com.bcits.discomusecase.bean.BillHistory;
import com.bcits.discomusecase.bean.PaymentDetails;
import com.bcits.discomusecase.billtariff.BillTariff;
import com.bcits.discomusecase.mail.MailMail;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public EmployeeInfo authenticate(int empId, String password) {
		EntityManager manager = factory.createEntityManager();
		EmployeeInfo employeeInfo = manager.find(EmployeeInfo.class, empId);
		if (employeeInfo != null && employeeInfo.getPassword().equals(password)) {
			return employeeInfo;
		} else {

			return null;
		}
	}// End of authenticate()

	@Override
	public List<PaymentDetails> displayHome(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from PaymentDetails  where rrNumber in (select rrNumber from ConsumerInfo where region = :region)";
		Query query = manager.createQuery(jpql);
		query.setParameter("region", region);
		List<PaymentDetails> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}

	}// End of displayHome()

	@Override
	public boolean billUpdate(ConsumerCurrentBill consumerCurrentBill) {
		Integer initialUnits = 0;
		Double preAmount = 0.0;

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ConsumerCurrentBill bill = manager.find(ConsumerCurrentBill.class, consumerCurrentBill.getRrNumber());
		ConsumerInfo info = manager.find(ConsumerInfo.class, consumerCurrentBill.getRrNumber());

		if (info != null) {
			if (bill != null) {
				initialUnits = bill.getFinalUnits();
				preAmount = bill.getAmount() - bill.getPaidAmount();

				BillHistory billHistory = null;
				try {
					String jpql = "from BillHistory b  where b.moPk.rrNumber=:rrNumber and b.moPk.readingsTakenOn=:date";
					Query query = manager.createQuery(jpql);
					query.setParameter("rrNumber", consumerCurrentBill.getRrNumber());
					query.setParameter("date", bill.getReadingsTakenOn());
					billHistory = (BillHistory) query.getSingleResult();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				BillHistory mConsumtion = null;
				if (billHistory == null) {
					mConsumtion = new BillHistory();
					mConsumtion.setAmount(bill.getAmount());
					mConsumtion.setDueDate(bill.getDueDate());
					mConsumtion.setFinalUnits(bill.getFinalUnits());
					mConsumtion.setInitialUnits(bill.getInitialUnits());
					mConsumtion.setUnitsConsumed(bill.getUnitsConsumed());
					mConsumtion.setPaidAmount(bill.getPaidAmount());
					mConsumtion.setStatus(bill.getStatus());
					BillHistoryPK mConsumptionPK = new BillHistoryPK();
					mConsumptionPK.setRrNumber(bill.getRrNumber());
					mConsumptionPK.setReadingsTakenOn(bill.getReadingsTakenOn());

					mConsumtion.setMoPk(mConsumptionPK);
				}

				BillTariff tariff = new BillTariff();
				Integer unitsConsumed = consumerCurrentBill.getFinalUnits() - initialUnits;
				Double amount = preAmount + (tariff.claculateBill(unitsConsumed, info.getTypeOfConsumer()));
				try {
					transaction.begin();
					bill.setReadingsTakenOn(consumerCurrentBill.getReadingsTakenOn());
					bill.setDueDate(consumerCurrentBill.getDueDate());
					bill.setFinalUnits(consumerCurrentBill.getFinalUnits());
					bill.setInitialUnits(initialUnits);
					bill.setUnitsConsumed(unitsConsumed);
					bill.setAmount(amount);
					bill.setStatus("NotPaid");
					bill.setPaidAmount(0.0);
					transaction.commit();
					if (mConsumtion != null) {

						transaction.begin();
						manager.persist(mConsumtion);
						transaction.commit();
					}

					ApplicationContext context = new ClassPathXmlApplicationContext("discom-bean.xml");
					double cAmount = amount - preAmount;
					MailMail mm = (MailMail) context.getBean("mailMail");
					mm.sendMail("rnsunil.software@gmail.com", info.getMail(), "Current Bill", ("Dear Consumer,\nYour Monthly Consumption of Current bill is\n\n rrNumber = "
							+ bill.getRrNumber() + "\n contact Number = " + info.getContactNumber()
							+ "Dear Consumer,\nYour Monthly Consumption of Current bill is \n \n Consumed Units = "
							+ bill.getUnitsConsumed() + "\n Final Units = " + bill.getFinalUnits()
							+ "\n Initial Units = " + bill.getInitialUnits() + "\n Due Date = " + bill.getDueDate()
							+ "\n Readings Taken On = " + bill.getReadingsTakenOn() + "\n Due Amount = " + preAmount
							+ "\n current bill = " + cAmount + "\n Total Bill = " + bill.getAmount()));

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				BillTariff tariff = new BillTariff();
				Integer unitsConsumed = consumerCurrentBill.getFinalUnits() - initialUnits;
				Double amount = preAmount + (tariff.claculateBill(unitsConsumed, info.getTypeOfConsumer()));
				try {
					transaction.begin();
					consumerCurrentBill.setInitialUnits(initialUnits);
					consumerCurrentBill.setUnitsConsumed(unitsConsumed);
					consumerCurrentBill.setAmount(amount);
					consumerCurrentBill.setStatus("NotPaid");
					consumerCurrentBill.setPaidAmount(0.0);
					manager.persist(consumerCurrentBill);
					transaction.commit();

					ApplicationContext context = new ClassPathXmlApplicationContext("discom-bean.xml");
					double cAmount = consumerCurrentBill.getAmount();
					MailMail mm = (MailMail) context.getBean("mailMail");
					mm.sendMail("rnsunil.software@gmail.com", info.getMail(), "Current Bill",
							(" rrNumber = " + consumerCurrentBill.getRrNumber() + "Dear Consumer,\\\\nYour Monthly Consumption of Current bill is\n\n\n contact Number = "
									+ info.getContactNumber() + "\n Consumed Units = "
									+ consumerCurrentBill.getUnitsConsumed() + "\n Final Units = "
									+ consumerCurrentBill.getFinalUnits() + "\n Initial Units = "
									+ consumerCurrentBill.getInitialUnits() + "\n Due Date = "
									+ consumerCurrentBill.getDueDate() + "\n Readings Taken On = "
									+ consumerCurrentBill.getReadingsTakenOn() + "\n Due Amount = " + 0
									+ "\n current bill = " + cAmount + "\n Total Bill = " + cAmount));

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			manager.close();
			return true;
		}
		return false;
	}// End of billUpdate()

	@Override
	public List<ContactUsInfo> getComments() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ContactUsInfo";
		Query query = manager.createQuery(jpql);
		List<ContactUsInfo> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}// End of getComments()

	@Override
	public ConsumerInfo getConsumerInfo(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		ConsumerInfo consumerInfo = manager.find(ConsumerInfo.class, rrNumber);
		if (consumerInfo != null) {
			return consumerInfo;
		} else {

			return null;
		}
	}// End of getConsumerInfo()

	@Override
	public ConsumerCurrentBill getConsumerCurrentBill(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		ConsumerCurrentBill consumerCurrentBill = manager.find(ConsumerCurrentBill.class, rrNumber);
		if (consumerCurrentBill != null) {
			return consumerCurrentBill;
		} else {

			return null;
		}
	}// End of getConsumerCurrentBill()

	@Override
	public List<BillHistory> getBillHistory(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from BillHistory m where m.moPk.rrNumber = :id";
		Query query = manager.createQuery(jpql);
		query.setParameter("id", rrNumber);
		List<BillHistory> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}// End of getMonthlyConsumption()

	@Override
	public PaymentDetails getPaymentDetails(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		PaymentDetails paymentDetails = manager.find(PaymentDetails.class, rrNumber);
		if (paymentDetails != null) {
			return paymentDetails;
		} else {

			return null;
		}
	}// End of getPaymentDetails()

	@Override
	public List<ConsumerInfo> getAllConsumerDetails(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ConsumerInfo  where region = :region";
		Query query = manager.createQuery(jpql);
		query.setParameter("region", region);
		List<ConsumerInfo> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}// End of getAllConsumerDetails()

	@Override
	public List<ConsumerCurrentBill> getAllConsumerCurrentBills(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from com.bcits.discomusecase.bean.ConsumerCurrentBill where rrNumber in(select rrNumber from com.bcits.discomusecase.bean.ConsumerInfo where region=:region)";
		Query query = manager.createQuery(jpql);
		query.setParameter("region", region);
		List<ConsumerCurrentBill> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}// End of getAllConsumerCurrentBills()

	@Override
	public List<Object[]> getMonthlyRevenue(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select date_format(b.moPk.readingsTakenOn,'%Y-%m'),sum(amount),sum(paidAmount) from BillHistory b where b.moPk.rrNumber in(select rrNumber from ConsumerInfo where region=:region) group by month(b.moPk.readingsTakenOn)";
		Query query = manager.createQuery(jpql);
		query.setParameter("region", region);
		List<Object[]> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}// End of getMonthlyRevenue()

	@Override
	public ContactUsInfo displayResponsePage(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ContactUsInfo where rrNumber=:rrNumber";
		Query query = manager.createQuery(jpql);
		query.setParameter("rrNumber", rrNumber);
		ContactUsInfo contactUsInfo = (ContactUsInfo) query.getSingleResult();
		if (contactUsInfo != null) {
			return contactUsInfo;
		}
		return null;
	}// End of displayResponsePage()

	@Override
	public boolean sedingResponse(String suggestion, ContactUsInfo contactUsInfo) {
		if (suggestion != null && !suggestion.isEmpty()) {

			ApplicationContext context = new ClassPathXmlApplicationContext("discom-bean.xml");

			MailMail mm = (MailMail) context.getBean("mailMail");
			mm.sendMail("rnsunil.software@gmail.com", contactUsInfo.getMail(), "Giving Suggestion",
					"Your Question:" + contactUsInfo.getComments() + "\n \n Response:" + suggestion
							+ "\n \n If You have any queries Plese Login.. Our Portal and add Comments");
			return true;
		}
		return false;
	}// End of sendingResponse()

}// End of class
