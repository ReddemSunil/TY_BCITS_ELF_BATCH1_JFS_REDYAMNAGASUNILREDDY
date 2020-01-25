package com.bcits.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManger() {
		LocalEntityManagerFactoryBean factoryBean=new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("employee");
		return factoryBean;
	}// End of getEntityManger()
}//End of class
