package com.sunil.sort;

public class QuickSort {
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
	public static void main(String[] args) {
		int[] i= {5,6,4,3,9,2,7,8,1};
		quickSort(i,0,i.length-1);
		for(int a:i)
		{
			System.out.println(a);
		}

	}

}
