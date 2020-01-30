package com.bcits.discomusecase.consumerdao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.bean.ConsumerInfo;

@Repository
public class ConsumerDAOImpl implements ConsumerDAO{
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean signinConumer(ConsumerInfo consumerInfo) {
		EntityManager manager=factory.createEntityManager();
		
		if(consumerInfo!=null) {
			EntityTransaction transaction=manager.getTransaction();
			
			try {
				transaction.begin();
				manager.persist(consumerInfo);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				transaction.rollback();
			}
			manager.close();

			return true;
			
		}
		
		return false;
	}//End of signinConsumer()

}//End of repository
