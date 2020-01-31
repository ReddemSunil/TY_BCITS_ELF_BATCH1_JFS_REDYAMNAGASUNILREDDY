package com.bcits.springbooth2.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName("employeeInfo")
@JsonPropertyOrder({"employeeId","name"})
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@Entity
@Table(name = "employee_primary_info")
public class EmployeeInfoBean {
	
	@JsonProperty("employeeId")
	@Id
	@Column(name="emp_id")
	private Integer empId;
	@Column
	private String name;
	@Column
	private Long mobileno;
	@Column(name="official_mail")
	private String officialMail;
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Column(name="date_of_joining")
	private Date dateOfJoining;
	@Column
	private String designation;
	@Column(name="blood_group")
	private String bloodGroup;
	@Column
	private Double salary;
	@Column
	private Integer deptid;
	@Column(name="manager_id")
	private Integer managerId;
	@Column
	private String password;
}