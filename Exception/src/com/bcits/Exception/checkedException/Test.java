package com.bcits.Exception.checkedException;

public class Test {
	public static void main(String[] args) {
		System.out.println("main start");
		Person p=new Person();
		try {
			p.clone();
			System.out.println("object cloned"); 
		} catch (CloneNotSupportedException e) {
			e.getMessage();
		}
		System.out.println("main end");
	}
}
