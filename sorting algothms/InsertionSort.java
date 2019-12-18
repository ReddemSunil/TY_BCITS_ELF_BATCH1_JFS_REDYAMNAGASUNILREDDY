package com.sunil.sort;

public class InsertionSort 
{
	static void sort(int[] a)
	{
		for(int i=1;i<a.length;i++)
		{
			int key=a[i];
			int j=i-1;
			while(j>-1&&a[j]>key)
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=key;
		}
	}
	public static void main(String[] args)
	{
		int[] i= {5,6,4,3,9,2,7,8,1};
		sort(i);
		for(int a:i)
		{
			System.out.println(a);
		}
	}

}
