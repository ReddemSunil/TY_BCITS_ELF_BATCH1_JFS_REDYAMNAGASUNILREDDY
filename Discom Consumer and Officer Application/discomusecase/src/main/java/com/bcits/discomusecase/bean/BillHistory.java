package com.bcits.discomusecase.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "bill_history")
public class BillHistory {
	@EmbeddedId
	private BillHistoryPK moPk;
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
	@Column
	private String status;
	@Column
	private Double paidAmount;
}//End of class
