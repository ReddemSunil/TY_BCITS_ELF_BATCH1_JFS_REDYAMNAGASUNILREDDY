package com.bcits.springsecurityrest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_info")
public class EmpInfoBean {

	@Id
	@Column(name = "emp_id")
	private int empId;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private String name;
}//End of bean
