package com.bcits.springcore.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class EmployeeBean {
	private String name;
	private int age;
	private DepartmentBean departmentBean;
	
}//end of class
