package com.ty.bcits.DataStructureAlgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class SearchingDuration
{
	static int linearSearch(int[] a,int x)
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==x) return i;
		}
		return -1;
	}
	static int binarySearch(int[] a,int x)
	{
		int l=0;
		int h=a.length-1;
		while(l<=h)
		{
			int m=(l+h)/2;
			if(x==a[m]) return m;
			else if(x<a[m]) h=m-1;
			else l=m+1;
		}
		return -1;
	}
	static void countLinearSearch()
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a number");
		int n=scn.nextInt();
		int[] i=new int[n];
		for(int j=n-2;j>0;j--)
		{
			i[j]=j;
		}
		Instant start=Instant.now();
		linearSearch(i,n/2);
		Instant end=Instant.now();
		Long duration=Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("countDurationLinearSearch took time"+seconds+" seconds");
	}
	static void countBinarySearch()
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a number");
		int n=scn.nextInt();
		int[] i=new int[n];
		for(int j=n-2;j>0;j--)
		{
			i[j]=j;
		}
		Instant start=Instant.now();
		binarySearch(i,n/2);
		Instant end=Instant.now();
		Long duration=Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("countDurationBinarySearch took time"+seconds+" seconds");
	}
	public static void main(String[] args)
	{
		countBinarySearch();
		countLinearSearch();
	}

}
