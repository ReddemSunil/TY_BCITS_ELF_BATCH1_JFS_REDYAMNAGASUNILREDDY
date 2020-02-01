package com.bcits.discomusecase.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "consumer_info")
public class ConsumerInfo implements Serializable {
	@Id
	@Column(name = "meter_number")
	private String meterNumber;
	@Column
	private String password;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "contact_number")
	private Long contactNumber;
	@Column
	private String mail;
	@Column
	private String region;
	@Column(name = "type_of_consumer")
	private String typeOfConsumer;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private Integer pincode;

}// End of class
