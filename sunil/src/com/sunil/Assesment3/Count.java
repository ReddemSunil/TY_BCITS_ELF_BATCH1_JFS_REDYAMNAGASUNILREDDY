package com.sunil.Assesment3;
public class Count
{
	private static int count;
	Count()
	{
		count++;
	}
	public static void main(String[] args) 
	{
		 Count c=new Count();
		 Count c1=new Count();
		 Count c2=new Count();
		 Count c3=new Count();
		 Count c4=new Count();
		 Count c5=new Count();
		System.out.println("no of objects created in a class is : "+count);
	}

}
