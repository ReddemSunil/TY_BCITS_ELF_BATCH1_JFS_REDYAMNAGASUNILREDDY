package com.sunil.file;

import java.util.Scanner;

public class Demo {

	static int balance=2000;
	public static void main(String[] args) throws MyException
	{
		
		Scanner scn=new Scanner(System.in);
		System.out.println("enter with draw amount");
		int withdraw=scn.nextInt();
				if(withdraw>balance)
				{
		            throw new MyException("less balance in your account");
				}
				else
				{
					balance=balance-withdraw;
					System.out.println("remain account balance is : "+balance);
				}
	}


}
