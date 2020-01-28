package com.bcits.springrestjaxb.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@JsonRootName("userOtherInfo")
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserOtheInfoBean {
	@XmlElement
	private String gender;
	@XmlElement
	private long adhar;
}//End of class
