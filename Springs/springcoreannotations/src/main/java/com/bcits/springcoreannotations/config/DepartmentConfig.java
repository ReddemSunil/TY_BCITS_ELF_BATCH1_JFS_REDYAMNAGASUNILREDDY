package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.DepartmentBean;
@Configuration
public class DepartmentConfig {
	@Bean(name="hr")
	public DepartmentBean getDeptDev() {
		DepartmentBean departmentBean=new DepartmentBean();
		departmentBean.setDeptId(10);
		departmentBean.setDeptName("HR");
		return departmentBean;
	}// End of getDeptDev()
	
	@Bean(name="dev")
	public DepartmentBean getDeptHr() {
		DepartmentBean departmentBean=new DepartmentBean();
		departmentBean.setDeptId(10);
		departmentBean.setDeptName("developer");
		return departmentBean;
	}// End of getDeptHr()
	
	@Bean(name="acc")
//	@Primary
	public DepartmentBean getDeptAccount() {
		DepartmentBean departmentBean=new DepartmentBean();
		departmentBean.setDeptId(10);
		departmentBean.setDeptName("account");
		return departmentBean;
	}// End of getDeptAccount()
}
