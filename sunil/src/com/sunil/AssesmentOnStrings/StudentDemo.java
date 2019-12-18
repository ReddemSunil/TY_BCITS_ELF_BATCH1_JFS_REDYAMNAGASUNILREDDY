package com.sunil.AssesmentOnStrings;
public class StudentDemo
{
	public static void main(String[] args) 
	{
		Object[] a=new Object[4];
		a[0]=new Student("sunil", 1, "eee");
		a[1]=new Student("charan", 2, "ece");
		a[2]=new Student("subbu", 3, "eee");
		a[3]=new Student("nag", 4, "eee");
		for(Object o:a)
		{
			System.out.println(o);
		}
	}

}
