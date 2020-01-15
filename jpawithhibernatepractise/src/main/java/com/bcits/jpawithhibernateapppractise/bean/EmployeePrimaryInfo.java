package com.bcits.jpawithhibernateapppractise.bean;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="employee_primaryinfo")
public class EmployeePrimaryInfo {
	@Id
	@Column
	private int empId;
	@Column
	private String name;
	@Column
	private long mobileno;
	@Column
	private String officialMail;
	@Column
	private Date dateOfBirth;
	@Column
	private Date dateOfJoining;
	@Column
	private String designation;
	@Column
	private String bloodGroup;
	@Column
	private double salary;
	@Column
	private int deptid;
	@Column
	private int managerId;
	
	@Exclude
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "primary")
	private EmployeeBankInfo bank;
}
