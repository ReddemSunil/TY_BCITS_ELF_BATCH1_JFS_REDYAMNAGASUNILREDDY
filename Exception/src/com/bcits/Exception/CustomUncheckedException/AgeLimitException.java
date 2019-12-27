package com.bcits.Exception.CustomUncheckedException;

public class AgeLimitException extends RuntimeException{
	String msg="age is less than 18";
	public AgeLimitException() {
		// TODO Auto-generated constructor stub
	}
	public AgeLimitException(String msg) {
		this.msg = msg;
	}
      public String getMessage() {
    	  return this.msg;
      }
	}

