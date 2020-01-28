package com.bcits.springrestjaxb.appmarshaltest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "user-address")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAddressBean {
	@XmlElement(name = "house-num")
	private int houseNum;
	@XmlElement
	private String street;
	@XmlElement
	private String city;
	@XmlElement(name = "address-type")
	private char addressType;
	
}
