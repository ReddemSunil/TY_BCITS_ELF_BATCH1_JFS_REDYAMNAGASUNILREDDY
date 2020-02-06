package com.bcits.springsecuritymvc.dao;

import java.util.List;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;

public interface EmpDao {

	public boolean register(EmpInfoBean empInfoBean);

	public EmpInfoBean getEmployee(int empId);

	public List<EmpInfoBean> getAllEmployees();

}// End of DAO
