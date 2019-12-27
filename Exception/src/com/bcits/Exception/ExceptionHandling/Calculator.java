package com.bcits.Exception.ExceptionHandling;

import javax.crypto.AEADBadTagException;

public class Calculator {
	void add(int a , int b)
	{
		System.out.println(a+b);
	}
	void division(int a , int b) {
		try {
		System.out.println(a/b);
		}
		catch (ArithmeticException e) {
			System.out.println("MATh ERROR");
		}
	}
}
