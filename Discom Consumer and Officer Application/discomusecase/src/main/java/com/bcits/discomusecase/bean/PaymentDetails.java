package com.bcits.discomusecase.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "payment_details")
public class PaymentDetails implements Serializable{
	@Id
	@Column(name = "rr_Number")
	private String rrNumber;
	@Column
	private Double amount;
	@Column(name = "amount_paid")
	private Double amountPaid;
	@Column(name = "remaining_amount")
	private Double remainingAmount;
}//End of class
