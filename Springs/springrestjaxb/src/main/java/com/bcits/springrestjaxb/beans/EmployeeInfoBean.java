package com.bcits.springrestjaxb.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("employeeInfo")
@JsonPropertyOrder({"employeeId","name"})
@XmlRootElement(name = "employee-id")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeInfoBean  {
	
	@JsonProperty("employeeId")
	@XmlElement(name = "employee-id")
//	@XmlAttribute(name = "emp-id")
	private int empId;
	
	@XmlElement
//	@XmlAttribute
	private String name;
	@XmlElement
	private long mobileno;
	@XmlElement
	private String officialMail;
	@XmlElement
	private Date dateOfBirth;
	@XmlElement
	private Date dateOfJoining;
	@XmlElement
	private String designation;
	@XmlElement
	private String bloodGroup;
	@XmlElement
	private double salary;
	@JsonProperty("departmentId")
	@XmlElement(name = "department-id")
	private int deptid;
	@XmlElement
	private int managerId;

	@JsonIgnore
//	@XmlTransient//to avoid binding of the field to xml.
	@XmlElement
	private String password;
	
	

}//End of class
