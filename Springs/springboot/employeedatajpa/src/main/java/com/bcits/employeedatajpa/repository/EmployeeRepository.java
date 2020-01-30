package com.bcits.employeedatajpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bcits.employeedatajpa.bean.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer> {
	
//	@Query("from EmployeeInfoBean where empId=?1 and password=?2")
//	public EmployeeInfoBean findEmployeeManually(int empId,String password);
//	
	
	@Query("from EmployeeInfoBean where empId= :id and password= :pwd")
	public EmployeeInfoBean findEmployeeManually(int id,@Param("pwd")String password);
}// End of repository
