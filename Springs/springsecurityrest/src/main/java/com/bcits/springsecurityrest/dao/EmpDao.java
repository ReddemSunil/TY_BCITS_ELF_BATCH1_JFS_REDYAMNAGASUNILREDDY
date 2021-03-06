package com.bcits.springsecurityrest.dao;

import java.util.List;

import com.bcits.springsecurityrest.beans.EmpInfoBean;


public interface EmpDao {

	public boolean register(EmpInfoBean empInfoBean);

	public EmpInfoBean getEmployee(int empId);

	public List<EmpInfoBean> getAllEmployees();

}// End of DAO
