package com.ty.bcits.DataStructureAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class AlgorithmAnalysis
{
	public static Long addUpto(Long number)
	{
		Long total=0L;
		for(Long i=0L;i<=number;i++)
		{
			total=total+i;
		}
		return total;
	}
	public static Long addUptoQucik(Long number)
	{
		return number*(number+1)/2;
	}
	public static void countDurationAddUptoQuick()
	{
		Long number=99999999L;
		Instant start=Instant.now();
		System.out.println(addUptoQucik(number));
		Instant end=Instant.now();
		Long duration=Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("addUptoQucik took time"+seconds+" seconds");
	}
	public static void countDurationAddUpto()
	{
		Long number=99999999L;
		Instant start=Instant.now();
		System.out.println(addUpto(number));
		Instant end=Instant.now();
		Long duration=Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("addUpto took time"+seconds+" seconds");
	}
	public static void main(String[] args) 
	{
		countDurationAddUptoQuick();
		countDurationAddUpto();
	}

}
