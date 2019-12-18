package com.sunil.searching;

import com.sunil.sort.BubbleSort;

public class BinarySearch
{
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
	public static void main(String[] args) 
	{
		int[] i= {5,6,4,3,9,2,7,8,1};
		BubbleSort.sort(i);
		System.out.println(binarySearch(i,5));
	}

}
