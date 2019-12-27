package com.bcits.Exception.CustomcheckedException;

public class ATMSimulator {
	int balance=40000;
	void withDraw(int amount) throws InsufficientBalance {
		if(amount<balance)
		{
			System.out.println("withdraw amount is sucessfully");
		}
		else
			throw new InsufficientBalance();
	}
}
