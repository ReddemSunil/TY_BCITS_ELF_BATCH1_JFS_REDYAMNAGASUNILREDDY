package com.bcits.Exception.CustomcheckedException;

public class Atm {
	public static void main(String[] args) {
		ATMSimulator a=new ATMSimulator();
		try {
			a.withDraw(41000);
		} catch (InsufficientBalance e) {
			System.out.println(e.getMessage());
		}
	}
}
