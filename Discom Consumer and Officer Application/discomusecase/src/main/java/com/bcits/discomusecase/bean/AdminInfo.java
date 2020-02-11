package com.bcits.discomusecase.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "admin_info")
public class AdminInfo {

	@Id
	@Column(name = "admin_id")
	private Integer adminId;
	@Column
	private String name;
	@Column
	private String password;
}// End of class
