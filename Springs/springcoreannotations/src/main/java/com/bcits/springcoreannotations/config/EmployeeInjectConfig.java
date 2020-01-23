package com.bcits.springcoreannotations.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.bcits.springcoreannotations.beans.DepartmentBean;
import com.bcits.springcoreannotations.beans.EmployeeBean;

@Configurable
@Import(DepartmentConfig.class)
public class EmployeeInjectConfig { 
	@Bean
	public EmployeeBean getEmployeeBean() {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setName("sunil");
		employeeBean.setAge(21);
		
//		employeeBean.setDepartmentBean(getDepartmentBean());
		return employeeBean;
	}// End of getEmployeeBean()
	
}// End of class
