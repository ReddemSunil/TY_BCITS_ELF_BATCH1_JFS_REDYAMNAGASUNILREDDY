package com.bcits.Exception.chekedExceptionHandling;

public class Calculator {
	void division(int a,int b) {
		try {
			Class.forName("person");
		} catch (ClassNotFoundException e) {
			System.out.println("calss is not found");
		}
	}
}
