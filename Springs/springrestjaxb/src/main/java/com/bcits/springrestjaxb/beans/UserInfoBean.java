package com.bcits.springrestjaxb.beans;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import com.bcits.springrestjaxb.appmarshaltest.UserAddressBean;

import lombok.Data;

@Data
@JsonRootName("userInfo")
@XmlRootElement(name = "user-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserInfoBean  {
	
	@JsonProperty("employeeId")
	@XmlElement(name = "user-id")
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
	@XmlElement(name = "department-id")
	private int deptid;
	@XmlElement
	private int managerId;
	
	@XmlElement
	private UserOtheInfoBean userOtherInfo;
	
	@XmlElementWrapper(name = "user-address-list")
	private List<UserAddressBean> userAddressesList;
	
	@JsonIgnore
//	@XmlTransient//to avoid binding of the field to xml.
	@XmlElement
	private String password;
	
	

}//End of class
