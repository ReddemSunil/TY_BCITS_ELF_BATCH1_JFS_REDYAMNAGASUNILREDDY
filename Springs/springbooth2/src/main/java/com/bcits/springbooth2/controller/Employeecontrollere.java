package com.bcits.springbooth2.controller;

import java.util.Optional;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springbooth2.beans.EmployeeInfoBean;
import com.bcits.springbooth2.repository.EmployeeRepository;

@RestController
public class Employeecontrollere {
	@Autowired
	private EmployeeRepository repository;

	@GetMapping(path = "/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeInfoBean getEmployee(int empId) {
		Optional<EmployeeInfoBean> info = repository.findById(empId);

		if (info.isPresent()) {
			return info.get();
		} else {
			return null;
		}
	}// End of getEmployee()

	@PostMapping(path = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeInfoBean addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		EmployeeInfoBean infobean = repository.save(employeeInfoBean);
		return infobean;
	}// End of addEmployee()
	
	
	@PutMapping(path = "/updateEmployee",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
	public EmployeeInfoBean updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		Optional<EmployeeInfoBean> op=repository.findById(employeeInfoBean.getEmpId());
		if (op.isPresent()) {
			
			EmployeeInfoBean infobean = repository.save(employeeInfoBean);
			return infobean;
		}else {
			return null;
		}
	}// End of updateEmployee()
	

	
	
}// End of class
