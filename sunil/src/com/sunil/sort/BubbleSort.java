package com.sunil.sort;
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
		int[] i= {5,6,4,3,9,2,7,8,1};
		sort(i);
		for(int a:i)
		{
			System.out.println(a);
		}
	}

}
