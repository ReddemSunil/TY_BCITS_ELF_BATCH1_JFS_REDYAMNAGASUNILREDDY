package com.bcits.springsecurityrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bcits.springsecurityrest.beans.EmpInfoBean;
import com.bcits.springsecurityrest.dao.EmpDao;

@Service
public class EmpServiceHibernateImpl implements EmpService {

	@Autowired
	private EmpDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean register(EmpInfoBean empInfoBean) {
		if (empInfoBean != null) {
			empInfoBean.setPassword(passwordEncoder.encode(empInfoBean.getPassword()));
			return dao.register(empInfoBean);
			
//			String rawPwd=empInfoBean.getPassword();
//			empInfoBean.setPassword(passwordEncoder.encode(rawPwd));
		}
		return false;
		
	}// End of register()

	@Override
	public EmpInfoBean getEmployee(int empId) {
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmpInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

}// End of service
