package com.sunil.sort;

import java.util.Random;

public class BubbleSort
{
	public static void sort(int[] a)
	{
		for(int i=0;i<a.length;i++)
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
	public static void main(String[] args)
	{
		Random rd=new Random();
		int[] a=new int[100];
		for(int i=1;i<a.length;i++) {
			a[i]=rd.nextInt(100);
		}
		sort(a);
		for(int b:a)
		{
			System.out.println(b);
		}
		int[] i= {5,6,4,3,9,2,7,8,1};
		sort(i);
		for(int b:i)
		{
			System.out.println(b);
		}
	}

}
