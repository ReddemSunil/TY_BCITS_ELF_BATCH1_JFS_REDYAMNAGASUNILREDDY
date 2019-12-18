package com.ty.bcits.DataStructureAlgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class SortedArray
{
	static void bubbleSort(int[] a)
	{
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=0;j<a.length-1-i;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	static void selectionSort(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			int index=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[index])
				{
					index=j;
				}
			}
			if(index!=i)
			{
				int temp=a[i]; 
				a[i]=a[index];
				a[index]=temp;
			}
		}
	}
	static void quickSort(int[] a,int low,int high)
	{
		int pivot=a[(low+high)/2];
		int i=low;
		int j=high;
		while(i<=j)
		{
			while(a[i]<pivot) i++;
			while(a[j]>pivot) j--;
			if(i<=j)
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;j--;
						
			}
		}
		if(low<j) quickSort(a,low,j);
		if(i<high) quickSort(a,i,high);
		
	}
	public static void countDurationBubbleSort()
	{
		
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a Array length");
		int n=scn.nextInt();
		int[] i=new int[n];
		for(int j=0;j<i.length;j++)
		{
			i[j]=j;
		}
		Instant start=Instant.now();
		bubbleSort(i);
		Instant end=Instant.now();
		Long duration=Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("countDurationBubbleSort took time"+seconds+" seconds");
	}
	public static void countDurationSelectionSort()
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a Array length");
		int n=scn.nextInt();
		int[] i=new int[n];
		for(int j=0;j<i.length;j++)
		{
			i[j]=j;
		}
		Instant start=Instant.now();
		selectionSort(i);
		Instant end=Instant.now();
		Long duration=Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("countDurationSelectionSort took time"+seconds+" seconds");
	}
	public static void countDurationQuickSort()
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a Array length");
		int n=scn.nextInt();
		int[] i=new int[n];
		for(int j=0;j<i.length;j++)
		{
			i[j]=j;
		}
		Instant start=Instant.now();
		quickSort(i,0,i.length-1);
		Instant end=Instant.now();
		Long duration=Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("countDurationquickSort took time"+seconds+" seconds");
	}
	public static void main(String[] args)
	{
		countDurationBubbleSort();
		countDurationSelectionSort();
		countDurationQuickSort();
	}

}
