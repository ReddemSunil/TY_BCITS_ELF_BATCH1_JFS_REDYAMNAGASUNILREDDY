package com.bcits.discomusecase.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "current_bill")
public class ConsumerCurrentBill implements Serializable {
	@Id
	@Column(name = "meter_number")
	private String meterNumber;
	@Column(name = "units_conumed")
	private Integer unitsConsumed;
	@Column
	private Double amount;
	@Column(name = "due_date")
	private Date dueDate;
	@Column(name = "final_units")
	private Integer finalUnits;
	@Column(name = "initial_units")
	private Integer initialUnits;
	@Column(name = "readings_taken_on")
	private Date readingsTakenOn;
}// End of class
