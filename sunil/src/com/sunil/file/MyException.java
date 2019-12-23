package com.sunil.file;

class MyException extends Exception
{
	String exception;
	MyException(String s)
	{
		this.exception=s;
		System.out.println(s);
	}
}
