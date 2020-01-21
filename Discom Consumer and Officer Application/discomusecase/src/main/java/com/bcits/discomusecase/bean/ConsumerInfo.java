package com.bcits.discomusecase.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="consumer_info")
public class ConsumerInfo implements Serializable{
	@Id
	@Column
	private long meterNumber;
	@Column
	private String password;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private long contactNumber;
	@Column
	private String mail;
	@Column
	private String region;
	@Column
	private String typeOfConsumer;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private int pincode;
	
	
	
}
