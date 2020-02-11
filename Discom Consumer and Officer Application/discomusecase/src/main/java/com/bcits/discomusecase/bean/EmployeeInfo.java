package com.bcits.discomusecase.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
public class EmployeeInfo implements Serializable {

	@Id
	@Column(name = "employee_id")
	private Integer empId;
	@Column
	private String email;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private String designation;
	@Column
	private String region;
	@Column(name = "admin_id")
	private Integer adminId;
}// End of class
