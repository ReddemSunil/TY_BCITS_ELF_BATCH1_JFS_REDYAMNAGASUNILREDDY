package com.bcits.Exception.CustomUncheckedException;

public class Test {
	public static void main(String[] args) {
		System.out.println("main start");
		Election e=new Election();
		try {
		e.vote(10);}
		catch (AgeLimitException a) {
			System.out.println(a.getMessage());
		}
		System.out.println("main ends");
	}
}
