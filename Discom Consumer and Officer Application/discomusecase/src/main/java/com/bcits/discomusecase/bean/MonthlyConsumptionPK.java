package com.bcits.discomusecase.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class MonthlyConsumptionPK implements Serializable{
	@Column(name = "rr_number")
	private String rrNumber;
	@Column(name = "readings_taken_on")
	private Date readingsTakenOn;
}//End of class
