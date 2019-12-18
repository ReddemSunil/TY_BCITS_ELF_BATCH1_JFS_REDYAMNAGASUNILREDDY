package com.sunil.searching;

public class LinearSearch 
{
	static int linearSearch(int[] a,int x)
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==x) return i;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		int[] i= {5,6,4,3,9,2,7,8,1};
		System.out.println(linearSearch(i,2));
	}
}
