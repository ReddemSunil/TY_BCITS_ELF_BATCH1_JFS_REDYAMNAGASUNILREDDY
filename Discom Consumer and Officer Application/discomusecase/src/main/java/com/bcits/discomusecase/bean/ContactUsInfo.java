package com.bcits.discomusecase.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "cotactUs_info")
public class ContactUsInfo implements Serializable{

	@Id
	@Column(name = "rr_number")
	private String rrNumber;
	@Column(name = "name")
	private String name;
	@Column
	private String mail;
	@Column
	private String comments;
}//End of class
