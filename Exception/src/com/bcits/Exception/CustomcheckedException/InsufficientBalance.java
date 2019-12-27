package com.bcits.Exception.CustomcheckedException;

public class InsufficientBalance extends Exception{
	String msg="insufficient balance";

	public InsufficientBalance() {
		super();
	}

	public InsufficientBalance(String msg) {
		super();
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.msg;
	}
			
}
