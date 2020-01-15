package com.bcits.empwebapp.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_primary_info")
public class EmployeePrimaryInfo implements Serializable {
	@Id
	@Column(name="emp_id")
	private int empId;
	@Column
	private String name;
	@Column
	private long mobileno;
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
	private double salary;
	@Column
	private int deptid;
	@Column(name="manager_id")
	private int managerId;
	@Column
	private String password;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getOfficialMail() {
		return officialMail;
	}
	public void setOfficialMail(String officialMail) {
		this.officialMail = officialMail;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/*
	 * public EmployeeSecondaryInfo getSecondaryInfo() { return secondaryInfo; }
	 * 
	 * public void setSecondaryInfo(EmployeeSecondaryInfo secondaryInfo) {
	 * this.secondaryInfo = secondaryInfo; }
	 * 
	 * public int getEmpid() { return empid; }
	 * 
	 * public void setEmpid(int empid) { this.empid = empid; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public long getMobileno() { return mobileno; }
	 * 
	 * public void setMobileno(long mobileno) { this.mobileno = mobileno; }
	 * 
	 * public String getOfficial_mail() { return official_mail; }
	 * 
	 * public void setOfficial_mail(String official_mail) { this.official_mail =
	 * official_mail; }
	 * 
	 * public Date getDate_of_birth() { return date_of_birth; }
	 * 
	 * public void setDate_of_birth(Date date_of_birth) { this.date_of_birth =
	 * date_of_birth; }
	 * 
	 * public Date getDate_of_joining() { return date_of_joining; }
	 * 
	 * public void setDate_of_joining(Date date_of_joining) { this.date_of_joining =
	 * date_of_joining; }
	 * 
	 * public String getDesignation() { return designation; }
	 * 
	 * public void setDesignation(String designation) { this.designation =
	 * designation; }
	 * 
	 * public String getBlood_group() { return blood_group; }
	 * 
	 * public void setBlood_group(String blood_group) { this.blood_group =
	 * blood_group; }
	 * 
	 * public double getSalary() { return salary; }
	 * 
	 * public void setSalary(double salary) { this.salary = salary; }
	 * 
	 * public int getDeptid() { return deptid; }
	 * 
	 * public void setDeptid(int deptid) { this.deptid = deptid; }
	 * 
	 * public int getManager_id() { return manager_id; }
	 * 
	 * public void setManager_id(int manager_id) { this.manager_id = manager_id; }
	 */

}
