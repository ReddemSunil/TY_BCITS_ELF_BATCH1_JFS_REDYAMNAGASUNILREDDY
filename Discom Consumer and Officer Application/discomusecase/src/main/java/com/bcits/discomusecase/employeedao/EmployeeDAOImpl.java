package com.bcits.discomusecase.employeedao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.bean.ConsumerCurrentBill;
import com.bcits.discomusecase.bean.ConsumerInfo;
import com.bcits.discomusecase.bean.ContactUsInfo;
import com.bcits.discomusecase.bean.EmployeeInfo;
import com.bcits.discomusecase.bean.MonthlyConsumptionPK;
import com.bcits.discomusecase.bean.MonthlyConsumtion;
import com.bcits.discomusecase.bean.PaymentDetails;
import com.bcits.discomusecase.billtariff.BillTariff;

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
		Integer initialUnits=0;
		Double preAmount=0.0;
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ConsumerCurrentBill bill = manager.find(ConsumerCurrentBill.class, consumerCurrentBill.getRrNumber());
		ConsumerInfo info = manager.find(ConsumerInfo.class, consumerCurrentBill.getRrNumber());
		if (info != null) {
			if (bill!=null) {
				initialUnits = bill.getFinalUnits();
				preAmount=bill.getAmount();
				
				MonthlyConsumtion mConsumtion = new MonthlyConsumtion();
				mConsumtion.setAmount(bill.getAmount());
				mConsumtion.setDueDate(bill.getDueDate());
				mConsumtion.setFinalUnits(bill.getFinalUnits());
				mConsumtion.setInitialUnits(bill.getInitialUnits());
				mConsumtion.setUnitsConsumed(bill.getUnitsConsumed());
				MonthlyConsumptionPK mConsumptionPK = new MonthlyConsumptionPK();
				mConsumptionPK.setRrNumber(bill.getRrNumber());
				mConsumptionPK.setReadingsTakenOn(bill.getReadingsTakenOn());

				mConsumtion.setMoPk(mConsumptionPK);

				transaction.begin();
				manager.persist(mConsumtion);
				transaction.commit();
				
				BillTariff tariff = new BillTariff();
				Integer unitsConsumed = consumerCurrentBill.getFinalUnits() - initialUnits;
				Double amount = preAmount+ (tariff.claculateBill(unitsConsumed, info.getTypeOfConsumer()));
				try {
					transaction.begin();
					bill.setReadingsTakenOn(consumerCurrentBill.getReadingsTakenOn());
					bill.setDueDate(consumerCurrentBill.getDueDate());
					bill.setFinalUnits(consumerCurrentBill.getFinalUnits());
					bill.setInitialUnits(initialUnits);
					bill.setUnitsConsumed(unitsConsumed);
					bill.setAmount(amount);
					transaction.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				BillTariff tariff = new BillTariff();
				Integer unitsConsumed = consumerCurrentBill.getFinalUnits() - initialUnits;
				Double amount = preAmount+ (tariff.claculateBill(unitsConsumed, info.getTypeOfConsumer()));
				try {
					transaction.begin();
					consumerCurrentBill.setInitialUnits(initialUnits);
					consumerCurrentBill.setUnitsConsumed(unitsConsumed);
					consumerCurrentBill.setAmount(amount);
					manager.persist(consumerCurrentBill);
					transaction.commit();
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
	}//End of getComments()

	@Override
	public ConsumerInfo getConsumerInfo(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		ConsumerInfo consumerInfo = manager.find(ConsumerInfo.class, rrNumber);
		if (consumerInfo != null ) {
			return consumerInfo;
		} else {

			return null;
		}
	}//End of getConsumerInfo()

	@Override
	public ConsumerCurrentBill getConsumerCurrentBill(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		ConsumerCurrentBill consumerCurrentBill = manager.find(ConsumerCurrentBill.class, rrNumber);
		if (consumerCurrentBill != null ) {
			return consumerCurrentBill;
		} else {

			return null;
		}
	}//End of getConsumerCurrentBill()

	@Override
	public List<MonthlyConsumtion> getMonthlyConsumption(String rrNumber) {
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
	}//End of getMonthlyConsumption()

	@Override
	public PaymentDetails getPaymentDetails(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		PaymentDetails paymentDetails = manager.find(PaymentDetails.class, rrNumber);
		if (paymentDetails != null ) {
			return paymentDetails;
		} else {

			return null;
		}
	}//End of getPaymentDetails()

}// End of class
