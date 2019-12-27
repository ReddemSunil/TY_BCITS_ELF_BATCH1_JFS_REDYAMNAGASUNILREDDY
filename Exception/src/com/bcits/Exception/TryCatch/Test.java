package com.bcits.Exception.TryCatch;


public class Test {
	public static void main(String[] args) {
		String name=null;
		System.out.println("main start");
		try {
			System.out.println(name.length());
			System.out.println(10/0);
			
		}catch (ArithmeticException |NullPointerException e) {
			System.out.println(e.getMessage());
		}
		/*catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}*/
		/*try {
			try {
			System.out.println(name.length());}
			catch (NullPointerException e) {
				System.out.println(e.getMessage());   nested try catch block
			}
			System.out.println(10/0);
			
		}catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}*/
		System.out.println("main ended");
	}
}
