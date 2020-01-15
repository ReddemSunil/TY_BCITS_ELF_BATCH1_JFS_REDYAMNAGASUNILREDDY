package com.bcits.employeeeducationinfo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="educationtype_info")
public class EducationTypeInfo implements Serializable {
	@Id
	@Column
	private int empId;
	@Column
	private String educationType;
	@Column
	private String collegeName;
	@Column
	private Date yearOfPass;
	@Column
	private String stream;
	@Column
	private double percentage;
	@Column
	private String universityName;
}
