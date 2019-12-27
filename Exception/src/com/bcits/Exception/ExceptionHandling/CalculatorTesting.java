package com.bcits.Exception.ExceptionHandling;

public class CalculatorTesting {
	public static void main(String[] args) {
		Calculator c=new Calculator();
		c.division(100, 5);
		c.division(100, 0);
		c.division(100, 20);
		c.division (20 ,5);
	}
}
