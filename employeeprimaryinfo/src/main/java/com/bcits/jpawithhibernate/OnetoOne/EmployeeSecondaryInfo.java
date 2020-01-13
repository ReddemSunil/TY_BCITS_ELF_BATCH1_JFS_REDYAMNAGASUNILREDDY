package com.bcits.jpawithhibernate.OnetoOne;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernateapppractise.bean.EmployeePrimaryInfo;

import lombok.Data;

@Data
@Entity
@Table(name="employee_secondary_info")
public class EmployeeSecondaryInfo implements Serializable{
	@Id
	@Column
	private int empid;
	@Column
	private String gender;
	@Column
	private String personalMail;
	@Column
	private int age;
	@Column
	private String nationality;
	@Column
	private String isMarried;
	@Column
	private String govId;
	@Column
	private String gourdianName;
	@Column
	private long gourdianContactNo;
	@Column
	private String jobLocation;
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empid")
	private EmployeePrimaryInfo primary;
	
	/*
	 * public int getEmpid() { return empid; } public void setEmpid(int empid) {
	 * this.empid = empid; } public String getGender() { return gender; } public
	 * void setGender(String gender) { this.gender = gender; } public String
	 * getPersonalMail() { return personalMail; } public void setPersonalMail(String
	 * personalMail) { this.personalMail = personalMail; } public int getAge() {
	 * return age; } public void setAge(int age) { this.age = age; } public String
	 * getNationality() { return nationality; } public void setNationality(String
	 * nationality) { this.nationality = nationality; } public String getIsMarried()
	 * { return isMarried; } public void setIsMarried(String isMarried) {
	 * this.isMarried = isMarried; } public String getGovId() { return govId; }
	 * public void setGovId(String govId) { this.govId = govId; } public String
	 * getGourdianName() { return gourdianName; } public void setGourdianName(String
	 * gourdianName) { this.gourdianName = gourdianName; } public long
	 * getGourdianContactNo() { return gourdianContactNo; } public void
	 * setGourdianContactNo(long gourdianContactNo) { this.gourdianContactNo =
	 * gourdianContactNo; } public String getJobLocation() { return jobLocation; }
	 * public void setJobLocation(String jobLocation) { this.jobLocation =
	 * jobLocation; } public EmployeePrimaryInfo getPrimary() { return primary; }
	 * public void setPrimary(EmployeePrimaryInfo primary) { this.primary = primary;
	 * }
	 */
	
	
	
	
	
	

}
