package com.bcits.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean getEntityManger() {
//		LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
//		factoryBean.setPersistenceUnitName("employee");
//		return factoryBean;
//	}//End of getEntityManager()
	
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManger() {
		LocalEntityManagerFactoryBean factoryBean=new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("employee");
		return factoryBean;
	}// End of getEntityManger()
	
	
	
}//End of class
