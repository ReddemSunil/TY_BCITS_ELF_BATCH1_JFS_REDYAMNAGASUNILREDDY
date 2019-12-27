package com.bcits.ExceptionPropagation.TryCatch;

public class Test {
	public static void main(String[] args) {
		System.out.println("main starts");
		try {
		A.a();}
		catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ends");
	}
}
