package com.ty.bcits.DataStructureAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class FactorialDuaration
{
	static int factorial(int n)
	{
		int fact=1;
		for(int i=1;i<=n;i++) 
		{                                                                                                         
			fact=fact*i;
		}
		return fact;
	}
	static int factorialRecorssion(int n)
	{
		if(n==1||n==0) return 1;
		return n*factorialRecorssion(n-1);
		
	}
	static void durationOfFactorial()
	{
		int num=9999;
		Instant start=Instant.now();
		System.out.println(factorial(num));
		Instant end=Instant.now();
		Long duration=Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("factorial took time"+seconds+" seconds");
	}
	static void durationOffactorialRecorssion()
	{
		int num=9999;
		Instant start=Instant.now();
		System.out.println(factorialRecorssion(num));
		Instant end=Instant.now();
		Long duration=Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("factorialRecorssion took time"+seconds+" seconds");
	}
	public static void main(String[] args)
	{
		durationOfFactorial();
		durationOffactorialRecorssion();
	}

}
