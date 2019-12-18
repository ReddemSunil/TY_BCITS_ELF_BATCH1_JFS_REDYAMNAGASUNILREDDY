package com.sunil.sort;
public class SelectionSort
{
	static void sort(int[] a)
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
