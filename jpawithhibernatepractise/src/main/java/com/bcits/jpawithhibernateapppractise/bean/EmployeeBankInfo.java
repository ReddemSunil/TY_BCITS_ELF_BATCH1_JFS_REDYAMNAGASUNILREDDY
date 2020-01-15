package com.bcits.jpawithhibernateapppractise.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_bankInfo")
public class EmployeeBankInfo {
	@Id
	@Column
	private int empId;
	@Column
	private long accountNo;
	@Column
	private String bankName;
	@Column
	private String branchName;
	@Column
	private String ifscCode;
	
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private EmployeePrimaryInfo primary;
}
